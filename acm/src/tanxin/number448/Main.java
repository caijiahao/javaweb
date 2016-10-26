package tanxin.number448;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 寻找最大数
 * 时间限制：1000 ms  |  内存限制：65535 KB
难度：2
描述
请在整数 n 中删除m个数字, 使得余下的数字按原次序组成的新数最大，

比如当n=92081346718538，m=10时，则新的最大数是9888

 

输入
第一行输入一个正整数T，表示有T组测试数据
每组测试数据占一行，每行有两个数n,m（n可能是一个很大的整数，但其位数不超过100位，并且保证数据首位非0，m小于整数n的位数）
输出
每组测试数据的输出占一行，输出剩余的数字按原次序组成的最大新数
样例输入
2
92081346718538 10
1008908 5
样例输出
9888
98
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int caseNumber = Integer.parseInt(in.nextLine());
        while(caseNumber-->0){
        	
        	String[] number = in.nextLine().split(" ");
        	char[] ch = number[0].toCharArray();
        	int[] ch2Num = new int[ch.length];
        	int removeNum = Integer.parseInt(number[1]);
        	List<Integer> stringList = new ArrayList<Integer>();
        	
        	if(ch.length<removeNum){
        		System.out.println("-1");
        		break;
        	}
        	
        	int rest = ch.length-removeNum;
        	
        	for(int i=0;i<ch.length;i++){
        		ch2Num[i] = Integer.parseInt(ch[i]+"");
        	}
        	
        	int selectIndex = 0;
        	for(int i=rest;i>=1;i--){
        		int maxNumber = Integer.MIN_VALUE;
        		for(int j=selectIndex;j<=ch2Num.length-i;j++){
        			if(ch2Num[j]>maxNumber){
        				maxNumber = ch2Num[j];
        				selectIndex = j+1;
        			}
        		}
        		stringList.add(maxNumber);
        	}
        	
        	int sum = 0;
        	for(Integer i : stringList){
        		sum=sum*10+i;
        	}
        	
        	System.out.println(sum);
        }
	}
   
}

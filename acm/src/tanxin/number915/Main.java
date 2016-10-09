package tanxin.number915;

import java.util.Scanner;

/**
 * 
 * @author stevenfen
 * 题目描述:+-字符串
时间限制：1000 ms  |  内存限制：65535 KB
难度：1
描述
Shiva得到了两个只有加号和减号的字符串，字串长度相同。Shiva一次可以把一个加号和它相邻的减号交换。他想知道最少需要多少次操作才能把第一个字符串变换成第二个字符串。你现在要去帮助他完成那个这个问题。
输入
多组测试数据

每组数据有两行，每行包含一个由”+”和”-“最成的字符串。每个子符串长度不超过5000。
输出
仅一个整数，输出最少需要操作的次数。如果答案不存在，输出-1。
样例输入
++-+--+ 
-++--++ 
样例输出
4
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   char[] first = in.nextLine().toCharArray();
    	   char[] second = in.nextLine().toCharArray();
    	   int l11 = 0,l22=0,c=0;
    	   if(first.length!=second.length){
    		   System.out.println(-1);
    	   }
    	   else{
    		   
    	   for(int i=0;i<first.length;i++){
    		   l11++;
    	   }
    	   
    	   for(int i=0;i<second.length;i++){
    		   l22++;
    	   }
    	   
    	   if(l11!=l22){
    		   System.out.println(-1); 
    	   }else{
    	   		for(int i=0;i<first.length;i++){
    	   			if(first[i]!=second[i]){
    	   				for(int j=i+1;j<first.length;j++){
    	   					if(first[j]==second[i]){
    	   						c+=j-i;
    	   						first[j] = first[i];
    	   						break;
    	   					}
    	   				}
    	   			}
    	   		}
    	   		System.out.println(c);
    	   }
    	  }
       }
	}

}

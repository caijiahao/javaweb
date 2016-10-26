package tanxin.number448;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ѱ�������
 * ʱ�����ƣ�1000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�2
����
�������� n ��ɾ��m������, ʹ�����µ����ְ�ԭ������ɵ��������

���統n=92081346718538��m=10ʱ�����µ��������9888

 

����
��һ������һ��������T����ʾ��T���������
ÿ���������ռһ�У�ÿ����������n,m��n������һ���ܴ������������λ��������100λ�����ұ�֤������λ��0��mС������n��λ����
���
ÿ��������ݵ����ռһ�У����ʣ������ְ�ԭ������ɵ��������
��������
2
92081346718538 10
1008908 5
�������
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

package tanxin.number915;

import java.util.Scanner;

/**
 * 
 * @author stevenfen
 * ��Ŀ����:+-�ַ���
ʱ�����ƣ�1000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�1
����
Shiva�õ�������ֻ�мӺźͼ��ŵ��ַ������ִ�������ͬ��Shivaһ�ο��԰�һ���Ӻź������ڵļ��Ž���������֪��������Ҫ���ٴβ������ܰѵ�һ���ַ����任�ɵڶ����ַ�����������Ҫȥ����������Ǹ�������⡣
����
�����������

ÿ�����������У�ÿ�а���һ���ɡ�+���͡�-����ɵ��ַ�����ÿ���ӷ������Ȳ�����5000��
���
��һ�����������������Ҫ�����Ĵ���������𰸲����ڣ����-1��
��������
++-+--+ 
-++--++ 
�������
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

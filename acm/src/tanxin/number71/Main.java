package tanxin.number71;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author stevenfen
 * ��ľ���ϵ�����
ʱ�����ƣ�3000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�2
����
����һ�ζ�ľ�۵����л����ľ�ۿ����ڸۿ��⵽������֮��û������һ����ľ�����ֻ�ܳ��������ˣ��ҳ˿͵����������ܳ�����ľ�۵���������������Ҫ����������λ�еĻ���������Ҫ�ҳ����԰��������ÿ͵����ٵĶ�ľ��������������дһ�����򣬶����ľ�۵������������ÿ���Ŀ��ÿλ�ÿ͵����������ݸ����Ĺ��򣬼���Ҫ���������ÿͱ�������ٵĶ�ľ������������������

����
��һ������s,��ʾ�������ݵ�������
ÿ�����ݵĵ�һ�а�����������w��n��80<=w<=200,1<=n<=300��wΪһ����ľ�۵���������,nΪ������
��������һ������Ϊÿ���˵����������ܴ��ڴ��ĳ���������
���
ÿ����������Ҫ�����ٶ�ľ�۵�������
��������
3
85 6
5 84 85 80 84 83
90 3
90 45 60
100 5
50 50 90 40 60
�������
5
3
3
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      while(n-->0){
    	  int maxHeight = in.nextInt();
    	  int m = in.nextInt();
    	  int[] num = new int[m];
    	  int[] flag = new int[m];
    	  int count = 0 ;
    	  for(int i=0;i<m;i++){
    		  num[i] = in.nextInt();
    		  flag[i] = 0;
    	  }
    	  Arrays.sort(num);
    	  for(int i=0,j=m-1;i<=j;){
    		  if(num[i]+num[j]<=maxHeight){
    			  i++;
    			  j--;
    			  count++;
    		  }else if(i==j){
    			  count++;
    		  }else{
    			  j--;
    			  count++;
    		  }
    	  }
    	  System.out.println(count);
      }
	}

}

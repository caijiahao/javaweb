package tanxin.number71;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author stevenfen
 * 独木舟上的旅行
时间限制：3000 ms  |  内存限制：65535 KB
难度：2
描述
进行一次独木舟的旅行活动，独木舟可以在港口租到，并且之间没有区别。一条独木舟最多只能乘坐两个人，且乘客的总重量不能超过独木舟的最大承载量。我们要尽量减少这次活动中的花销，所以要找出可以安置所有旅客的最少的独木舟条数。现在请写一个程序，读入独木舟的最大承载量、旅客数目和每位旅客的重量。根据给出的规则，计算要安置所有旅客必须的最少的独木舟条数，并输出结果。

输入
第一行输入s,表示测试数据的组数；
每组数据的第一行包括两个整数w，n，80<=w<=200,1<=n<=300，w为一条独木舟的最大承载量,n为人数；
接下来的一组数据为每个人的重量（不能大于船的承载量）；
输出
每组人数所需要的最少独木舟的条数。
样例输入
3
85 6
5 84 85 80 84 83
90 3
90 45 60
100 5
50 50 90 40 60
样例输出
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

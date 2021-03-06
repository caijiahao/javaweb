package tanxin.number891;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       String[] split = null;
       while(input.hasNext()){
    	   int count = Integer.parseInt(input.nextLine());
    	   List<Point> pointList = new ArrayList<>();
    	   for(int i=0;i<count;i++){
    		   split = input.nextLine().split(" ");
    		   pointList.add(new Point(Integer.parseInt(split[0]),Integer.parseInt(split[1])));
    		   Collections.sort(pointList);
    	   }
    	   
    	   int left = Integer.MIN_VALUE;
    	   int right = Integer.MIN_VALUE;
    	   int sum = 0;
    	   
    	   for(Point point : pointList){
    		   //如果该区间的左边界大于前一个的右边界的话，则要取的点数就++ 
    		   if(point.getX()>right){
    			   sum++;
    			   left = point.getX();
    			   right = point.getY();
    		   }else{
    			   left = point.getX();
    			   if(point.getY()<right){
    				   right = point.getY();
    			   }
    		   }
    		   System.out.println("x:"+left);
    		   System.out.println("y:"+right);
    	   }
    	   System.out.println(sum);
       }
	}
}

class Point implements Comparable {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int compareTo(Object arg0) {
		Point point =(Point)arg0;	
		return point.x>x?-1:(point.x==x?0:1);
	}
	
}

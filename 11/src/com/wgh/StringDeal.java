package com.wgh;

public class StringDeal {
          public static String shiftEnter(String str){
        	  String newStr = str.replaceAll("\r\n", "<br>");
        	  newStr = newStr.replaceAll(" ", "&nbsp;");
        	  return newStr;
          }
}

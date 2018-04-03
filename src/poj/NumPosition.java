package poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 获取多位数每一位的数字
 * **/
public class NumPosition {
	
	public static String print(double num){
		String[] a1 = {"个","十","百","千","万","十万","千万","亿"};
		String[] a2 = {"十分","百分","千分","万分"};
		StringBuffer sb = new StringBuffer();
		String src = String.valueOf(num);
		String[] t = src.split("\\.");
		int length = t[0].length();
		for(int i=0;i<length;i++){
			int k = length-i;
			sb.append(a1[k-1]+":"+t[0].charAt(i)+" ");
		}
		length = t[1].length();
		for(int i=0;i<length;i++){
			sb.append(a2[i]+":"+t[1].charAt(i)+" ");
		}
		return sb.toString();
	}
	

	public static void main(String args[]){
		System.out.println("请输入数字");
		Scanner in = new Scanner(System.in);
        // 例如 "1234567890123456789012345678901234567890123456789"
        String inputString = in.nextLine();
        BigDecimal bigDecimal = new BigDecimal(inputString);
        String string = bigDecimal.toString();
//        char[] charArray = string.toCharArray();
//        StringBuffer buffer = new StringBuffer();
//        // 从个位数
//        for (int i = charArray.length - 1; i >= 0; i--)
//        {
//            System.out.println("第" + (charArray.length - i) + "位：" + charArray[i]);
//            buffer.append(charArray[i] + " ");
//        }
//        System.out.println(buffer.toString());
        StringBuffer buffer=new StringBuffer();
        String t[]=string.split("\\.");
        for(int i=0;i<t.length;i++){
        	if(i==0)
        		System.out.println("整数部分"+t[i]);
        	else      	{	
        		System.out.println("小数部分"+t[i]);
        		buffer.append(". ");
        		}
        	char str[]=t[i].toCharArray();
    		for(int j=0;j<str.length;j++){
    			System.out.println("第"+j+"位："+str[j]);
    			buffer.append(str[j]+" ");
    		}
        	
        }
        System.out.println(buffer.toString());
        
      
        
		
	}
}

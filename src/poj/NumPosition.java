package poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * ��ȡ��λ��ÿһλ������
 * **/
public class NumPosition {
	
	public static String print(double num){
		String[] a1 = {"��","ʮ","��","ǧ","��","ʮ��","ǧ��","��"};
		String[] a2 = {"ʮ��","�ٷ�","ǧ��","���"};
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
		System.out.println("����������");
		Scanner in = new Scanner(System.in);
        // ���� "1234567890123456789012345678901234567890123456789"
        String inputString = in.nextLine();
        BigDecimal bigDecimal = new BigDecimal(inputString);
        String string = bigDecimal.toString();
//        char[] charArray = string.toCharArray();
//        StringBuffer buffer = new StringBuffer();
//        // �Ӹ�λ��
//        for (int i = charArray.length - 1; i >= 0; i--)
//        {
//            System.out.println("��" + (charArray.length - i) + "λ��" + charArray[i]);
//            buffer.append(charArray[i] + " ");
//        }
//        System.out.println(buffer.toString());
        StringBuffer buffer=new StringBuffer();
        String t[]=string.split("\\.");
        for(int i=0;i<t.length;i++){
        	if(i==0)
        		System.out.println("��������"+t[i]);
        	else      	{	
        		System.out.println("С������"+t[i]);
        		buffer.append(". ");
        		}
        	char str[]=t[i].toCharArray();
    		for(int j=0;j<str.length;j++){
    			System.out.println("��"+j+"λ��"+str[j]);
    			buffer.append(str[j]+" ");
    		}
        	
        }
        System.out.println(buffer.toString());
        
      
        
		
	}
}

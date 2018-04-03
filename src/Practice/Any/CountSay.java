package Practice.Any;

//import java.util.Scanner;
/**
 * Ԥ����������Ϊ
 * 1,11,21,1211,111221,312211 blabla
 * ����һ������Ϊ1���ڶ�������������һ�����֣�һ��1��д������Ϊ11������ͬ��
 * **/

public class CountSay {
	public String countAndSay(int n) {
		String start="1";
		String result=start;
		for(int i=1;i<n;i++){
			result=getNextStr(result);			
		}
        return result;
    }
	
	public String getNextStr(String str){
		char a[]=str.toCharArray();
		String result="";
		int nNum=0;
		
		char aTemp=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(aTemp==a[i]){
				nNum++;
				}
			else{
				result+=Integer.toString(nNum)+aTemp;
				aTemp=a[i];
				nNum=1;
				}
		}
		result+=Integer.toString(nNum)+aTemp;
		return result;
	}
	
	public static void main(String[] args){
		CountSay s=new CountSay();
		System.out.println(s.countAndSay(1));
		System.out.println(s.countAndSay(3));
		System.out.println(s.countAndSay(5));
	}
}

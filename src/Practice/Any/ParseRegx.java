package Practice.Any;

import java.util.HashMap;
import java.util.Scanner;

/**
 * ????????????????????
 * ��B???????????????????????????"("??")"??"?"????????��???��????��?"?"?�I
 * ??????????????????????��????????????��????��????????????�I???"?"??????
 * ???????????��????????��??????????????????????????????��?
 * 
 * **/
//!!!!!!!!!!!!WARNING!!!!!!!!!!!!!!!!!!!
//	Input without the double quotation marks "" when you wanna input string in console
public class ParseRegx {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	
		String str[] = new String[100] ;
		int i=0;
		while(!input.hasNext("eof")){
			String temp = input.nextLine();
//			if(!temp.equals("eof")){
				str[i]=temp;
				i++;
			}
//		}
		System.out.print(str[i-1]);
		
		int j=0;
		int nQueStr[];//???????????????????????????????
		while(j<i){
			String str1 = str[j];
			int nQues=0;int k=0;
			int tempLeft=0;//????��???????????????????????????????????��????index=1
			for(;k<str1.length();k++){
				if(str1.charAt(k)=='?'){
					nQues++;
				}
				else if(str1.charAt(k)=='(')
					tempLeft++;
			}
			
			if(nQues%2!=0){
				System.out.println("-1");
				j=j+nQues;
				continue;
			}
			String cost[] = null;
			//????
			//???????�????????????cost?????????cost
			int costL[] = null;
			int costR[] = null;
			HashMap<Integer,Integer> mapLeft = new HashMap<Integer,Integer>();
			HashMap<Integer,Integer> mapRight = new HashMap<Integer,Integer>();
			for(int ki=1;ki<=nQues;ki++){
				cost[ki-1]=str[j+ki];
				String costt[]=cost[ki-1].split(" ");
				costL[ki-1]=Integer.parseInt(costt[0]);
				mapLeft.put( ki-1,costL[ki-1]);//key???????????????,value?cost?
				costR[ki-1]=Integer.parseInt(costt[1]);
				mapRight.put( ki-1,costL[ki-1]);//key???????????????,value?cost?
			}
			int nTCost=0;
			
			for(int m=0;m<nQues;m++){
				
			}
			
			
		}
	}
}

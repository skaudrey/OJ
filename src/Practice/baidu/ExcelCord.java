package Practice.baidu;

import java.util.Scanner;

/**
 * �������ת��
 * СB����Ե��ӱ�������Ũ�����Ȥ�������õ��ӱ������棬����Զ���������ǿ��
 * �������о����ǵ�Ԫ��������ţ�
 * �����ֱ��Ԫһ���ǰ��б�ŵģ���1�б��ΪA����2��ΪB���Դ����ƣ���26��ΪZ��
 * ֮������λ�ַ���ŵģ���27�б��ΪAA����28��ΪAB����52�б��ΪAZ��
 * ֮��������λ����λ����λ������ĸ��ŵģ��������ơ�
 * 
 * ���Ԫ���ڵ������ǰ���ֵ��1��ʼ��ŵģ����Ԫ�����������б�ź��б�ŵ���ϣ�
 * �絥Ԫ��BB22����ĵ�Ԫ��Ϊ54���е�22�еĵ�Ԫ��
 * СB����Ȥ���ǣ����ϵͳ��ʱҲ���Բ���RxCy�Ĺ�������x��yΪ��ֵ����ʾ��Ԫ��λ�ڵ�x��
 * ���е�y�С����������еĵ�Ԫ��������ֱ�����ϵʱ������ΪR22C54��
 * СBϣ������ʵ�����ֱ�ʾ֮���ת���������æ��Ƴ���һ�ַ�ʽ��ʾ������ת��Ϊ
 * ��һ�ַ�ʽ��
 * **/
public class ExcelCord {
	//�ַ�����R��ʼ��תbc��ʽ����֮תRC��ʽ
	
	//�ַ�����
	public static void main(String[] args){
		final String code[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
				"O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		Scanner input = new Scanner(System.in);
		Integer nSize = input.nextInt();
		String [] str = new String[nSize];
		int i=0;
		input.nextLine();
		while(i<nSize){
			str[i]=input.nextLine();
			i++;
			}
		
		
		String result="";
		
		for(i=0;i<nSize;i++){
			String temp= str[i];
			//RC��ʽ
			if(temp.startsWith("R")){
				int nC=temp.indexOf("C");
				String a1 = temp.substring(1, nC);
				int a2 = Integer.parseInt(temp.substring(nC+1));
				
				String code2="";
				while(a2!=0){
					code2+=code[a2%26-1];
					a2=a2/26;
				}
				code2 = new StringBuffer(code2).reverse().toString();
				result = code2 + a1;
						
			}
			//���к���
			else{
				//A��ASCIIֵΪ65
				int j=0;
				//�õ�������λ��
				while((temp.charAt(j))>='A')
					j++;
				
				String sC = temp.substring(0, j);
				String sR = temp.substring(j);
				int nC=0;
				int nSc=sC.length();
				for(int k=0,nIndex = nSc-1;k<nSc&&nIndex>=0;k++,nIndex--){
					int nn=sC.charAt(k)-'A'+1;
					int mm=(int) Math.pow(26,nIndex);
					nC+=nn*mm;
					
				}
				result = "R"+sR+"C"+nC;
			}
			System.out.println(result);
		}
	}

}

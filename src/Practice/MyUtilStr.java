package Practice;


/**
 * ʵ��c++��atoi����
 * ��Ҫ���������String���
 * 1.Stringǰ�пո����пո�
 * 2.String��ʾ��������ʱ��+��-
 * 3.String��ʾ���������ʱ
 * 4.String���з������ַ�ʱ����-1����ʾ����
 * **/
public class MyUtilStr {
	public int myAtoi(String str) {
		
		int i1=0;
		//ȥ��ǰ��Ŀո�
		char s1[]=str.toCharArray();
		while(s1[i1++]==' '){
			continue;
		}		
		i1--;
		int i2=i1;
		while(s1[i2]!=' '){
			//ASCIIֵ��+Ϊ43��-Ϊ45
			//�鿴�ַ����Ƿ�Ϸ�
			if((s1[i2]<'0'&&(s1[i2]!=43||s1[i2]!=45)&&(i2!=i1))
					||s1[i2]>'9')
				return -1;
			else
				i2++;
		}
			
		i2--;		
		String sint=str.substring(i1, i2);
		char strint[]=sint.toCharArray();
		
		boolean neg=false;		//���������
		int i=0;
		
		if(strint[0]=='+')
			i++;
		else if(strint[0]=='-'){
			i++;
			neg=true;
		}
			
		int nResult=0;	
		
		return neg?nResult:nResult*-1;
        
    }
}

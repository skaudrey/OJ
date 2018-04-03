package Practice;


/**
 * 实现c++的atoi函数
 * 需要考虑输入的String情况
 * 1.String前有空格或后有空格
 * 2.String表示整数或负数时的+，-
 * 3.String表示的数字溢出时
 * 4.String中有非数字字符时返回-1，表示出错
 * **/
public class MyUtilStr {
	public int myAtoi(String str) {
		
		int i1=0;
		//去除前后的空格
		char s1[]=str.toCharArray();
		while(s1[i1++]==' '){
			continue;
		}		
		i1--;
		int i2=i1;
		while(s1[i2]!=' '){
			//ASCII值：+为43，-为45
			//查看字符串是否合法
			if((s1[i2]<'0'&&(s1[i2]!=43||s1[i2]!=45)&&(i2!=i1))
					||s1[i2]>'9')
				return -1;
			else
				i2++;
		}
			
		i2--;		
		String sint=str.substring(i1, i2);
		char strint[]=sint.toCharArray();
		
		boolean neg=false;		//标记正负数
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

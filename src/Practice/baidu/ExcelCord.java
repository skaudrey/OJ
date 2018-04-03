package Practice.baidu;

import java.util.Scanner;

/**
 * 表格坐标转换
 * 小B最近对电子表格产生了浓厚的兴趣，她觉得电子表格很神奇，功能远比她想象的强大。
 * 她正在研究的是单元格的坐标编号，
 * 她发现表格单元一般是按列编号的，第1列编号为A，第2列为B，以此类推，第26列为Z。
 * 之后是两位字符编号的，第27列编号为AA，第28列为AB，第52列编号为AZ。
 * 之后则是三位、四位、五位……字母编号的，规则类似。
 * 
 * 表格单元所在的行则是按数值从1开始编号的，表格单元名称则是其列编号和行编号的组合，
 * 如单元格BB22代表的单元格为54列中第22行的单元格。
 * 小B感兴趣的是，编号系统有时也可以采用RxCy的规则，其中x和y为数值，表示单元格位于第x行
 * 的有第y列。上述例子中的单元格采用这种编码体系时的名称为R22C54。
 * 小B希望快速实现两种表示之间的转换，请你帮忙设计程序将一种方式表示的坐标转换为
 * 另一种方式。
 * **/
public class ExcelCord {
	//字符串：R开始的转bc格式，反之转RC格式
	
	//字符串：
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
			//RC格式
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
			//先列后行
			else{
				//A的ASCII值为65
				int j=0;
				//得到整数的位置
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

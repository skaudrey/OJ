package poj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.math.BigInteger;
import java.math.BigDecimal;

public class MyTemplate{
	public static void main(String[] args){
		/**������**/
		//�ַ�����
		Scanner inputS = new Scanner(System.in);
		while(inputS.hasNextLine()){
			String str = inputS.nextLine();
			}
		//������
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Integer i = input.nextInt();
			}
		System.out.println( );
		
		//TreeMapʹ�ã������ʵ�֣���ֵ�ԣ�Ĭ�ϰ���ֵkey��������
		// ���壺
		
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		Integer key = null;
		//�ж��Ƿ����ָ���ļ���key��
		if(map.containsKey(key))
			//��ȡkeyֵ����Ӧ��value��
			map.get(key);
		//��map�з����ֵ�ԣ�
		int value=0;
		map.put(key,value);
		//��ȡ����keyֵ��set�����У�
		Set<Integer> key1=map.keySet();
		//�������map�м�ֵ�ԣ�
		for (Integer mykey : map.keySet()) {
			System.out.println(key + " " + map.get(mykey));
			}
		//ArrayList��̬���飺

		//���壺
		ArrayList<String> set = new ArrayList<String>();
//		for(int i=0;i<num;i++) {
//			
//			String  str = s.nextLine();
//			//�ַ����������飺
//			set.add(str);
//			}
		//����������
		Collections.sort(set);
		//��������ַ������飺  
		for (String str : set) {
			System.out.println(str);
			}
		
		
		//�������飺  
		int []arr=new int[128];

		//�����󳤶ȣ�
		int len =arr.length;

		//�ַ����ĳ��ȣ�
		//int len =str.length();

		//�����ַ�����ĳ�ַ���λ�ã�

		///��ǰ����
		//str.IndexOf(" ");
		
		//��ǰ��������ո񣬷��ؿո��λ��
		
		//�Ӻ���ǰ��str.lastIndexOf(" ");
		
		//�Ӻ���ǰ�����ո񣬷��ؿո�λ��
		//�����ַ����е��ַ���
		//str.charAt(i);
		//�����ַ�
		//�ַ������Ϊ�ַ������飺
		//String strArr[]= str.split(" ");���Կո����ַ���Ϊ�ַ������飩

		 

		//�ַ���ת���ɴ�д��
		//str.toUpperCase();

		//�ַ���ת����Сд��
		//str.toLowerCase();

		//����ת��Ϊ�����ƣ�
		//String str = Integer.toBinaryString(n);��ת��Ϊ01�ַ�����ʽ��

		//�ַ���ת��Ϊ������
		//int i= Integer.parseInt(str,);  
		//int i= Integer.parseInt(str,16)���ַ���Ϊ16���Ƶģ�ת��Ϊʮ����������

		//����ת��Ϊ�ַ�����
				//String s=String.valueOf(i);  
				//string s=Integer.toString(i);

		//�ַ�ת��Ϊ������
				//str.charAt(i)-'0';
				//����str.charAt(i)-48��

		//�ַ�תΪ������int num = Integer.valueOf(ch[i]);

		//����ǿ��ת����
				//int n=(int)num;��numΪdouble�͵ģ�
				
				//���ַ���תΪ�ַ����飺
				//char ch[ ]=str.toCharArray();

		 

		//��ȡ�ַ�����
		//str.substring(0,8)����ȡλ��0��λ��7���Ӵ�
		//str.substring(8)����ȡ��λ��8��ĩβ���Ӵ�
		
		//0-9��48-57
		//A-Z��65-90
		//a-z��97-122
		
		
		}

	public static void testBigInteger(){
		BigInteger bi1 = new BigInteger("123456789");
		BigInteger bi2 = new BigInteger("987654321");
		System.out.println("Add operation:" + bi2.add(bi1));
		System.out.println("Add subtraction:" + bi2.subtract(bi1)); //subtraction
		System.out.println("Multiplication:" + bi2.multiply(bi1));
		System.out.println("Division:" + bi2.divide(bi1));
		System.out.println("Maximum:"+bi2.max(bi1));
		System.out.println("Minimum:"+bi2.min(bi1));
		BigInteger result[] = bi2.divideAndRemainder(bi1);
		System.out.println("���ǣ�" + result[0] +
				"�������ǣ�" + result[1]) ;
	}

	}




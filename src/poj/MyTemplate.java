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
		/**输入流**/
		//字符串：
		Scanner inputS = new Scanner(System.in);
		while(inputS.hasNextLine()){
			String str = inputS.nextLine();
			}
		//整数：
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Integer i = input.nextInt();
			}
		System.out.println( );
		
		//TreeMap使用：红黑树实现，键值对，默认按键值key升序排列
		// 定义：
		
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		Integer key = null;
		//判断是否包含指定的键名key：
		if(map.containsKey(key))
			//获取key值所对应的value：
			map.get(key);
		//往map中放入键值对：
		int value=0;
		map.put(key,value);
		//获取所有key值到set集合中：
		Set<Integer> key1=map.keySet();
		//遍历输出map中键值对：
		for (Integer mykey : map.keySet()) {
			System.out.println(key + " " + map.get(mykey));
			}
		//ArrayList动态数组：

		//定义：
		ArrayList<String> set = new ArrayList<String>();
//		for(int i=0;i<num;i++) {
//			
//			String  str = s.nextLine();
//			//字符串加入数组：
//			set.add(str);
//			}
		//按升序排序：
		Collections.sort(set);
		//遍历输出字符串数组：  
		for (String str : set) {
			System.out.println(str);
			}
		
		
		//定义数组：  
		int []arr=new int[128];

		//数组求长度：
		int len =arr.length;

		//字符串的长度：
		//int len =str.length();

		//检索字符串中某字符的位置：

		///从前往后：
		//str.IndexOf(" ");
		
		//从前往后检索空格，返回空格的位置
		
		//从后往前：str.lastIndexOf(" ");
		
		//从后往前检索空格，返回空格位置
		//检索字符串中的字符：
		//str.charAt(i);
		//返回字符
		//字符串拆分为字符串数组：
		//String strArr[]= str.split(" ");（以空格拆分字符串为字符串数组）

		 

		//字符串转换成大写：
		//str.toUpperCase();

		//字符串转换成小写：
		//str.toLowerCase();

		//整数转换为二进制：
		//String str = Integer.toBinaryString(n);（转换为01字符串形式）

		//字符串转换为整数：
		//int i= Integer.parseInt(str,);  
		//int i= Integer.parseInt(str,16)（字符串为16进制的，转换为十进制整数）

		//整数转换为字符串：
				//String s=String.valueOf(i);  
				//string s=Integer.toString(i);

		//字符转换为整数：
				//str.charAt(i)-'0';
				//或者str.charAt(i)-48；

		//字符转为整数：int num = Integer.valueOf(ch[i]);

		//类型强制转换：
				//int n=(int)num;（num为double型的）
				
				//将字符串转为字符数组：
				//char ch[ ]=str.toCharArray();

		 

		//截取字符串：
		//str.substring(0,8)：截取位置0到位置7的子串
		//str.substring(8)：截取从位置8到末尾的子串
		
		//0-9：48-57
		//A-Z：65-90
		//a-z：97-122
		
		
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
		System.out.println("商是：" + result[0] +
				"；余数是：" + result[1]) ;
	}

	}




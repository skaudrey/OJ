package poj;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 与日期时间相关的处理
 * 
 * public Date() {  
    this(System.currentTimeMillis());  
}  
public Date(long date) {  
    //other code  
}  
public long getTime() {   
    //other code   
}   
  
public void setTime(long time) {   
    //other code   
}  

 * **/


public class MyDateExample {
	
	/**
	 * 测试函数：
	 * //判断日期是否在when的之前
public boolean before(Date when) {   
    //other code   
}   
  
public boolean after(Date when) {   
    //other code   
}   
  
public int compareTo(Date anotherDate) {   
    //other code   
}  
	 * **/
	public void testBefAndAfterAndCompare(){
		 // 2008-08-08 20:00:00对应的毫秒数   
        long t2008 = 1218196800000L;   
        // 1900-01-01 20:00:00对应的毫秒数   
        long t1900 = -2208945952000L;   
  
        // 指定毫秒数创建Date对象   
        Date d2008 = new Date(t2008);   
        // 使用系统默认时间创建Date对象   
        Date d1900 = new Date();   
        // 通过设置毫秒数改变日期和时间   
        d1900.setTime(t1900);   
  
        System.out.println("调用方法：d1900.before(d2008)");   
        System.out   
                .print("比较结果：\"1900-01-01 20:00:00\"在\"2008-08-08 20:00:00\"");   
        // 使用before()方法比较   
        if (d1900.before(d2008)) {   
            System.out.println("之前");   
        } else {   
            System.out.println("之后");   
        }   
           
        System.out.println();   
           
        System.out.println("调用方法：d2008.after(d1900)");   
        System.out   
                .print("比较结果：\"2008-08-08 20:00:00\"在\"1900-01-01 20:00:00\"");   
        // 使用after()方法比较   
        if (d2008.after(d1900)) {   
            System.out.println("之后");   
        } else {   
            System.out.println("之前");   
        }   
           
        System.out.println();   
           
        System.out.println("调用方法：d1900.compareTo(d2008)");   
        System.out   
                .print("比较结果：\"1900-01-01 20:00:00\"在\"2008-08-08 20:00:00\"");   
        // 使用compareTo()方法比较   
        int i = d1900.compareTo(d2008);   
        if (i == -1) {   
            System.out.println("之前");   
        } else if (i == 1) {   
            System.out.println("之后");   
        } else if (i == 0) {   
            System.out.println("是同一时刻");   
        }   
    }   

	
	/**
	 * 测试函数：
	 * //判断日期是否在when的之前
public boolean before(Date when) {   
    //other code   
}   
  
public boolean after(Date when) {   
    //other code   
}   
  
public int compareTo(Date anotherDate) {   
    //other code   
}  
	 * **/
	  /**  
     * 以一种较为友好的方式格式化日期时间值  
     * Calendar
     *   
     * @param c  
     *            日期时间对象  
     * @return 格式化后的日期时间字符串  
     */  
    public static String toFriendlyString(Calendar c) {   
        if (c != null) {   
            DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");   
            return df.format(c.getTime());   
        }   
        return null;   
    }   
    /**
     *测试用Calendar来格式化日期时间
     * **/
    public void testCalenarFormat(){
    	Calendar c1 = Calendar.getInstance();   
        System.out.println("创建方式：Calendar.getInstance()");   
        System.out.println("日期时间：" + MyDateExample.toFriendlyString(c1));   
        System.out.println();   
  
        Calendar c2 = new GregorianCalendar();   
        System.out.println("创建方式：new GregorianCalendar()");   
        System.out.println("日期时间：" + MyDateExample.toFriendlyString(c2));   
        System.out.println();   
  
        // 参数含义依次为：年、月、日   
        Calendar c3 = new GregorianCalendar(2008, 8, 8);   
        System.out.println("创建方式：new GregorianCalendar(2008, 8, 8)");   
        System.out.println("日期时间：" + MyDateExample.toFriendlyString(c3));   
        System.out.println();   
  
        // 参数含义依次为：年、月、日、时、分   
        Calendar c4 = new GregorianCalendar(2008, 8, 8, 6, 10);   
        System.out.println("创建方式：new GregorianCalendar(2008, 8, 8, 6, 10)");   
        System.out.println("日期时间：" + MyDateExample.toFriendlyString(c4));   
        System.out.println();   
  
        // 参数含义依次为：年、月、日、时、分、秒   
        Calendar c5 = new GregorianCalendar(2008, 8, 8, 18, 10, 5);   
        System.out.println("创建方式：new GregorianCalendar(2008, 8, 8, 18, 10, 5)");   
        System.out.println("日期时间：" + MyDateExample.toFriendlyString(c5));   
    	
    }
    
    /**
     * 测试Calendar属性
     * **/
    public void TestCalendarAbbr(){
    	Calendar c = Calendar.getInstance();   
        System.out.println("当前时刻：" + MyDateExample.toFriendlyString(c));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.AM_PM");   
        System.out.println("代表含义：上下午标识，上午返回Calendar.AM=0，下午返回Calendar.PM=1");   
        System.out.println("测试结果：" + c.get(Calendar.AM_PM));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.DATE");   
        System.out.println("代表含义：一个月中的第几天，同Calendar.DAY_OF_MONTH");   
        System.out.println("测试结果：" + c.get(Calendar.DATE));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.DAY_OF_MONTH");   
        System.out.println("代表含义：一个月中的第几天，同Calendar.DATE");   
        System.out.println("测试结果：" + c.get(Calendar.DAY_OF_MONTH));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.DAY_OF_WEEK");   
        System.out.println("代表含义：一周中的第几天，对应星期几，第一天为星期日，于此类推。");   
        System.out.println("星期日:Calendar.SUNDAY=1");   
        System.out.println("星期一:Calendar.MONDAY=2");   
        System.out.println("星期二:Calendar.TUESDAY=3");   
        System.out.println("星期三:Calendar.WEDNESDAY=4");   
        System.out.println("星期四:Calendar.THURSDAY=5");   
        System.out.println("星期五:Calendar.FRIDAY=6");   
        System.out.println("星期六:Calendar.SATURDAY=7");   
        System.out.println("测试结果：" + c.get(Calendar.DAY_OF_WEEK));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.DAY_OF_WEEK_IN_MONTH");   
        System.out.println("代表含义：这一天所对应的星期几在该月中是第几次出现");   
        System.out.println("测试结果：" + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.DAY_OF_YEAR");   
        System.out.println("代表含义：一年中的第几天");   
        System.out.println("测试结果：" + c.get(Calendar.DAY_OF_YEAR));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.HOUR");   
        System.out.println("代表含义：12小时制下的小时数，中午和午夜表示为0");   
        System.out.println("测试结果：" + c.get(Calendar.HOUR));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.HOUR_OF_DAY");   
        System.out.println("代表含义：24小时制下的小时数，午夜表示为0");   
        System.out.println("测试结果：" + c.get(Calendar.HOUR_OF_DAY));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.MILLISECOND");   
        System.out.println("代表含义：毫秒数");   
        System.out.println("测试结果：" + c.get(Calendar.MILLISECOND));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.MINUTE");   
        System.out.println("代表含义：分钟");   
        System.out.println("测试结果：" + c.get(Calendar.MINUTE));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.MONTH");   
        System.out.println("代表含义：月份，从0到11表示12个月份，比实际月份值小1");   
        System.out.println("测试结果：" + c.get(Calendar.MONTH));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.SECOND");   
        System.out.println("代表含义：秒");   
        System.out.println("测试结果：" + c.get(Calendar.SECOND));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.WEEK_OF_MONTH");   
        System.out.println("代表含义：一个月中的第几个星期");   
        System.out.println("测试结果：" + c.get(Calendar.WEEK_OF_MONTH));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.WEEK_OF_YEAR");   
        System.out.println("代表含义：一年中的第几个星期");   
        System.out.println("测试结果：" + c.get(Calendar.WEEK_OF_YEAR));   
        System.out.println();   
  
        System.out.println("属性名称：Calendar.YEAR");   
        System.out.println("代表含义：年份");   
        System.out.println("测试结果：" + c.get(Calendar.YEAR));   
    	
    }
    
    /**
     * 测试不同模式格式化时间的结果
     * **/
    public void testFormatInDifPattern(){
    	// 使用系统当前日期时间值创建一个Date对象   
        Date now = new Date();   
  
        // 创建一个日期格式表达式   
        String pattern = "年代:G;年份:y;月份:M;日:d;时(1~12):h;时(0~23):H;分:m;秒:s;毫秒:S;星期:E;上/下午:a;时区:z";   
        // 使用日期格式表达式创建一个SimpleDateFormat对象   
        SimpleDateFormat df = new SimpleDateFormat(pattern);   
        // 调用SimpleDateFormat类的format(Date date)方法对Date对象进行格式化，并返回格式化后的字符串。   
        // 该方法继承自java.text.DateFormat类   
        System.out.println("1位：" + df.format(now));   
  
        // 创建一个新的日期格式表达式   
        pattern = "年代:GG;年份:yy;月份:MM;日:dd;时(1~12):hh;时(0~23):HH;分:mm;秒:ss;毫秒:SS;星期:EE;上/下午:aa;时区:zz";   
        // 调用SimpleDateFormat的applyPattern(String pattern)方法用新创建的日期格式表达式替换其原有的   
        df.applyPattern(pattern);   
        System.out.println("2位：" + df.format(now));   
  
        pattern = "年代:GGG;年份:yyy;月份:MMM;日:ddd;时(1~12):hhh;时(0~23):HHH;分:mmm;秒:sss;毫秒:SSS;星期:EEE;上/下午:aaa;时区:zzz";   
        df.applyPattern(pattern);   
        System.out.println("3位：" + df.format(now));   
  
        pattern = "年代:GGGG;年份:yyyy;月份:MMMM;日:dddd;时(1~12):hhhh;时(0~23):HHHH;分:mmmm;秒:ssss;毫秒:SSSS;星期:EEEE;上/下午:aaaa;时区:zzzz";   
        df.applyPattern(pattern);   
        System.out.println("4位：" + df.format(now));   
  
        pattern = "年代:GGGGG;年份:yyyyy;月份:MMMMM;日:ddddd;时(1~12):hhhhh;时(0~23):HHHHH;分:mmmmm;秒:sssss;毫秒:SSSSS;星期:EEEEE;上/下午:aaaaa;时区:zzzzz";   
        df.applyPattern(pattern);   
        System.out.println("5位：" + df.format(now));   
  
        pattern = "年代:GGGGGG;年份:yyyyyy;月份:MMMMMM;日:dddddd;时(1~12):hhhhhh;时(0~23):HHHHHH;分:mmmmmm;秒:ssssss;毫秒:SSSSSS;星期:EEEEEE;上/下午:aaaaaa;时区:zzzzzz";   
        df.applyPattern(pattern);   
        System.out.println("6位：" + df.format(now));   
    	
    }
    
    /***
     * 字符串转为date对象
     * @throws ParseException 
     * **/
    public void transStrToDate() throws ParseException{
    	  String s = "2008-08-08";   
          System.out.println("原始字符串：" + s);   
          String pattern = "yyyy-MM-dd";   
          System.out.println("对应表达式：" + pattern);   
          SimpleDateFormat df = new SimpleDateFormat(pattern);   
          Date date = df.parse(s);   
          System.out.println("转换后的值：" + date);   
          System.out.println();   
    
          s = "05年2月12日 18:04:33";   
          System.out.println("原始字符串：" + s);   
          pattern = "yy年M月d日 HH:mm:ss";   
          System.out.println("对应表达式：" + pattern);   
          df.applyPattern(pattern);   
          date = df.parse(s);   
          System.out.println("转换后的值：" + date);   
          System.out.println();   
    
          s = "16/5/2004 20:7:2.050";   
          System.out.println("原始字符串：" + s);   
          pattern = "d/M/yyyy HH:m:s.SSS";   
          System.out.println("对应表达式：" + pattern);   
          df.applyPattern(pattern);   
          date = df.parse(s);   
          System.out.println("转换后的值：" + date);   
    	
    }
    
    
}

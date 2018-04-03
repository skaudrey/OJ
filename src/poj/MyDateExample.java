package poj;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ������ʱ����صĴ���
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
	 * ���Ժ�����
	 * //�ж������Ƿ���when��֮ǰ
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
		 // 2008-08-08 20:00:00��Ӧ�ĺ�����   
        long t2008 = 1218196800000L;   
        // 1900-01-01 20:00:00��Ӧ�ĺ�����   
        long t1900 = -2208945952000L;   
  
        // ָ������������Date����   
        Date d2008 = new Date(t2008);   
        // ʹ��ϵͳĬ��ʱ�䴴��Date����   
        Date d1900 = new Date();   
        // ͨ�����ú������ı����ں�ʱ��   
        d1900.setTime(t1900);   
  
        System.out.println("���÷�����d1900.before(d2008)");   
        System.out   
                .print("�ȽϽ����\"1900-01-01 20:00:00\"��\"2008-08-08 20:00:00\"");   
        // ʹ��before()�����Ƚ�   
        if (d1900.before(d2008)) {   
            System.out.println("֮ǰ");   
        } else {   
            System.out.println("֮��");   
        }   
           
        System.out.println();   
           
        System.out.println("���÷�����d2008.after(d1900)");   
        System.out   
                .print("�ȽϽ����\"2008-08-08 20:00:00\"��\"1900-01-01 20:00:00\"");   
        // ʹ��after()�����Ƚ�   
        if (d2008.after(d1900)) {   
            System.out.println("֮��");   
        } else {   
            System.out.println("֮ǰ");   
        }   
           
        System.out.println();   
           
        System.out.println("���÷�����d1900.compareTo(d2008)");   
        System.out   
                .print("�ȽϽ����\"1900-01-01 20:00:00\"��\"2008-08-08 20:00:00\"");   
        // ʹ��compareTo()�����Ƚ�   
        int i = d1900.compareTo(d2008);   
        if (i == -1) {   
            System.out.println("֮ǰ");   
        } else if (i == 1) {   
            System.out.println("֮��");   
        } else if (i == 0) {   
            System.out.println("��ͬһʱ��");   
        }   
    }   

	
	/**
	 * ���Ժ�����
	 * //�ж������Ƿ���when��֮ǰ
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
     * ��һ�ֽ�Ϊ�Ѻõķ�ʽ��ʽ������ʱ��ֵ  
     * Calendar
     *   
     * @param c  
     *            ����ʱ�����  
     * @return ��ʽ���������ʱ���ַ���  
     */  
    public static String toFriendlyString(Calendar c) {   
        if (c != null) {   
            DateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");   
            return df.format(c.getTime());   
        }   
        return null;   
    }   
    /**
     *������Calendar����ʽ������ʱ��
     * **/
    public void testCalenarFormat(){
    	Calendar c1 = Calendar.getInstance();   
        System.out.println("������ʽ��Calendar.getInstance()");   
        System.out.println("����ʱ�䣺" + MyDateExample.toFriendlyString(c1));   
        System.out.println();   
  
        Calendar c2 = new GregorianCalendar();   
        System.out.println("������ʽ��new GregorianCalendar()");   
        System.out.println("����ʱ�䣺" + MyDateExample.toFriendlyString(c2));   
        System.out.println();   
  
        // ������������Ϊ���ꡢ�¡���   
        Calendar c3 = new GregorianCalendar(2008, 8, 8);   
        System.out.println("������ʽ��new GregorianCalendar(2008, 8, 8)");   
        System.out.println("����ʱ�䣺" + MyDateExample.toFriendlyString(c3));   
        System.out.println();   
  
        // ������������Ϊ���ꡢ�¡��ա�ʱ����   
        Calendar c4 = new GregorianCalendar(2008, 8, 8, 6, 10);   
        System.out.println("������ʽ��new GregorianCalendar(2008, 8, 8, 6, 10)");   
        System.out.println("����ʱ�䣺" + MyDateExample.toFriendlyString(c4));   
        System.out.println();   
  
        // ������������Ϊ���ꡢ�¡��ա�ʱ���֡���   
        Calendar c5 = new GregorianCalendar(2008, 8, 8, 18, 10, 5);   
        System.out.println("������ʽ��new GregorianCalendar(2008, 8, 8, 18, 10, 5)");   
        System.out.println("����ʱ�䣺" + MyDateExample.toFriendlyString(c5));   
    	
    }
    
    /**
     * ����Calendar����
     * **/
    public void TestCalendarAbbr(){
    	Calendar c = Calendar.getInstance();   
        System.out.println("��ǰʱ�̣�" + MyDateExample.toFriendlyString(c));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.AM_PM");   
        System.out.println("�����壺�������ʶ�����緵��Calendar.AM=0�����緵��Calendar.PM=1");   
        System.out.println("���Խ����" + c.get(Calendar.AM_PM));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.DATE");   
        System.out.println("�����壺һ�����еĵڼ��죬ͬCalendar.DAY_OF_MONTH");   
        System.out.println("���Խ����" + c.get(Calendar.DATE));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.DAY_OF_MONTH");   
        System.out.println("�����壺һ�����еĵڼ��죬ͬCalendar.DATE");   
        System.out.println("���Խ����" + c.get(Calendar.DAY_OF_MONTH));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.DAY_OF_WEEK");   
        System.out.println("�����壺һ���еĵڼ��죬��Ӧ���ڼ�����һ��Ϊ�����գ��ڴ����ơ�");   
        System.out.println("������:Calendar.SUNDAY=1");   
        System.out.println("����һ:Calendar.MONDAY=2");   
        System.out.println("���ڶ�:Calendar.TUESDAY=3");   
        System.out.println("������:Calendar.WEDNESDAY=4");   
        System.out.println("������:Calendar.THURSDAY=5");   
        System.out.println("������:Calendar.FRIDAY=6");   
        System.out.println("������:Calendar.SATURDAY=7");   
        System.out.println("���Խ����" + c.get(Calendar.DAY_OF_WEEK));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.DAY_OF_WEEK_IN_MONTH");   
        System.out.println("�����壺��һ������Ӧ�����ڼ��ڸ������ǵڼ��γ���");   
        System.out.println("���Խ����" + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.DAY_OF_YEAR");   
        System.out.println("�����壺һ���еĵڼ���");   
        System.out.println("���Խ����" + c.get(Calendar.DAY_OF_YEAR));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.HOUR");   
        System.out.println("�����壺12Сʱ���µ�Сʱ�����������ҹ��ʾΪ0");   
        System.out.println("���Խ����" + c.get(Calendar.HOUR));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.HOUR_OF_DAY");   
        System.out.println("�����壺24Сʱ���µ�Сʱ������ҹ��ʾΪ0");   
        System.out.println("���Խ����" + c.get(Calendar.HOUR_OF_DAY));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.MILLISECOND");   
        System.out.println("�����壺������");   
        System.out.println("���Խ����" + c.get(Calendar.MILLISECOND));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.MINUTE");   
        System.out.println("�����壺����");   
        System.out.println("���Խ����" + c.get(Calendar.MINUTE));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.MONTH");   
        System.out.println("�����壺�·ݣ���0��11��ʾ12���·ݣ���ʵ���·�ֵС1");   
        System.out.println("���Խ����" + c.get(Calendar.MONTH));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.SECOND");   
        System.out.println("�����壺��");   
        System.out.println("���Խ����" + c.get(Calendar.SECOND));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.WEEK_OF_MONTH");   
        System.out.println("�����壺һ�����еĵڼ�������");   
        System.out.println("���Խ����" + c.get(Calendar.WEEK_OF_MONTH));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.WEEK_OF_YEAR");   
        System.out.println("�����壺һ���еĵڼ�������");   
        System.out.println("���Խ����" + c.get(Calendar.WEEK_OF_YEAR));   
        System.out.println();   
  
        System.out.println("�������ƣ�Calendar.YEAR");   
        System.out.println("�����壺���");   
        System.out.println("���Խ����" + c.get(Calendar.YEAR));   
    	
    }
    
    /**
     * ���Բ�ͬģʽ��ʽ��ʱ��Ľ��
     * **/
    public void testFormatInDifPattern(){
    	// ʹ��ϵͳ��ǰ����ʱ��ֵ����һ��Date����   
        Date now = new Date();   
  
        // ����һ�����ڸ�ʽ���ʽ   
        String pattern = "���:G;���:y;�·�:M;��:d;ʱ(1~12):h;ʱ(0~23):H;��:m;��:s;����:S;����:E;��/����:a;ʱ��:z";   
        // ʹ�����ڸ�ʽ���ʽ����һ��SimpleDateFormat����   
        SimpleDateFormat df = new SimpleDateFormat(pattern);   
        // ����SimpleDateFormat���format(Date date)������Date������и�ʽ���������ظ�ʽ������ַ�����   
        // �÷����̳���java.text.DateFormat��   
        System.out.println("1λ��" + df.format(now));   
  
        // ����һ���µ����ڸ�ʽ���ʽ   
        pattern = "���:GG;���:yy;�·�:MM;��:dd;ʱ(1~12):hh;ʱ(0~23):HH;��:mm;��:ss;����:SS;����:EE;��/����:aa;ʱ��:zz";   
        // ����SimpleDateFormat��applyPattern(String pattern)�������´��������ڸ�ʽ���ʽ�滻��ԭ�е�   
        df.applyPattern(pattern);   
        System.out.println("2λ��" + df.format(now));   
  
        pattern = "���:GGG;���:yyy;�·�:MMM;��:ddd;ʱ(1~12):hhh;ʱ(0~23):HHH;��:mmm;��:sss;����:SSS;����:EEE;��/����:aaa;ʱ��:zzz";   
        df.applyPattern(pattern);   
        System.out.println("3λ��" + df.format(now));   
  
        pattern = "���:GGGG;���:yyyy;�·�:MMMM;��:dddd;ʱ(1~12):hhhh;ʱ(0~23):HHHH;��:mmmm;��:ssss;����:SSSS;����:EEEE;��/����:aaaa;ʱ��:zzzz";   
        df.applyPattern(pattern);   
        System.out.println("4λ��" + df.format(now));   
  
        pattern = "���:GGGGG;���:yyyyy;�·�:MMMMM;��:ddddd;ʱ(1~12):hhhhh;ʱ(0~23):HHHHH;��:mmmmm;��:sssss;����:SSSSS;����:EEEEE;��/����:aaaaa;ʱ��:zzzzz";   
        df.applyPattern(pattern);   
        System.out.println("5λ��" + df.format(now));   
  
        pattern = "���:GGGGGG;���:yyyyyy;�·�:MMMMMM;��:dddddd;ʱ(1~12):hhhhhh;ʱ(0~23):HHHHHH;��:mmmmmm;��:ssssss;����:SSSSSS;����:EEEEEE;��/����:aaaaaa;ʱ��:zzzzzz";   
        df.applyPattern(pattern);   
        System.out.println("6λ��" + df.format(now));   
    	
    }
    
    /***
     * �ַ���תΪdate����
     * @throws ParseException 
     * **/
    public void transStrToDate() throws ParseException{
    	  String s = "2008-08-08";   
          System.out.println("ԭʼ�ַ�����" + s);   
          String pattern = "yyyy-MM-dd";   
          System.out.println("��Ӧ���ʽ��" + pattern);   
          SimpleDateFormat df = new SimpleDateFormat(pattern);   
          Date date = df.parse(s);   
          System.out.println("ת�����ֵ��" + date);   
          System.out.println();   
    
          s = "05��2��12�� 18:04:33";   
          System.out.println("ԭʼ�ַ�����" + s);   
          pattern = "yy��M��d�� HH:mm:ss";   
          System.out.println("��Ӧ���ʽ��" + pattern);   
          df.applyPattern(pattern);   
          date = df.parse(s);   
          System.out.println("ת�����ֵ��" + date);   
          System.out.println();   
    
          s = "16/5/2004 20:7:2.050";   
          System.out.println("ԭʼ�ַ�����" + s);   
          pattern = "d/M/yyyy HH:m:s.SSS";   
          System.out.println("��Ӧ���ʽ��" + pattern);   
          df.applyPattern(pattern);   
          date = df.parse(s);   
          System.out.println("ת�����ֵ��" + date);   
    	
    }
    
    
}

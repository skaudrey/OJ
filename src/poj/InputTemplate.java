package poj;

/**
 * InputTemplate
 *
 * @author Mia Feng
 * @date 2018/3/21
 */

import java.io.*;
import java.util.*;


public class InputTemplate {
    public static void main(String[] args) {
//        String split
//        字符串"1.0,2.0;3.5,4.8,5.9;6.8,7.00,8.31"，将数字提取出来赋值给一个二维数组。b[][] = {{1,2},{3,4,5},{6,7,8}}
        String in = getInputStr();
        double[][] d = parseStr(in);
        for(int i=0; i<d.length;i++){
            for(int j=0; j<d[i].length;j++){
                System.out.print(String.format("%.2f,",d[i][j]));
            }
            System.out.println();
        }
    }

    public static String getInputStr() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            return reader.readLine();
        }catch (IOException e){e.printStackTrace();}
        return null;
    }

    public static double[][] parseStr(String str){
        String[] str1 = str.split(";");
        double[][] result = new double[str1.length][];

        for(int i=0; i<str1.length; i++){
            String[] str2 = str1[i].split(",");
            result[i] = new double[str2.length];
            for(int j=0; j<str2.length;j++){
                result[i][j] = Double.parseDouble(str2[j]);
            }
        }
        return result;
    }

    public static void useScanner(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please input strings:");
        while(true){
            String line = s.nextLine();
            if(line.equals("ok")) break;
            System.out.println(">>>"+line);
        }
    }

//    sc.next() will be ended with either blank or enter
    public static void DistinguishNextAndNextLine(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input some str");
        String str = sc.next(); // next will be ended with blank or enter.
        System.out.println("The output of next:" + str);
        String str1 = sc.nextLine();
        System.out.println("The output of nextLine"+str1);
    }

    public static void testBufferReader(){
        try {
            System.out.println("Please input the content that you want to show, end with new line <ok>");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String temp = new String(reader.readLine());
                System.out.println(">>>"+temp);
                if(temp.equals("ok"))   break;
            }
        }
        catch (IOException e){
            System.out.print("This file is not recorded correctly");
        }
    }
}

package Practice.meituan;

/**
 * compositeNum
 *
 * @author Mia Feng
 * @date 2018/3/22
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class compositeNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int[] keyChar = new int[10];
        for(int i=0; i< keyChar.length; i++){
            keyChar[i] = 0;
        }

//        System.out.println("key 0" + "value: " + Integer.toString(keyChar.get("0") ));

        int nMax = 0;
        for(int i=0; i<str.length(); i++){
            for (int j=0; j<=9; j++){
                if(str.charAt(i)-'0'==j){
                    keyChar[j] += 1;
                    if(keyChar[j]>nMax)
                        nMax = keyChar[j];
                }
            }
        }

//        int nTempSize = 2000;
        int[] strResult = new int[nMax*10];    //��¼�ַ���Ŀ��������С�Ķ�Ӧ���ַ�ֵ���������ƣ��ַ��������ٵ�����Ŀ��

        for(int i=0; i<nMax*10; i++)
            strResult[i] = -1;

        int nTempInd = 0;
        for(int i=0; i<= nMax; i++){
            for(int j=0; j< keyChar.length; j++){
                if(keyChar[j] == i )
                    strResult[nTempInd++] = j;
            }
        }

        System.out.println("fefw");
//        String result = "";
//        int result_num = 0;
//
//        int max_ops_num = 0;
//        for(int i = 0; i<=9; i++){
//            if(keyChar.get(Integer.toString(i))> max_ops_num){
//                max_ops_num =  keyChar.get(Integer.toString(i));
//            }
//        }
//
//        int min_ops_num = 2000;
//        String[] min_ops = new String[max_ops_num];
//
//        for(int j = max_ops_num-1; j>=0; j--){
//            String temp = "";
//            for(int i = 0; i<=9; i++){
//
//                if(keyChar.get(Integer.toString(i))<= min_ops_num){
//                    min_ops_num =  keyChar.get(Integer.toString(i));
//                    temp = Integer.toString(i);
//                }
//            }
//            min_ops[j] = temp;
//        }
//
//        System.out.println(min_ops);

    }
}

package Practice.NetBase;

import java.util.Scanner;

/**
 * OppositeNumber
 *
 * @author Mia Feng
 * @date 2018/3/27
 */
public class OppositeNumber {

    public static void main(String[] args){
//        int[] coins = {1,3,5};
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        String s = "" ;
        String temp = "";
        int nSizeInd = s.length()-1;
        for(int i = nSizeInd; i>=0; i--){
            temp += s.charAt(i);
        }


        System.out.println(Integer.parseInt(temp)+Integer.parseInt(s));
    }
}

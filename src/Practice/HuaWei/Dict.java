package Practice.HuaWei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Dict
 *
 * @author Mia Feng
 * @date 2018/3/28
 */
public class Dict {

    public static void main(String[] args) {
        HashMap<String,String> dict = new HashMap<>();
        dict.put("A","q");
        dict.put("B","w");
        dict.put("C","e");
        dict.put("D","r");
        dict.put("E","t");
        dict.put("F","y");
        dict.put("G","u");
        dict.put("H","i");
        dict.put("I","o");
        dict.put("J","p");
        dict.put("K","a");
        dict.put("L","s");
        dict.put("M","s");
        dict.put("N","f");
        dict.put("O","g");
        dict.put("P","h");
        dict.put("Q","j");
        dict.put("R","k");
        dict.put("S","l");
        dict.put("T","z");
        dict.put("U","z");
        dict.put("V","c");
        dict.put("W","v");
        dict.put("X","b");
        dict.put("Y","n");
        dict.put("Z","m");
        dict.put(".",".");
        dict.put(",",",");
        dict.put(":",":");
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        str = str.toUpperCase();

        String[] strTemp = str.split(" ");
        for(int i = 0; i<strTemp.length;i++){
            String temp = "";
            for(int j = 0;j<strTemp[i].length();j++){
                String t = dict.get(strTemp[i].substring(j,j+1));
                if(i==0 && j==0)
                    t = t.toUpperCase();
                temp += t;
            }
            System.out.print(temp);
            if(i!=strTemp.length-1)
                System.out.print(" ");
        }
    }

}

package Practice.HuaWei;

import java.util.Scanner;
/**
 * MaxContinuousSubSum
 *
 * @author Mia Feng
 * @date 2018/3/28
 */
public class MaxContinuousSubSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrStr = "";
        for(int i=0; i<1; i++){
            arrStr += sc.nextLine();
        }
        arrStr += arrStr.trim()+", ";
        String[] str = arrStr.split(", ");
        int[] array = new int[str.length+1];
        for(int i = 0; i < str.length; i++){
            array[i] = Integer.parseInt(str[i]);
        }
        int maximum = array[0];
        int maxTemp = 0;
        for (int i=0; i<array.length; i++){
            if(maxTemp>=0)
                maxTemp+= array[i];
            else
                maxTemp = array[i];
            if(maxTemp>maximum)
                maximum = maxTemp;
        }
        System.out.println(maximum);
    }
}

package Practice.HuaWei;

import java.util.Scanner;

/**
 * MaxWindowIndex
 *
 * @author Mia Feng
 * @date 2018/3/28
 */
public class MaxWindowIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] energy = new int[21];
        int i = 0;
        for(int j=0; j<21; j++){
            energy[j] = sc.nextInt();
        }
        int nTempSum = 0;
        int nTempIndex = 0;
        for(i = 0; i < energy.length-3; i++){
            if(energy[i]+energy[i+1]+energy[i+2]+energy[i+3]>nTempIndex){
                nTempIndex = i;
                nTempSum = energy[i]+energy[i+1]+energy[i+2]+energy[i+3];
            }
        }

        System.out.println(nTempIndex);
    }

}

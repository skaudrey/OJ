package Practice.Souhu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * KMinOfArray
 *
 * @author: Mia Feng
 * @date: 2018/4/14
 *
 *查找k个最小值我承认我又一次偷懒了
 */
public class KMinOfArray {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nSize = sc.nextInt();
        int k = sc.nextInt();
        int[] A  = new int[nSize];

        for(int i = 0; i<nSize; i++)
            A[i]  = sc.nextInt();

        Arrays.sort(A);

        for(int i = 0; i<k; i++){
            System.out.print(A[i]);
            if(i!=k-1)
                System.out.print(",");
        }
    }
}

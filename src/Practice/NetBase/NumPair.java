package Practice.NetBase;

import java.util.Scanner;

/**
 * NumPair
 *
 * @author Mia Feng
 * @date 2018/3/27
 */
public class NumPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nBound = sc.nextInt();
        int nMod = sc.nextInt();
        int nSize = 0;
        for(int i = nMod; i<=nBound;i++){
            for(int j = nMod ; j<=nBound;j++){
                if(i%j>=nMod ){
                    if(i!=nBound){
                        nSize += nBound-j;
                        break;
                    }
                    else
                        nSize++;

                }

            }
        }
        System.out.println(nSize);
    }

}

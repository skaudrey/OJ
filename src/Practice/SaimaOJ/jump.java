package Practice.SaimaOJ;

import java.util.Scanner;

/**
 * jump
 *
 * @author: Mia Feng
 * @date: 2018/4/18
 */
public class jump {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nSize = sc.nextInt();

        for(int i = 0; i<nSize; i++){
            int n = sc.nextInt();
            System.out.println(jumpFloor(n));
        }
    }

    public static int jumpFloor(int n){
        if(n<1)
            return -1;
        if(n==1)
            return 0;
        if(n==2)
            return 1;

        if(n==3)
            return 2;
        return jumpFloor(n-1)+jumpFloor(n-2);
    }

}

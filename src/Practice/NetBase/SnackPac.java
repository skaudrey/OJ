package Practice.NetBase;

import java.util.Scanner;

/**
 * SnackPac
 *
 * @author Mia Feng
 * @date 2018/3/27
 */
public class SnackPac {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int nCoins = sc.nextInt();

        int value = sc.nextInt();


        int[] coins = new int[value];

        for(int i=0; i<nCoins; i++){
            coins[i] = sc.nextInt();
        }

        int[] solution = new int[value];

        int min = solution(coins,value,solution);

        System.out.println(min);

        for(int i=value-1; i>=0;){
            System.out.println(solution[i]);
            System.out.println("-->");
            i = i - solution[i];
        }

    }


    public static int solution(int[] coins, int value, int[] solution){
        int[] mins = new int[value+1];

        for(int i=1; i<=value; i++)
            mins[i] = Integer.MAX_VALUE;


        for(int i=1; i<=value; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j]<=i && mins[i] > mins[i-coins[j]]+1){
                    mins[i] = mins[i-coins[j]]+1;
                    solution[i-1] = coins[j];
                }
            }
        }

        return mins[value];
    }

}

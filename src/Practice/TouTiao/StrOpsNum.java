package Practice.TouTiao;

import java.util.Scanner;

/**
 * StrOpsNum
 *
 * @author Mia Feng
 * @date 2018/3/24
 */
public class StrOpsNum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nLen = sc.nextInt();

    }

    public static int solution(int nLen,int[] solution){
        int[] sLen = new int[nLen+1];   //sLen[i]表示凑到长度为i时所需要的操作数目
        //solution 记录操作数目

        int[] mLen = new int[nLen];

        for(int i=1; i<= nLen; i++)
            solution[i] = Integer.MAX_VALUE;

        for(int i=0; i<nLen; i++){

        }

        return 0;
    }
}

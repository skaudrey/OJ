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

        char[] str = sc.next().toCharArray();

        int[] keyChar = new int[10];//记录每个数字出现的次数
        for(int i=0; i<str.length; i++){
            keyChar[str[i]-'0'] += 1;
        }
        // get the num with lowest frequency and the frequency amount
        int nMin = 0;
        int nNumOfMin = Integer.MAX_VALUE;
        for (int j=0; j<10; j++){
            if(keyChar[j]<nNumOfMin){
                nNumOfMin = keyChar[j];
                nMin = j;
            }
        }

        int nResult = impossibleNum(keyChar);

        System.out.println(nResult);

    }

    //根据各个数字的出现频率判断最不可能的数
    public static int impossibleNum(int[] frequencyArr){
        int nResult = 0;

        int nNone = -1;
        int nFrequencyNone = Integer.MAX_VALUE;

        //出现除0外，出现频率最低且对应的索引值最小的那一个
        for(int i=1; i<10;i++){
            if(nFrequencyNone>=frequencyArr[i] ){
                nFrequencyNone = frequencyArr[i];
            }
        }
        for(int i=1; i<10; i++){
            if(frequencyArr[i]==nFrequencyNone){
                nNone=i;
                break;
            }
        }

        //除0外的一个没出现
        if(nNone>0 && nFrequencyNone==0)
            nResult = nNone;

        else if(nNone>0 && nFrequencyNone>0 && frequencyArr[0]==0)
            nResult = 10;


        else{
            nResult = nNone;
            String str = "";
            if(nNone!=0){
                for(int m = 0; m<=nFrequencyNone; m++){
                    str+=Integer.toString(nNone);
                }
                nResult = Integer.parseInt(str);

            }
            else {
                nResult = 10^(nFrequencyNone+1);
            }
        }

        return nResult;
    }
}

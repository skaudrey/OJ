package Practice.NetBase;

import java.text.Format;
import java.util.Scanner;

/**
 * StrMeanLen
 *
 * @author Mia Feng
 * @date 2018/3/27
 *
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。

输入描述:
输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')


输出描述:
输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。

如样例所示: s = "aaabbaaac"
所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25

输入例子1:
aaabbaaac

输出例子1:
2.25
 */
public class StrMeanLen {
    public static void main(String[] args){
//        int[] coins = {1,3,5};
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        String s = "" ;
        int nStr = 1;
        int nSize = s.length();
        char nTemp = s.charAt(0);
        for(int i = 0; i < nSize; i++){
            if(nTemp!=s.charAt(i)){
                nStr++;
                nTemp = s.charAt(i);
            }
        }

        System.out.printf("%.2f",nSize/(nStr*1.0));
    }

}

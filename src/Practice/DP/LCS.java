package Practice.DP;

/**
 * LCS
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 * https://www.cnblogs.com/xudong-bupt/archive/2013/03/15/2959039.html
 * 求两个字符序列的公共最长子序列。例如字符序列abcbdb和字符序列acbbabdbb的最长公共子序列为acbdb。
 *
 * 一个字符串的子序列，是指从该字符串中去掉任意多个字符后剩下的字符在不改变顺序的情况下组成的新字符串。

　　最长公共子序列，是指多个字符串可具有的长度最大的公共的子序列。

 要对字符串的子序列理解清楚啊
L[i][j] = L[i - 1][j - 1] + 1，   xi等于yj

= max(L[i][j - 1], L[i - 1][j]),     xi不等于yj
设int[][] len = new int[str1.length+1][str2.length+1];记录最大长度（字符串str1从第1位到i位；字符串str2从第1位到第j位）

len[i][j] = len[i-1][j-1]+1;  if str1[i] == str2[j];
len[i][j] = max{len[i-1][j],len[i][j-1]};  if str1[i] != str2[j];

边界条件第0行和第0列均为0，即
len[i][0] = len[0][j] = 0

因为不只要求出最大长度，还要寻找到公共最长子序列，所以在填表len[i][j]过程中，再填一个表flags[i][j]
其中，数字"1"表示，斜向下；数字"2"表示，水平向右；数字"3"表示，竖直向下。
这样便于以后的求解最长公共子序列。

若str1[i]==str2[j], 设置flags[i][j] = 1;   由左上格斜向下到当前格

若str1[i]!=str2[j] && len[i + 1][j] >= len[i][j + 1], 设置 flags[i][j] = 2; 由左格向右到当前格

若str1[i]!=str2[j] && len[i + 1][j] < len[i][j + 1], 设置 flags[i][j] = 3;  由上格向下到当前格

最终只有标志为1 时相应位置上的字符串才是公共字符串

变形问题：
上次做头条碰见的，最少操作数目将两个字符串变成一样的：可以删除，改变或者增加

给定两个字符串，目的是将第一串转换成和第二串相同的字符串，可以有三种操作，
1、可以有增加、删除和改变的操作，删除即如果y中有，x没有，则在同位置y中可以删去，
改变是指，x中的字符可以改成跟Y中的字符一样的，
求得是最少几步可以将x字符串转换成y字符串

此题类似于求最长公共子序列，状态转移方程为

if(a[i-1]==b[j-1])      //相等再看下面的
    dp[i][j]=min(dp[i-1][j-1],dp[i-1][j]+1,dp[i][j-1]+1);
else    //不相等即改变
    dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
 */
public class LCS {

    public static void main(String[] args){
        String str1 = "abcbdb";
        String str2 = "acbbabdbb";

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        int[][] len = new int[str1.length()+1][str2.length()+1];
        int[][] flags = new int[str1.length()+1][str2.length()+1];

        int nCommonLen = -1;

        nCommonLen = maxCommonStr(array1,array2,len,flags);

        System.out.println("The length of maximum common string:  " + Integer.toString(nCommonLen));

        char[] result = new char[nCommonLen];

        getLCS(array1,array2,flags,result);

        System.out.println("The common string: ");
        for (int i=0; i<nCommonLen; i++)
            System.out.print(result[i]);

    }

    public static int maxCommonStr(char[] str1, char[] str2,int[][] len, int[][] flags){
        int m = str1.length;
        int n = str2.length;

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if(str1[i-1] == str2[j-1]){
                    flags[i][j] = 1;
                    len[i][j] = len[i-1][j-1]+1;
                }
                else if(len[i][j-1]>=len[i-1][j]){
                    flags[i][j] = 2;
                    len[i][j] = len[i][j-1];
                }
                else {
                    flags[i][j] = 3;
                    len[i][j] = len[i-1][j];
                }
            }
        }

        return len[m][n];
    }

    public static void getLCS(char[] str1, char[] str2, int[][] flags, char[] result){

        int m = str1.length;
        int n = str2.length;
        int resultIndex = result.length-1;
        for (int i = m,j= n; i>=0 && j>=0;){    //注意这里的索引值是从m，n开始的
            if(flags[i][j]==1){
                result[resultIndex--] = str1[i-1];  //注意取str1的索引是i-1位
                i--;
                j--;
            }
            else if(flags[i][j]==2){
                j--;    //反向向左
            }
            else
                i--;    //反向向上
        }

    }
}

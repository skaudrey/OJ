package Practice.DP;

/**
 * LongestIncreasedSequence
 *
 * @author Mia Feng
 * @date 2018/4/5
 *
 * 题目描述：



叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。同时我们应该让上面的人比下面的人更高一点。
已知参加游戏的每个人的身高，请编写代码计算通过选择参与游戏的人，我们多能叠多少个人。注意这里的人都是先后到的，
意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。

给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，请返回做多能叠的人数。保证n小于等于500。


测试样例：
[1,6,2,5,3,4],6
返回：4

题目分析：
设f(i)表示L中以ai为末元素的最长递增子序列的长度。则有如下的递推方程：

这个递推方程的意思是，在求以ai为末元素的最长递增子序列时，找到所有序号在L前面且小于ai的元素aj，
即j<i且aj<ai。如果这样的元素存在，那么对所有aj,都有一个以aj为末元素的最长递增子序列的长度f(j)，
把其中最大的f(j)选出来，那么f(i)就等于最大的f(j)加上1，即以ai为末元素的最长递增子序列，
等于以使f(j)最大的那个aj为末元素的递增子序列最末再加上ai；
如果这样的元素不存在，那么ai自身构成一个长度为1的以ai为末元素的递增子序列。
 */
public class LongestIncreasedSequence {
    public static void main(String[] args){
        int[] arr = {89,256,78,1,46,78,8};

        int nResult = getLIS(arr);
        System.out.println(nResult);
    }

    public static int getLIS(int[] A){
        int nLen = A.length;

        int[] dp = new int[nLen];

        for(int i = 0; i<nLen; i++){
            dp[i] = 1;  //这句不可少，以当前字符为终结，最小长度是1
            for(int j = 0; j<i; j++){   //依次计算当前字符之前的所有字符，确保dp数组中存的每一个元素都是从字符串开始位置到当前位置的LIS的长度
                if(A[j]<A[i])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }

        //遍历找到最长的那个数
        int nResult = 0;
        for(int i = 0; i<nLen;i++){
            if(nResult<dp[i])
                nResult = dp[i];
        }

        return nResult;
    }

}

package Practice.NiuKeOJ;

/**
 * UglyNumber
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * 剑指offer
 *
 * 题目描述
把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

嗯，自己的思路是先把抽数数组存下来再找。。内存溢出了。。

 其实可用动规的思想去做

//要注意，后面的丑数是有前一个丑数乘以2，3，5中的一个得来。因此可以用动态规划去解
//同时注意一下，题目意思应该是质数因此，而不是因子，因为8的因子有1，2，4，8

 */
public class UglyNumber {

//    private  int[] uglyNumber = new int[100000];   //0 for uglynumber, 1 for not-ugly number
//
//    private  int[] uglyArray = new int[50000];
//
    public static void main(String[] args){

        int n = 10;

        UglyNumber solver = new UglyNumber();

        int nResult =  solver.GetUglyNumber_Solution(n);
        System.out.println(nResult);

    }
//
//
//    public  void saveUglyNumber() {
//
//        uglyNumber[0] = 1;
//
//        for(int i = 1; i<100000; i++){
//            if(i%4!=0 || i%6!=0 || i%7!=0 || i%8!=0 || i%9!=0)
//                uglyNumber[i] = 1;
//        }
//
//        int nIndex = 0;
//        for(int i = 0; i<100000; i++){
//            if(uglyNumber[i]==0 && nIndex<50000)
//                uglyArray[nIndex++] = i;
//        }
//
//    }
//
//    public  int GetUglyNumber_Solution(int index) {
//
//        if(index<Integer.MAX_VALUE)
//            return uglyArray[index-1];
//
//        return 0;
//    }


    int GetUglyNumber_Solution(int index) {

        if(index<=0)
            return 0;
        if (index==1)
            return 1;

        int[] ugly = new int[index];

        ugly[0] = 1;
        int i1=0,i2=0,i3=0;

        for(int i = 1; i<index;i++){
            ugly[i] = Math.min(ugly[i1]*2,Math.min(ugly[i2]*3,ugly[i3]*5)); //注意是i1，i2和i3

            if(ugly[i]==ugly[i1]*2)
                i1++;
            if(ugly[i]==ugly[i2]*3)
                i2++;
            if(ugly[i]==ugly[i3]*5)
                i3++;
        }

        return ugly[index-1];
    }
}

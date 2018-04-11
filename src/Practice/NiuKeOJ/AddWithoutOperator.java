package Practice.NiuKeOJ;

/**
 * AddWithoutOperator
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * 剑指offer
 *
 * 题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

思路：位运算
两个数异或：相当于每一位相加，而不考虑进位；(num1^num2)
两个数相与，并左移一位：相当于求得进位；(num1&num2)<<1
将上述两步的结果相加
 */
public class AddWithoutOperator {

    public int Add(int num1,int num2) {
        while(num2!=0){
            int tmp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = tmp;
        }
        return num1;
    }


}

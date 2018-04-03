package Practice.NiuKeOJ;

/**
 * power
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 *
 * 剑指offer
 *
 * 题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class power {

    public static void main(String[] args){
        double base = 2.0;
        int exponent = 3;
        double temp = Math.pow(base,exponent);
        System.out.println(temp);
    }
}

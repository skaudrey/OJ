package Practice.NetBase;

import java.util.Scanner;

/**
 * MagicCoin
 *
 * @author Mia Feng
 * @date 2018/3/27
 *
 * 网易游戏的编程题
 *
 * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
输入描述:
输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。


输出描述:
输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。

输入例子1:
10

输出例子1:
122
 */
public class MagicCoin {
    public static void main(String[] args){
//        int[] coins = {1,3,5};
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        String s = "" ;
        while (value!=0){
            if(value%2==0){
                s += '2';
                value = (value-2)/2;
            }else{
                s += '1';
                value = (value-1)/2;
            }
        }
        for(int i = s.length()-1; i>=0; i--){
            System.out.print(s.charAt(i));
        }



    }

}





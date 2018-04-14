package Practice.NiuKeOJ;

/**
 * parseInt
 *
 * @author: Mia Feng
 * @date: 2018/4/12
 *
 * 剑指offer
 *
 * 题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
示例1
输入
+2147483647
1a33
输出
2147483647
0

边界条件：
数据上下 溢出
空字符串
只有正负号
有无正负号
错误标志输出


 好吧我的方法吧。。溢出了
 */
public class parseInt {

    public static void main(String[] args){
        String str = "+";

        StrToInt(str);
    }

    public static int StrToInt(String str) {
        if(str==null || str.length()==0)
            return 0;

        char[] array = str.toCharArray();
        int i = 0;
        int nLen = str.length();
        boolean isLeagal = true;
        while(i<nLen ){
            if(array[i]>'9')
                isLeagal = false;
            i++;
        }

        if(!isLeagal)
            return 0;

        int nBegin = 0;

        boolean isPositive = true;
        if(array[0]<'0'){
            nBegin = 1;
            if(array[0]=='-')
                isPositive = false;
        }
        else{
            isPositive = true;
            nBegin = 0;
        }

        String sTmp  = str.substring(nBegin);
        if(sTmp==null || sTmp.length()==0)
            return 0;
        int tmp = Integer.parseUnsignedInt(str.substring(nBegin));

        if(isPositive )
            return tmp;
        else
            return tmp*-1;

    }
}


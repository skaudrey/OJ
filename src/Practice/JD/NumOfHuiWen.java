package Practice.JD;

import java.util.Scanner;

/**
 * NumOfHuiWen
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * 判断删除原字符串的某些字符后所能构成的不重复的回文串的数目。
 */
public class NumOfHuiWen {

    static int nCount = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        huiwen("",str.toCharArray(),0);

        System.out.print(nCount);
    }

    public static void huiwen(String s,char[] data, int index){
        if(index>=data.length)
            return;
        if(judge(s)){
            System.out.println(s);
            nCount++;
        }
        huiwen(s,data,index+1);
        huiwen(s+data[index],data,index+1);
    }



    // judge whether the string s is a huiwen
    public static boolean judge(String s){
        if(s==null||s.length()==0)
            return false;

        char[] data = s.toCharArray();
        for(int i = 0; i<data.length/2; i++){
            if(data[i]!=data[data.length-1-i])
                return false;
        }
        return true;
    }

}

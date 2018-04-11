package Practice.NiuKeOJ;

/**
 * ReverseStr
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * 剑指offer
 *
 * 题目描述
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。

同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseStr {

    public static void main(String[] args){

    }

    public String ReverseSentence(String str) {

        if(str==null || str.length()==0)
            return "";

        String result = "";
        String[] strs = str.split(" ");

        if(strs.length==0)  //处理字符串含一个空格的情况
            return str;

        for(int i = strs.length-1; i>=0; i--){
            result += strs[i];
            if(i!=0)
                result += " ";
        }
        return result;
    }

    }

package Practice.NiuKeOJ;

/**
 * ReverseStr
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * ��ָoffer
 *
 * ��Ŀ����
ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�

ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼�����磬��student. a am I����
��������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */
public class ReverseStr {

    public static void main(String[] args){

    }

    public String ReverseSentence(String str) {

        if(str==null || str.length()==0)
            return "";

        String result = "";
        String[] strs = str.split(" ");

        if(strs.length==0)  //�����ַ�����һ���ո�����
            return str;

        for(int i = strs.length-1; i>=0; i--){
            result += strs[i];
            if(i!=0)
                result += " ";
        }
        return result;
    }

    }

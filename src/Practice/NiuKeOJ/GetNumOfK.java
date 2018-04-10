package Practice.NiuKeOJ;

/**
 * GetNumOfK
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * ��ָoffer
 * ��Ŀ����
ͳ��һ�����������������г��ֵĴ�����
 */
public class GetNumOfK {

    public static void main(String[] args){
        int[] array = {1,1,1,1,2,2,3,3,3,3,3};

        int nResult = GetNumberOfK(array,1);

        System.out.println(nResult);
    }

    public static int GetNumberOfK(int [] array , int k) {

        if(array.length==0)
            return 0;

        if(array.length==1 && k!=array[0])
            return 0;

        if(array.length==1 && k==array[0])
            return 1;

        int i = 0;
        int nCount = 0;
        while( i<array.length && array[i]!=k )
            i++;


        if(i>=array.length)
            return 0;

        while(i<array.length && array[i]==k){  //ע��array[i++]Ҫ����i<array.length ����
            nCount++;i++;
        }

        return nCount;
    }
}

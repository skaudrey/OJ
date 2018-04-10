package Practice.NiuKeOJ;

/**
 * UglyNumber
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * ��ָoffer
 *
 * ��Ŀ����
��ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ����������7��
ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������

�ţ��Լ���˼·���Ȱѳ���������������ҡ����ڴ�����ˡ���

 ��ʵ���ö����˼��ȥ��

//Ҫע�⣬����ĳ�������ǰһ����������2��3��5�е�һ����������˿����ö�̬�滮ȥ��
//ͬʱע��һ�£���Ŀ��˼Ӧ����������ˣ����������ӣ���Ϊ8��������1��2��4��8

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
            ugly[i] = Math.min(ugly[i1]*2,Math.min(ugly[i2]*3,ugly[i3]*5)); //ע����i1��i2��i3

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

package Practice.sort;

import Practice.MyUtilIO;

/**
 * InsertUtilIO
 *
 * @author Mia Feng
 * @date 2018/3/25
 */
public class InsertUtilIO extends MyUtilIO {

    public static void main(String[] args){
        int[] arr = {5,2,4,6,1,3};

        System.out.println("Ascent");
        solutionAscent(arr);
        printArray(arr);

        System.out.println("\nDescent");
        solutionDescent(arr);
        printArray(arr);
    }
//
//    public static void solutionAscent(int[] arr){
//        for(int j=1; j<arr.length; j++){
//            int key = arr[j];
//            int i = j-1;
//            while (i>=0 && arr[i]>key){ //������key֮ǰ������i>=0��֤��Խ�磻 arr[i]>key Ѱ�ұ�key�����������λ��
//                arr[i+1] = arr[i];//��key�����������
//                i -= 1;
//            }
//            //����ֱ���ҵ���keyС��������ʱ�������ֵ�ĺ�һλ���ǲ���key��λ��
//            arr[i+1] = key;
//        }
//    }


    public static void solutionAscent(int[] arr){
        for(int j=1; j<arr.length; j++){
            int key = arr[j];
            int i = j-1;    //����Ԫǰһλ��ʼ����

            //�����ҵ�����ԪС���Ǹ�λ�ã�����Ԫ���뵽�Ǹ�λ��֮������������������Ԫ�󣬾Ͷ�����Ų
            while (i>=0 && arr[i]>key){
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i+1] = key;
        }
    }

    public static void solutionDescent(int[] arr){
        for(int j=1; j<arr.length; j++){
            int key = arr[j];
            int i = j-1;

            while (i>=0 && arr[i]<key){
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i+1] = key;
        }
    }
}

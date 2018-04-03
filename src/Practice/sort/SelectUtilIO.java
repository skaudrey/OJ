package Practice.sort;

import Practice.MyUtilIO;

/**
 * SelectUtilIO
 *
 * @author Mia Feng
 * @date 2018/3/25
 * ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������Ȼ����ʣ�µ�������������С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��
 */
public class SelectUtilIO extends MyUtilIO {

    public static void main(String[] args){
        int[] arr = {5,2,4,6,1,3};

        System.out.println("Ascent");
        solutionAscent(arr);
        printArray(arr);

        System.out.println("\nDescent");
        solutionDescent(arr);
        printArray(arr);
    }

    public static void solutionAscent(int[] arr){

        for (int i=0; i<arr.length; i++){
            int key = arr[i];
            int keyIndex = i;

            for (int j=i+1; j<arr.length; j++){
                if(arr[j]<key){ //������С��
                    keyIndex = j;
                    key = arr[j];
                }
            }
            arr[keyIndex] = arr[i];
            arr[i] = key;
        }

    }

    public static void solutionDescent(int[] arr){
        for(int i=0; i<arr.length; i++){
            int key = arr[i];
            int keyIndex = i;

            for(int j=i+1;j<arr.length; j++){   //������������
                if(arr[j]>key){
                    key = arr[j];
                    keyIndex = j;
                }
            }
            arr[keyIndex] = arr[i];
            arr[i] = key;
        }
    }

}

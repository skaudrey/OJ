package poj;
/**
 * ͳ�Ʋ��ظ���Ԫ��
 * **/

public class CountOfSingleItem {
	public int count(int[] array) {  
        int len = array.length;  
  
        for (int i = 0; i < array.length - 1; i++) {  
            for (int j = i + 1; j < array.length; j++) {  
                int num = array[i];  
                if (array[j] == num) {  
                    // �ظ��������ܳ��ȼ�1  
                    len--;  
  
                    i++;  
                }  
            }  
        }  
  
        return len;  
    }  
  
    public static void main(String[] args) {  
        // �������ݣ��ܹ���9����ͬ��Ԫ�أ����������źã��������ظ����ֵ�Ԫ�ء�  
        int[] array = new int[] { 1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 9 };  
  
        System.out.println(new CountOfSingleItem().count(array));  
    }  
}

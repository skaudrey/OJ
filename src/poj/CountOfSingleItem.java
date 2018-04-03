package poj;
/**
 * 统计不重复的元素
 * **/

public class CountOfSingleItem {
	public int count(int[] array) {  
        int len = array.length;  
  
        for (int i = 0; i < array.length - 1; i++) {  
            for (int j = i + 1; j < array.length; j++) {  
                int num = array[i];  
                if (array[j] == num) {  
                    // 重复，数组总长度减1  
                    len--;  
  
                    i++;  
                }  
            }  
        }  
  
        return len;  
    }  
  
    public static void main(String[] args) {  
        // 测试数据：总共是9个不同的元素，按照升序排好，其中有重复出现的元素。  
        int[] array = new int[] { 1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 9 };  
  
        System.out.println(new CountOfSingleItem().count(array));  
    }  
}

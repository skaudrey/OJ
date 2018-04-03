package Practice.NiuKeOJ;

/**
 * SearchOrderedMatrix
 *
 * @author Mia Feng
 * @date 2018/3/29
 * ��ָoffer
 * ��Ŀ����
��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class SearchOrderedMatrix {

    //search for the upper right corner or lower left corner

    public class Solution {
        public boolean Find(int target, int [][] array) {
            int row = 0;
            int col = array[0].length-1;

            while(col>=0 && row < array.length){
                if(array[row][col] == target)
                    return true;
                if(array[row][col] > target)
                    col--;
                else
                    row++;
            }
            return false;
        }
    }

}

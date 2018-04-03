package Practice.NiuKeOJ;

/**
 * SearchOrderedMatrix
 *
 * @author Mia Feng
 * @date 2018/3/29
 * 剑指offer
 * 题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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

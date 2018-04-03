package Practice.NiuKeOJ;

/**
 * FindMinofCircleArray
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * *剑指offer
 *
 * 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

 这道题还是比较简单的，只要抓住数组的左边到最小值为降序了，右边到最小值为升序了就可以
 这样的话用一个flag来记录就可以了。。碰到第一个比当前记录的最小值大的值，就可以跳出循环了

 */
public class FindMinofCircleArray {
    public class Solution {
        public int minNumberInRotateArray(int [] array) {
            if(array.length==0)
                return 0;
            int nResult = Integer.MAX_VALUE;
            boolean isDescentFlag = true;
            for(int i=array.length-1; i>=0; i--){
                if(!isDescentFlag)
                    break;
                if(array[i] < nResult)
                    nResult = array[i];
                if(array[i] > nResult)
                    isDescentFlag = false;
            }
            return nResult;
        }
    }
}

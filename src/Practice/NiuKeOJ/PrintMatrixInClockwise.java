package Practice.NiuKeOJ;

import java.util.ArrayList;

/**
 * PrintMatrixInClockwise
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * 剑指offer
 *
 * 题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵：
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

 嗯，调了一早上一直没AC。。。简直了，二维数组求行列大小。。自己注意一下好不啦
 */
public class PrintMatrixInClockwise {


    public class Solution {
        ArrayList<Integer> result = new ArrayList<>();
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            int nRows = matrix.length;
            int nCols = matrix[0].length;   //注意这里求列数

            int nLayers = (Math.min(nRows,nCols)-1)/2+1;    //层数这里需要手推一下
            for(int i = 0; i<nLayers; i++){
                printCircle(matrix, nRows, nCols, i);
            }
            return result;

        }

        public void printCircle(int[][] matrix, int nRows, int nCols, int nStart){
            for(int i = nStart; i< nCols-nStart; i++)
                result.add(matrix[nStart][i]);
            for(int j = nStart+1;j<nRows-nStart; j++)
                result.add(matrix[j][nCols-nStart-1]);  //注意这里是nCols-。。。
            for(int m = nCols-nStart-2; m >= nStart && nRows-nStart-1>nStart; m--)
                result.add(matrix[nRows-nStart-1][m]);
            for(int n = nRows-nStart-2; n> nStart && nCols-nStart-1>nStart; n--)    //注意这里是n>nStart,而不是>=
                result.add(matrix[n][nStart]);
        }
    }
}

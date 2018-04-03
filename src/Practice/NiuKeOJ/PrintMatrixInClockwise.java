package Practice.NiuKeOJ;

import java.util.ArrayList;

/**
 * PrintMatrixInClockwise
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * ��ָoffer
 *
 * ��Ŀ����
����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
���磬����������¾���
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
�����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

 �ţ�����һ����һֱûAC��������ֱ�ˣ���ά���������д�С�����Լ�ע��һ�ºò���
 */
public class PrintMatrixInClockwise {


    public class Solution {
        ArrayList<Integer> result = new ArrayList<>();
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            int nRows = matrix.length;
            int nCols = matrix[0].length;   //ע������������

            int nLayers = (Math.min(nRows,nCols)-1)/2+1;    //����������Ҫ����һ��
            for(int i = 0; i<nLayers; i++){
                printCircle(matrix, nRows, nCols, i);
            }
            return result;

        }

        public void printCircle(int[][] matrix, int nRows, int nCols, int nStart){
            for(int i = nStart; i< nCols-nStart; i++)
                result.add(matrix[nStart][i]);
            for(int j = nStart+1;j<nRows-nStart; j++)
                result.add(matrix[j][nCols-nStart-1]);  //ע��������nCols-������
            for(int m = nCols-nStart-2; m >= nStart && nRows-nStart-1>nStart; m--)
                result.add(matrix[nRows-nStart-1][m]);
            for(int n = nRows-nStart-2; n> nStart && nCols-nStart-1>nStart; n--)    //ע��������n>nStart,������>=
                result.add(matrix[n][nStart]);
        }
    }
}

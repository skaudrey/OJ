package Practice.TouTiao;

/**
 * MaxPts
 *
 * @author Mia Feng
 * @date 2018/3/24
 *
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）

如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。

输入描述:
第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
对于 50%的数据,  1 <= N <= 10000;
对于 100%的数据, 1 <= N <= 500000;


输出描述:
输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。

输入例子1:
5
1 2
5 3
4 6
7 5
9 0

输出例子1:
4 6
7 5
9 0
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxPts {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nPts = sc.nextInt();
        Integer[][] pts = new Integer[nPts][2];
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        for(int i = 0; i<nPts;i++){
            pts[i][0] = sc.nextInt();
            pts[i][1] = sc.nextInt();
            Integer[] temp = new Integer[2];
            temp[0] = pts[i][0];
            temp[1] = pts[i][1];

            result.add(temp);
        }

        ArrayList<Integer[]> minPts = new ArrayList<Integer[]>();
        Integer[] temp = new Integer[2];
        temp[0] = pts[0][0];
        temp[1] = pts[0][1];
        minPts.add(temp);

        for(int i=0; i < nPts; i++){
            int[] tempPt = new int[2];
            tempPt[0] = pts[i][0];
            tempPt[1] = pts[i][1];
            for(int j=0; j<minPts.size(); j++){
                if(tempPt[0]<minPts.get(j)[0] && tempPt[0] > minPts.get(j)[1]){
                    result.add(minPts.get(j));
                }
                else if(tempPt[0]>minPts.get(j)[0] && tempPt[0] < minPts.get(j)[1])
                    result.add(minPts.get(j));
                else if(tempPt[0]>minPts.get(j)[0] && tempPt[0] > minPts.get(j)[1])
                    result.add(minPts.get(j));
                else
                    result.remove(tempPt);
            }
        }

        result.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0]<o2[0])
                    return 1;
                return 0;
            }
        });

        for(int i=0; i<result.size();i++){
            System.out.println(Integer.toString(result.get(i)[0])+" "+Integer.toString(result.get(i)[1]));
        }
    }
}

package Practice.TouTiao;

/**
 * MaxPts
 *
 * @author Mia Feng
 * @date 2018/3/24
 *
 * PΪ�����Ķ�άƽ�������㼯������ P ��ĳ��x�����x���� P ������㶼���� x �����Ϸ������ڣ��������궼����x���������Ϊ�����ġ���������С����ġ���ļ��ϡ������е�ĺ�����������궼���ظ�, �����᷶Χ��[0, 1e9) �ڣ�

����ͼ��ʵ�ĵ�Ϊ���������ĵ�ļ��ϡ���ʵ�ִ����ҵ����� P �е����� ����� ��ļ��ϲ������

��������:
��һ������㼯�ĸ��� N�� ������ N �У�ÿ���������ִ����� X ��� Y �ᡣ
���� 50%������,  1 <= N <= 10000;
���� 100%������, 1 <= N <= 500000;


�������:
��������ġ� �㼯�ϣ� ���� X ���С����ķ�ʽ�����ÿ���������ֱַ������ X ��� Y�ᡣ

��������1:
5
1 2
5 3
4 6
7 5
9 0

�������1:
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

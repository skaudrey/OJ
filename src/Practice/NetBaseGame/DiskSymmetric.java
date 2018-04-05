package Practice.NetBaseGame;

/**
 * DiskSymmetric
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * С����ĩ�����ѹ䴴��԰ʱ��ϲ������һ�仨ש��Ļ�ש������Ļ�שÿһ�鶼�Ǽ����ĶԳ�Ҳ��ԳƵģ���ͼ�к�ɫ����ɫ�ᣩ
 * ����ͼ��ʾ�Ļ�ש����3x3��С��שƴ�Ӷ��ɡ���Щ��שƽ�̺�ƴ��һ�����������Ҳһ�������ĶԳ�����ԳƵġ�
 * С�Ƴ����ֶԳƽ������Գơ�
 *
 *  ����һ�黨ש�ı߳���N��С�Ƽҵķ���ǽ�߳���M������N��M��������������ÿ�黨ש����ʽ��
 *  �����С�Ƽ�ǽ����שƽ�̺����ʽ��
 *
 *  ���ر�ϲ�����ֶԳ�֮�����������������ķ��ӵ�һ�·��ε�ǽ��������Щ�����ԳƵĻ�ש��
 *  ����С�Ƽҵ�ǽ��С�����޷���ֻ֤�������Ļ�ש��ƽ�̣���ʱ��С�ƻ���ϣ��ƽ�̺��ͼ���������ԳƵġ�
 *  ����ͼ��ɫ���ʾ��С�Ƽ�ǽ�Ĵ�С���Լ��ڲ���ש��ƽ����ʽ��
 *  ����һ�黨ש�ı߳���N��С�Ƽҵķ���ǽ�߳���M������N��M����������
 *  ����ÿ�黨ש����ʽ�������С�Ƽ�ǽ����שƽ�̺����ʽ��


��������:
����ĵ�һ��Ϊһ��������T��T<=10������ʾ��������������
��������T�����ݡ�ÿ�����ݵĵ�һ��Ϊ����������N��M��1<=N<20, N<=M<200������ʾ��ש�ı߳���С�Ƽ�ǽ�ı߳�����֤N��M����������������N�У�ÿ��N���ַ�����ʾ��ש��ͼ�������ַ�ֻ�������Сд��ĸ�����֡���ͬ���ַ�����һ�������ԳƵ�ͼ����
ÿ��������ݺ����һ�����С�
�������:
����ÿһ�����ݣ����M�У�ÿ�а���M���ַ�����ʾ��שƽ����ǽ���ͼ����
ÿ�����ݺ����һ�����С�
ʾ��1
����
3
3 5
1x1
xox
1x1

3 7
1x1
xox
1x1

5 7
13S31
LKcKL
Sc2cS
LKcKL
13S31

���
11x11
11x11
xxoxx
11x11
11x11

oxxoxxo
x11x11x
x11x11x
oxxoxxo
x11x11x
x11x11x
oxxoxxo

113S311
113S311
LLKcKLL
SSc2cSS
LLKcKLL
113S311
113S311

 */
import java.util.ArrayList;
import java.util.Scanner;

public class DiskSymmetric {



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] diskSize = new int[T];
        int[] wallSize = new int[T];

        ArrayList<char[][]> disks = new ArrayList<>();

        for(int i = 0; i<T; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            diskSize[i] = n;
            wallSize[i] = m;

            char[][] tmp = new char[n][n];

            for(int j = 0; j<n; j++){
//                for (int k = 0; k<n; k++){
                    tmp[j] = sc.next().toCharArray();
//                }
            }

            disks.add(tmp);
        }

        for(int i = 0; i<T; i++){
            char[][] filled = new char[wallSize[i]][wallSize[i]];
            char[][] disk = disks.get(i);

            int nCenter = wallSize[i]/2;
            int nAdd = (wallSize[i] - diskSize[i])/2;

            //�ȳ�ʼ��������
            for(int j = 0; j < diskSize[i];j++){
                for(int k = 0; k < diskSize[i];k++)
                    filled[j+nAdd][k+nAdd] = disk[j][k];
            }
            //�����Ŀ�ʼ�����࿽��
            //�ȿ�������
//            int nDStartI = 0,nDstartJ = 0;
            int nFStartI = nCenter-diskSize[i]/2,nFStartJ = nCenter-diskSize[i]/2;
            int nInd = 0;
           for(int j = nFStartI; j>=1; j--){
               for(int k = nFStartJ; k<wallSize[i]-nAdd; k++){
                   filled[k][j-1] = filled[k][j+nInd];
               }
               nInd+=2;
           }
           //��������
            nInd = 1;
            for(int j = nFStartI+diskSize[i]; j<wallSize[i]; j++){
                for(int k = nFStartJ; k<wallSize[i]-nAdd; k++){
                    filled[k][j] = filled[k][j-nInd];
                }
                nInd+=2;
            }

            //�����ϲ���
            nInd = 0;
            for(int j = nFStartI; j>=1; j--){
                for(int k = 0; k <wallSize[i]; k++){
                    filled[j-1][k] = filled[j+nInd][k];
                }
                nInd+=2;
            }


            //�����²���
            nInd = 1;
            for(int j = nFStartI+diskSize[i]; j<wallSize[i]; j++){
                for(int k = 0; k<wallSize[i]; k++){
                    filled[j][k] = filled[j-nInd][k];
                }
                nInd+=2;
            }

            printFilled(filled,wallSize[i]);
            System.out.println();
        }

    }

    public static void printFilled(char[][] filled, int nWallSize){
        for (int i = 0; i<nWallSize; i++) {
            for (int j = 0; j < nWallSize; j++) {
                System.out.print(filled[i][j]);
            }
            System.out.print('\n');
        }
    }

}

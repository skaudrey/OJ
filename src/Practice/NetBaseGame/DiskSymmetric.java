package Practice.NetBaseGame;

/**
 * DiskSymmetric
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * 小云周末和朋友逛创意园时，喜欢上了一间花砖店的花砖。这里的花砖每一块都是既中心对称也轴对称的（左图中红色和蓝色轴）
 * 如右图所示的花砖是由3x3块小花砖拼接而成。这些花砖平铺后拼成一个大的正方形也一样是中心对称且轴对称的。
 * 小云称这种对称叫完美对称。
 *
 *  假设一块花砖的边长是N，小云家的方形墙边长是M，其中N和M都是奇数。给出每块花砖的样式，
 *  请给出小云家墙按花砖平铺后的样式。
 *
 *  他特别喜欢这种对称之美，并且想给他新买的房子的一堵方形的墙上铺上这些完美对称的花砖。
 *  但是小云家的墙大小可能无法保证只用完整的花砖来平铺，这时候小云还是希望平铺后的图案是完美对称的。
 *  如下图红色框表示了小云家墙的大小，以及内部花砖的平铺样式。
 *  假设一块花砖的边长是N，小云家的方形墙边长是M，其中N和M都是奇数。
 *  给出每块花砖的样式，请给出小云家墙按花砖平铺后的样式。


输入描述:
输入的第一行为一个正整数T（T<=10），表示测试数据组数。
接下来有T组数据。每组数据的第一行为两个正整数N，M（1<=N<20, N<=M<200），表示花砖的边长和小云家墙的边长。保证N和M都是奇数。接下来N行，每行N个字符，表示花砖的图案，且字符只会包含大小写字母和数字。相同的字符代表一个完美对称的图案。
每组测试数据后包含一个空行。
输出描述:
对于每一组数据，输出M行，每行包含M个字符，表示花砖平铺满墙后的图案。
每组数据后输出一个空行。
示例1
输入
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

输出
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

            //先初始化最中心
            for(int j = 0; j < diskSize[i];j++){
                for(int k = 0; k < diskSize[i];k++)
                    filled[j+nAdd][k+nAdd] = disk[j][k];
            }
            //从中心开始向两侧拷贝
            //先拷贝左列
//            int nDStartI = 0,nDstartJ = 0;
            int nFStartI = nCenter-diskSize[i]/2,nFStartJ = nCenter-diskSize[i]/2;
            int nInd = 0;
           for(int j = nFStartI; j>=1; j--){
               for(int k = nFStartJ; k<wallSize[i]-nAdd; k++){
                   filled[k][j-1] = filled[k][j+nInd];
               }
               nInd+=2;
           }
           //拷贝右列
            nInd = 1;
            for(int j = nFStartI+diskSize[i]; j<wallSize[i]; j++){
                for(int k = nFStartJ; k<wallSize[i]-nAdd; k++){
                    filled[k][j] = filled[k][j-nInd];
                }
                nInd+=2;
            }

            //拷贝上部分
            nInd = 0;
            for(int j = nFStartI; j>=1; j--){
                for(int k = 0; k <wallSize[i]; k++){
                    filled[j-1][k] = filled[j+nInd][k];
                }
                nInd+=2;
            }


            //拷贝下部分
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

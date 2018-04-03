package Practice.DP;

/**
 * PackageComplete
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 * ��ȫ����(CompletePack):
 * ��N����Ʒ��һ������ΪV�ı�����ÿ����Ʒ�������޼����á�
 * ��i����Ʒ�ķ�����c[i]����ֵ��w[i]��
 * ��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�ķ����ܺͲ����������������Ҽ�ֵ�ܺ����

��ȫ��������˼·��Ȼ������һ����ά������д����

�õ�ǰ�ı������ϼ��ϵ�ǰ��Ʒ���Ϳ�����ɶ����Ʒ�ļ���
֮ǰ0,1������ʱ������ǰһ����Ʒ���ϵ�ǰ�����ȷ������Ʒ�����ظ����뱳��
hhhhhhhh,���˼·�����

f[i][v]=max{f[i][j-w[i]]+v[i],f[i-1][j]| w[i]>=0 && w[i] <= j}
 */
public class PackageComplete {

    public static void main(String[] args){
        int nSize = 3;
        int nMaxValue = 10;
        int[] weight = {0,3,4,5};
        int[] value = {0,4,5,6};

        int[][] result = new int[nSize+1][nMaxValue+1];

        for(int i = 1; i <= nSize; i++){
            for(int j = 1; j <= nMaxValue; j++){
                if(weight[i] <= j)
                    result[i][j] = Math.max(result[i-1][j],result[i][j-weight[i]]+value[i]);
                else
                    result[i][j] = result[i-1][j];
            }
        }
        System.out.println(result[nSize][nMaxValue]);
    }


    //another idea

    public static void solve2(){

        int nSize = 3;
        int nMaxValue = 10;

        int[] weight = {0,3,4,5};
        int[] value = {0,4,5,6};
        int[] amout = {0,1,2,3};
        int[][] result = new int[nSize+1][nMaxValue+1];

        for(int i=1; i <= nSize; i++){
            for (int j=1; j <= nMaxValue; j++){
                for(int k = 0; k*weight[i]<=j; k++)
                    result[i][j] = Math.max(result[i][j],result[i-1][j-k*weight[i]]+k*value[i]);
            }
        }

        System.out.println(result[nSize][nMaxValue]);
    }
}

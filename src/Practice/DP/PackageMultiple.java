package Practice.DP;

/**
 * PackageMultiple
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 * ���ر���(MultiplePack):
 * ��N����Ʒ��һ������ΪV�ı�������i����Ʒ�����n[i]�����ã�ÿ��������c[i]����ֵ��w[i]��
 * ��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�ķ����ܺͲ����������������Ҽ�ֵ�ܺ����
 *
 * ����ֱ��ģ����ȫ������ֻ��Ҫ���Ʒ�����Ʒ����Ŀ����������ȫ�����Ա������������Ϊ�Ͻ�
 */
public class PackageMultiple {
    public static void main(String[] args){

        int nSize = 3;
        int nMaxValue = 10;

        int[] weight = {0,3,4,5};
        int[] value = {0,4,5,6};
        int[] amount = {0,1,2,3};

        int[][] result = new int[nSize+1][nMaxValue+1];

        for (int i = 1; i <= nSize; i++){
            for (int j = 1; j <= nMaxValue; j++){
                for (int k = 0; k <= amount[i] && k*weight[i] <= j; k++){
                        result[i][j] = Math.max(result[i][j],  result[i-1][j - k * weight[i]]+k*value[i]);
                }
            }
        }

        System.out.println(result[nSize][nMaxValue]);

    }
}

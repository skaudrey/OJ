package Practice.DP;

/**
 * PackageZeroOne
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 * ��N����Ʒ��һ������ΪV�ı�������ÿ����Ʒ��ֻ��һ������i����Ʒ�ķ�����c[i]����ֵ��w[i]��
 * ��⽫��Щ��Ʒװ�뱳����ʹ��ֵ�ܺ����

����������ı������⣬�ص��ǣ�ÿ����Ʒ����һ��������ѡ��Ż򲻷š�
 */
public class PackageZeroOne {

    public static void main(String[] args){
        int nSize = 3;//������Ʒ
        int nMaxWeight = 10;    // �����������Ϊ10

        int[] weight = {0,3,4,5};  //�����СΪ nSize+1,Ϊ�˺������������0����Ʒ������0����ֵ0
        int[] value = {0,4,5,6};   //�����СΪ nSize+1��Ϊ�˺������������0����Ʒ������0����ֵ0
        int[][] result = new int[nSize+1][nMaxWeight+1];    // result[i][j] ��ʾ��ǰ������Ʒi��ﵽ����j����Ӧ������ֵ

        for(int i = 1; i<=nSize; i++){
            for (int j = 1; j<=nMaxWeight; j++){
                if(weight[i] <= j )
                    result[i][j] = Math.max(result[i-1][j], result[i-1][j-weight[i]]+value[i]);
                else    //�����ǰ��Ʒ���������ڵ�ǰ�����ĳ��أ���Ʒ�����Է��뱳���У����Ա����ļ�ֵ����
                    result[i][j] = result[i-1][j];
            }
        }

        System.out.println(result[nSize][nMaxWeight]);
        //���Ҫ�Ҷ�Ӧ�����ļ�����Ʒ�Ļ������Դӱ������һ�дӵ�һ�����£�ֱ����ֵ�ﵽ���value�Ҳ��ı�Ϊֹ���кž��Ƕ�Ӧ����Ʒ��


    }
}

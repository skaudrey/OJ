package Practice.DP;

/**
 * TowerTreeMaxSum
 *
 * @author Mia Feng
 * @date 2018/3/25
 *
 * ����ѡ����������
 *
 * һ���߶�ΪN������������ɵ������Σ������ߵ��£��󾭹������ֺ͵����ֵ��ÿ��ֻ���ߵ���һ�����ڵ����ϣ�����ӵ�3���6�����ߣ�ֻ���ߵ���4���2��9�ϡ�
 *
 *      5
 *     8 4
 *    3 6 9
 *   7 2 9 5
 *
 * �������Ƚ�����
 * �Ӷ����ױȽ����㷨�����Ǵӵ׵����й���
 * ��[i,j]��ʾ��i�е�j��
 * dp[i][j]�洢��һ�㵽[i.j]ʱ������
 *
 * dp[3][2] = max(dp[3+1][2],dp[3+1][2+1]) + a[3][2]
 *
 * ����������ʽ���˼·����
1����ʼ��������һ��dp
2���������ϣ���װ������ʽ��dp���и�ֵ
3��dp[0][0]Ϊ��������
 */
public class TowerTreeMaxSum {

    public static void main(String[] args){
        int[][] tower = {{5},{8,4},{3,6,9},{7,2,9,5}};
        int nFloor = 4;
        int[][] dp = new int[nFloor][nFloor];

//        //Initialize
//        for(int i=0; i<nFloor;i++)
//            dp[nFloor-1][i] = tower[nFloor-1][i];
//
//        for(int i = nFloor-2; i>=0; i--){
//            for(int j=0; j<=i; j++)
//                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1])+tower[i][j];
//        }
        solution(tower,dp);
        System.out.println(dp[0][0]);
    }

    public static void solution(int[][] tower, int[][] dp){
        int nFloor = tower.length;

        //Initialization
        for(int i=0; i<nFloor; i++){
            dp[nFloor-1][i] = tower[nFloor-1][i];
        }

        //Derive optimal summation
        for(int i = nFloor-2; i>=0; i--){
            for(int j = 0; j<=i; j++)
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1]) + tower[i][j];
        }
    }
}

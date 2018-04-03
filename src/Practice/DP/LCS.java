package Practice.DP;

/**
 * LCS
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 * https://www.cnblogs.com/xudong-bupt/archive/2013/03/15/2959039.html
 * �������ַ����еĹ���������С������ַ�����abcbdb���ַ�����acbbabdbb�������������Ϊacbdb��
 *
 * һ���ַ����������У���ָ�Ӹ��ַ�����ȥ���������ַ���ʣ�µ��ַ��ڲ��ı�˳����������ɵ����ַ�����

��������������У���ָ����ַ����ɾ��еĳ������Ĺ����������С�

 Ҫ���ַ�������������������
L[i][j] = L[i - 1][j - 1] + 1��   xi����yj

= max(L[i][j - 1], L[i - 1][j]),     xi������yj
��int[][] len = new int[str1.length+1][str2.length+1];��¼��󳤶ȣ��ַ���str1�ӵ�1λ��iλ���ַ���str2�ӵ�1λ����jλ��

len[i][j] = len[i-1][j-1]+1;  if str1[i] == str2[j];
len[i][j] = max{len[i-1][j],len[i][j-1]};  if str1[i] != str2[j];

�߽�������0�к͵�0�о�Ϊ0����
len[i][0] = len[0][j] = 0

��Ϊ��ֻҪ�����󳤶ȣ���ҪѰ�ҵ�����������У����������len[i][j]�����У�����һ����flags[i][j]
���У�����"1"��ʾ��б���£�����"2"��ʾ��ˮƽ���ң�����"3"��ʾ����ֱ���¡�
���������Ժ���������������С�

��str1[i]==str2[j], ����flags[i][j] = 1;   �����ϸ�б���µ���ǰ��

��str1[i]!=str2[j] && len[i + 1][j] >= len[i][j + 1], ���� flags[i][j] = 2; ��������ҵ���ǰ��

��str1[i]!=str2[j] && len[i + 1][j] < len[i][j + 1], ���� flags[i][j] = 3;  ���ϸ����µ���ǰ��

����ֻ�б�־Ϊ1 ʱ��Ӧλ���ϵ��ַ������ǹ����ַ���

�������⣺
�ϴ���ͷ�������ģ����ٲ�����Ŀ�������ַ������һ���ģ�����ɾ�����ı��������

���������ַ�����Ŀ���ǽ���һ��ת���ɺ͵ڶ�����ͬ���ַ��������������ֲ�����
1�����������ӡ�ɾ���͸ı�Ĳ�����ɾ�������y���У�xû�У�����ͬλ��y�п���ɾȥ��
�ı���ָ��x�е��ַ����Ըĳɸ�Y�е��ַ�һ���ģ�
��������ټ������Խ�x�ַ���ת����y�ַ���

����������������������У�״̬ת�Ʒ���Ϊ

if(a[i-1]==b[j-1])      //����ٿ������
    dp[i][j]=min(dp[i-1][j-1],dp[i-1][j]+1,dp[i][j-1]+1);
else    //����ȼ��ı�
    dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
 */
public class LCS {

    public static void main(String[] args){
        String str1 = "abcbdb";
        String str2 = "acbbabdbb";

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        int[][] len = new int[str1.length()+1][str2.length()+1];
        int[][] flags = new int[str1.length()+1][str2.length()+1];

        int nCommonLen = -1;

        nCommonLen = maxCommonStr(array1,array2,len,flags);

        System.out.println("The length of maximum common string:  " + Integer.toString(nCommonLen));

        char[] result = new char[nCommonLen];

        getLCS(array1,array2,flags,result);

        System.out.println("The common string: ");
        for (int i=0; i<nCommonLen; i++)
            System.out.print(result[i]);

    }

    public static int maxCommonStr(char[] str1, char[] str2,int[][] len, int[][] flags){
        int m = str1.length;
        int n = str2.length;

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if(str1[i-1] == str2[j-1]){
                    flags[i][j] = 1;
                    len[i][j] = len[i-1][j-1]+1;
                }
                else if(len[i][j-1]>=len[i-1][j]){
                    flags[i][j] = 2;
                    len[i][j] = len[i][j-1];
                }
                else {
                    flags[i][j] = 3;
                    len[i][j] = len[i-1][j];
                }
            }
        }

        return len[m][n];
    }

    public static void getLCS(char[] str1, char[] str2, int[][] flags, char[] result){

        int m = str1.length;
        int n = str2.length;
        int resultIndex = result.length-1;
        for (int i = m,j= n; i>=0 && j>=0;){    //ע�����������ֵ�Ǵ�m��n��ʼ��
            if(flags[i][j]==1){
                result[resultIndex--] = str1[i-1];  //ע��ȡstr1��������i-1λ
                i--;
                j--;
            }
            else if(flags[i][j]==2){
                j--;    //��������
            }
            else
                i--;    //��������
        }

    }
}

package Practice.NiuKeOJ;

/**
 * ReversePair
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * ��ָoffer
 *
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
��������:
��Ŀ��֤�����������û�е���ͬ������

���ݷ�Χ��

����%50������,size<=10^4

����%75������,size<=10^5

����%100������,size<=2*10^5

ʾ��1
����
1,2,3,4,5,6,7,0
���
7
 *
 * �ţ��ҵ�ʵ�ַ���������ʱ�ˡ�������ð����O(n^2)�ļ��㸴�Ӷ�
 *
 * ����һ��˵�ǹ鲢�����˼��ȽϺ�
 *
 *
 */
public class ReversePair {

    int nCount;
    static final int nMod = 1000000007;

    public static void main(String[] args){
        int [] test = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};

        ReversePair solver = new ReversePair();

        int nResult =  solver.InversePairs(test);

        System.out.println(nResult);
    }



    public int InversePairs(int [] array) {
        if(array.length == 0)
            return -1;

        nCount = 0;

        mergesort(array,0,array.length-1);

        return nCount%nMod;
    }

    public void mergesort(int[] array, int nLeft, int nRight){
        if(nLeft>=nRight)
            return;
        int nMid = (nLeft+nRight)/2;

        mergesort(array,nLeft, nMid);
        mergesort(array,nMid+1, nRight);
        merge(array, nLeft, nMid, nRight);
    }

    public void merge(int[] array, int nLeft, int nMid, int nRight){
        int[] tmp = new int[nRight-nLeft+1];

        int i = nLeft, j = nMid+1, k =0;

        while(i<=nMid && j<=nRight){
            if(array[i]<=array[j])
                tmp[k++] = array[i++];
            else{
                tmp[k++] = array[j++];
                nCount += nMid - i + 1;    //the sub array have been sorted //ע�����ﰡ���������ܻ������������Ҫ����һ��
                if(nCount>nMod)
                    nCount %= nMod;
            }
        }

        while(i<=nMid)
            tmp[k++] = array[i++];

        while(j<=nRight)
            tmp[k++] = array[j++];

        for(int m = 0; m<tmp.length; m++){
            array[m+nLeft] = tmp[m];
        }
    }


}

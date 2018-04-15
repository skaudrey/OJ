package Practice.TouTiao;

import java.util.*;

/**
 * ReasonableNum
 *
 * @author: Mia Feng
 * @date: 2018/4/15
 */
public class ReasonableNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nSize = sc.nextInt();

        for(int i =0; i<nSize; i++){
            int nK = sc.nextInt();
            ArrayList<Integer> A = new ArrayList<>();
            for(int j = 0; i<nK; j++)
                A.add(sc.nextInt());

            A.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1>o2?0:1;
                }
            });

            System.out.println(A.get(nK-1));
        }
    }

}

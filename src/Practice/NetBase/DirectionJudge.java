package Practice.NetBase;

import java.util.Scanner;

/**
 * DirectionJudge
 *
 * @author Mia Feng
 * @date 2018/3/27
 */
public class DirectionJudge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOps = sc.nextInt();
        String option = sc.next();

        // plus 1 for turning left, minus 1 for turning right
        // Then 1 for West, -1 for East, -2 for South, 0 for North

        int nDirection = 0;
//        int nDirectionL = 0;
//        int nDirectionR = 0;
        for (int i = 0; i < option.length(); i++) {
            if(option.charAt(i)=='L')
                nDirection++;
            else
                nDirection--;
        }


//            int temp = nDirectionL - nDirectionR;
            if(nDirection%4==0)
                System.out.println('N');
            if(nDirection%4==-1)
                System.out.println('E');
            if(nDirection%4==-2)
                System.out.println('S');
            if(nDirection%4==1)
                System.out.println('W');


    }

}

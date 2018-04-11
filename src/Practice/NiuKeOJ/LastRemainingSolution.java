package Practice.NiuKeOJ;

import java.util.LinkedList;

/**
 * LastRemainingSolution
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * 剑指offer
 *
 * 题目描述
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。

请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

 经典的数学问题：约瑟夫环

约瑟夫环：约瑟夫环是一个数学的应用问题：
已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。从编号为k的人开始报数，数到m的那个人出列；
他的下一个人又从1开始报数，数到m的那个人又出列；依此规律重复下去，直到圆桌周围的人全部出列。

 最巧的思路就是
 x[k+1] = (x[k]+m)%n;

 其实也可以模仿游戏过程，用LinkList来维护队列

 */
public class LastRemainingSolution {

    public int LastRemaining_solve1(int n,int m){

        if(n<1 || m<1)
            return -1;
        if(n==1)
            return 0;
        return (LastRemaining_solve1(n-1,m)+m)%n;

    }


    public int LastRemaining_solve2(int n,int m){

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i<n; i++)
            list.add(i);

        int bt = 0;

        while (list.size()>1){
            bt = (bt+m-1)%list.size();
            list.remove(bt);
        }

        return list.size()==1?list.get(0):-1;

    }
}

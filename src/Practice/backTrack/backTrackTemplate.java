package Practice.backTrack;

/**
 * backTrackTemplate
 *
 * @author Mia Feng
 * @date 2018/3/25
 *
 *  https://blog.csdn.net/yake827/article/details/52119469
 *  用回溯法解题的一般步骤：
（1）针对所给问题，确定问题的解空间：

首先应明确定义问题的解空间，问题的解空间应至少包含问题的一个（最优）解。

（2）确定结点的扩展搜索规则

（3）以深度优先方式搜索解空间，并在搜索过程中用剪枝函数避免无效搜索。
 */
public class backTrackTemplate {

    public static void notRecusiveFrame() {
//        int a[n],i;
//        初始化数组a[];
//        i = 1;
//        while (i>0(有路可走)   and  (未达到目标))  // 还未回溯到头
//        {
//            if(i > n)   // 搜索到叶结点
//            {
//                搜索到一个解，输出；
//            }
//            else  // 处理第i个元素
//            {
//                a[i]第一个可能的值；
//                while(a[i]在不满足约束条件且在搜索空间内)
//                {
//                    a[i]下一个可能的值；
//                }
//                if(a[i]在搜索空间内)
//                {
//                    标识占用的资源；
//                    i = i+1; // 扩展下一个结点
//                }
//                else
//                {
//                    清理所占的状态空间；            // 回溯
//                    i = i –1;
//                }
//    }
    }


    //DFS
    public static void recursiveFrame(){
//        int a[n];
//        try(int i)
//        {
//            if(i>n)
//                输出结果;
//            else
//            {
//                for(j = 下界; j <= 上界; j=j+1)  // 枚举i所有可能的路径
//                {
//                    if(fun(j))                 // 满足限界函数和约束条件
//                    {
//                        a[i] = j;
//                        ...                         // 其他操作
//                        try(i+1);
//                        回溯前的清理工作（如a[i]置空值等）;
//                    }
//                }
//            }
//        }

    }


}

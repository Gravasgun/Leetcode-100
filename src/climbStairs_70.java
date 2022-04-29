import java.util.HashMap;
import java.util.Map;

/**
 * 70.爬楼梯
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */
public class climbStairs_70 {
    public int climbStairs(int n) {
        /**
         * f(n)={1,n=1;
         *       2,n=2;
         *       f(n-1)+f(n-2),n>3;
         *                          }
         */
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * Solution 2
     *
     * @param n
     * @return
     */
    public int climbStairsSolution_2(int n) {
        //map用来存放计算结果，简化算法
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        //key是n，value是f(n)
        //如果map中已经存在了value，直接返回
        if (map.get(n) != null) {
            return map.get(n);
        }
        //不存在，就把n，和value添加进去后再返回value
        else {
            int result = climbStairsSolution_2(n - 1) + climbStairsSolution_2(n - 2);
            map.put(n, result);
            return result;
        }
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int climbStairsSolution_3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}


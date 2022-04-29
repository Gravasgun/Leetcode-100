/**
 * 剑指offer10.斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0，F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例1：
 * 输入：n = 2
 * 输出：1
 * 示例2：
 * 输入：n = 5
 * 输出：5
 */

import java.util.HashMap;
import java.util.Map;

public class Fib_10 {
    /**
     * 解法一：递归+hashmaop
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (map.get(n) == null) {
            int result = (fib(n - 1) + fib(n - 2)) % 1000000007;
            map.put(n, result);
            return result;
        } else {
            return map.get(n);
        }
    }

    /**
     * 解法二：递归
     *
     * @param n
     * @return
     */
    public int fibSolution_2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }

    /**
     * 解法三：动态规划
     *
     * @param n
     * @return
     */
    public int fibSolution_3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = 0;
        int pre = 1;
        int prePre = 0;
        for (int i = 2; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result % 1000000007;
    }
}

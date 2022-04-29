import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * 题目描述：
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class TwoSum_1 {
    /**
     * 双指针，两个循环，遍历，一一相加比较
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //创建一个新的数组用来存放下标
        int[] result = new int[2];
        //使用两个for循环进行遍历
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        //返回结果
        return result;
    }

    /**
     * 解法二：使用Hashmap简化算法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumSolution_2(int[] nums, int target) {
        //result用来存放下标
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果差值在Hashmap中不存在，就把当前的数放进去
            if (map.get(target - nums[i]) == null) {
                map.put(nums[i], i);
            }
            //key是nums[i],value是下标
            //差值存在。直接返回当前数的下标和Hashmap中存过的值的value
            else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
        }
        return result;
    }
}

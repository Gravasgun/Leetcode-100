/**
 * 283.移动零
 * 给定一个数组 nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 * 示例：
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes_283 {
    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //第一次遍历的时候，j指针记录非零的个数，只要是非零的元素通通赋值给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        //非零元素统计完了，剩下的元素全是0
        //第二次遍历把nums[j]之后的元素全赋值为0(包括nums[j])
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}

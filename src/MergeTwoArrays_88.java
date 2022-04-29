import java.util.Arrays;

/**
 * 88.合并两个有序数组
 * 给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
 * 请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组nums1中。
 * 为了应对这种情况，nums1的初始长度为m+n，其中前m个元素表示应合并的元素，后n个元素为0，应忽略。nums2的长度为n。
 * 实例1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1中的元素。
 * 示例2:
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 */

/**
 * 解法一：暴力解法，循环赋值
 */
public class MergeTwoArrays_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    /**
     * 解法二：双指针
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSolution_2(int[] nums1, int m, int[] nums2, int n) {
        //k为temp数组的长度
        int k = m + n;
        //temp用来存放合并后的新数组
        int[] temp = new int[k];
        //nums1数组的下标
        int nums1_index = 0;
        //nums2数组的下标
        int nums2_index = 0;
        //index是temp数组的下标
        for (int index = 0; index < k; index++) {
            //nums1下标如果大于等于m，说明nums1数组中的数字已经取完，此时直接取nums2数组中的值即可
            if (nums1_index >= m) {
                temp[index] = nums2[nums2_index];
                nums2_index++;
            }
            //nums2下标如果大于等于n，说明nums2数组中的数字已经取完，此时直接取nums1数组中的值即可
            else if (nums2_index >= n) {
                temp[index] = nums1[nums1_index];
                nums1_index++;
            }
            //nums1数组中的值小于nums2数组中的值，把nums1中的值放入temp
            else if (nums1[nums1_index] < nums2[nums2_index]) {
                temp[index] = nums1[nums1_index];
                nums1_index++;
            }
            //nums2数组中的值小于等于nums1数组中的值，把nums2中的值放入temp
            else {
                temp[index] = nums2[nums2_index];
                nums2_index++;
            }
        }

        //把temp数组中的每个元素赋值给nums1数组中的每个元素
        for (int i = 0; i < k; i++) {
            nums1[i] = temp[i];
        }
    }
}

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 * 给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
 * 请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1的初始长度为m+n，其中前m个元素表示应合并的元素，后n个元素为 0 ，应忽略。nums2的长度为n。
 *实例1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 */
public class MergeTwoArrays_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=m;i<m+n;i++){
            nums1[i]=nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}

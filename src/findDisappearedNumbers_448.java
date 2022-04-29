import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 448.找到数组中消失的数字
 * 给你一个含 n 个整数的数组nums，其中nums[i]在区间 [1, n]内。请你找出所有在[1, n]范围内但没有出现在nums中的数字，并以数组的形式返回结果。
 * <p>
 * 示例：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 */
public class findDisappearedNumbers_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //s用来存放nums的值，s中的值不可重复，提高效率
        Set<Integer> s = new HashSet<>();
        //list用来存放结果
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        //把nums中的元素不重复放入set中
        for (int i = 1; i <= length; i++) {
            s.add(nums[i - 1]);
        }
        //遍历nums的元素，如果nus中的元素不在set中，就把这个元素添加进list中
        for (int i = 1; i < nums.length + 1; i++) {
            if (!s.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}

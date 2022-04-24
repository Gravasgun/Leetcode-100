/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例：
 * 输入：s = "{[]}"
 * 输出：true
 */

import java.util.Stack;

public class EffectiveBrackets_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            // 如果c是 ({[ 则入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            //如果c=），],},且栈都不为空，且c能与之匹配，就弹栈
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            //剩下的情况都不满足，直接return false
            else {
                return false;
            }
        }
        //判断栈是否为空，为空的话说明左括号都被右括号对应，都弹栈了
        //不为空的话说明有剩余的左括号，并且没有与之对应的右括号，
        return stack.isEmpty();
    }
}

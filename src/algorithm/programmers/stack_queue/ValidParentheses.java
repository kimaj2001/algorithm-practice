package algorithm.programmers.stack_queue;

import java.util.Stack;

// 프로그래머스 "올바른 괄호"
public class ValidParentheses {
    /**
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
     * @param s 문자열 s의 길이 : 100,000 이하의 자연수, 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
     *          ex) ")()("
     * @return 올바른 괄호이면 true, 올바르지 않은 괄호이면 false를 return
     *         ex) "false"
     */
    public static boolean solution(String s) {
        /* 효율성 테스트 실패
        if (s.charAt(0) != '(' || s.charAt(s.length()-1) != ')' || s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') stack.pop();
            else stack.push(ch);
        }

        return stack.isEmpty();
         */

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            else stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }
}

package algorithm.programmers.stack_queue;

import java.util.Stack;

// 프로그래머스 "같은 숫자는 싫어"
public class NoDuplicateNumbers {
    /**
     * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
     * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
     * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
     *
     * @param arr 배열 arr의 크기 : 1,000,000 이하의 자연수, 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
     *            ex) [1,1,3,3,0,1,1]
     * @return 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return
     *         ex) [1,3,0,1]
     */
    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) stack.push(arr[i]);
        }

        return stack.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}


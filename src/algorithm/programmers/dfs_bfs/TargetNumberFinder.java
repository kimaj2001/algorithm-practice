package algorithm.programmers.dfs_bfs;

public class TargetNumberFinder {
    /**
     * n개의 음이 아닌 정수들이 있습니다.
     * 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
     * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * @param numbers 사용할 수 있는 숫자가 담긴 배열 numbers, 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
     *                각 숫자는 1 이상 50 이하인 자연수입니다.
     * @param target  타겟 넘버 target. 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
     * @return 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return
     */
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);

        return answer;
    }

    private void dfs(int sum, int idx, int[] numbers, int target) {
        if (idx == numbers.length && sum == target) {
            answer++;
            return;
        }

        if (idx >= numbers.length) {
            return;
        }

        dfs(sum + numbers[idx], idx + 1, numbers, target);
        dfs(sum - numbers[idx], idx + 1, numbers, target);
    }
}
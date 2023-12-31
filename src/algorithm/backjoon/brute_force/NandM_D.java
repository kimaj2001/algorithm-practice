package algorithm.backjoon.brute_force;

import java.util.Scanner;

// 백준 15652 ( N 과 M(4) )
public class NandM_D {
    static int N, M; // 사용해야 할 변수 N 과 M
    static int[] selected, used; // 계산된 결과가 저장될 변수
    static StringBuilder sb;
    /**
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * 1부터 N까지 자연수 중에서 M개를 고른 수열
     * 같은 수를 여러 번 골라도 된다.
     * 고른 수열은 비내림차순이어야 한다.
     * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     *
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sb = new StringBuilder();
        selected = new int[M + 1];


        // 1 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(sb.toString());
    }


    // Recurrence Function (재귀 함수)
    // 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것
    // 아직 M 개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void rec_func(int k) {
        if (k == M + 1) { // 다 골랐다.
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            // start 변수를 추가해서 내림차순이 되지 않도록 설정한다.
            int start = selected[k -1];
            if (start == 0) start = 1;
            for (int j = start; j <= N; j++) {
                selected[k] = j;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }
}



package algorithm.backjoon.brute_force;

import java.util.Scanner;

// 백준 15651 ( N 과 M(3) )
public class NandM_C {
    static int N, M; // 사용해야 할 변수 N 과 M
    static int[] selected; // 계산된 결과가 저장될 변수
    static StringBuilder sb;
    /**
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * 1부터 N까지 자연수 중에서 M개를 고른 수열
     * 같은 수를 여러 번 골라도 된다.
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
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
            // 1~N 까지를 k 번 원소로 한 번씩 정하고,
            // 매번 k+1 번부터 M 번 원소로 재귀호출 해준다.
            for (int j = 1; j <= N; j++) {
                selected[k] = j;
                rec_func(k + 1);
            }
        }
    }
}



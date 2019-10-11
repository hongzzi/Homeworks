package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서_박지홍 {
	private static int[][] a;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());	// 학생들 수, 2 <= N <= 500
			int M = Integer.parseInt(br.readLine());	// 비교횟수, 0 <= M <= N*(N-1)/2
			a = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int small = Integer.parseInt(st.nextToken());
				int tall = Integer.parseInt(st.nextToken());
				a[small][tall] = 1;	// 단방향 그래프 ~
			}
			
			for (int i = 1; i < a.length; i++) {
				up(i);
			}
			
			int totalN = 0;	//자신의 순서를 정확히 알 수 있는 학생 수 
			
			// 학생 수 만큼 up() 메서드 호출 후, 인접행렬에는 나보다 직접 연관이없어도 큰 학생들이 표시되어 있어 ㅡ, 
			for (int i = 1; i < a.length; i++) {
				// 나보다 큰 학생, 작은 학생ㅇ의 합을 구해서 합 = N-1이면 나의 순서를 알 수 있음
				int sum = 0;
				for (int j = 1; j < a.length; j++) {
					sum += a[i][j] + a[j][i];	// i 보다 큰 학생(진출), i 보다 작은 학생 (진입)
				}
				if(sum == N-1) {	// 자신의 순위를 정확히 알 수 있다면, N-1임
					totalN++;
				}
			}
			
			System.out.println("#" + testCase + " " + totalN);
		} 	// end of tc
	}	// end of main

	/* v 정점의 인접행렬 (v 보다 큰 학생) 을 업데이트 (or 연산) */
	private static void up(int v) {
		if(a[v][0] == -1) return;
		for (int i = 0; i < a.length; i++) {
			if(a[v][i] == 1) {	// v < i 큼
				up(i); // 나보다 큰 학생의 인접행렬을 먼저 업데이트 하고 오자 ! 
				// v보다 큰 학생 i의 인접행렬 행을 나의 행과 ( or 연산) 해서 업데이트
				for (int j = 0; j < a.length; j++) {
					a[v][j] |= a[i][j];	// 대박 ㅈ신기 
				}
			}
		}
		a[v][0] = -1;
	}
}	// end of class

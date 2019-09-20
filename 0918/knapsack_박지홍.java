package dp;

import java.util.Arrays;

/**
 * 배낭문제 knapsack
 * 
 * park jession
 * 
 * 배낭문제,, Funtion = 여거ㅜ ;:greedy
 *
 */
public class knapsack_박지홍 {

	public static void main(String[] args) {
		int n = 10;
		int[][] item = {{10, 5},{40, 4},{30, 6},{50, 3}};	// {가격(), 무게}
		
		int[][] K = new int[item.length+1][n+1];	// 최대가치를 저장할 배열
													// 행 : 고려할 물건의 개수, 열: 배낭의 임시 무게
		
		// 첫 행(물건을 아무것도 고려하지 않은 경우의 가치), 첫 열 (배낭의 임시무게가 0일경우 가치 ) 0으로 초기화
		
		// 1번 물건 고려
		// 물건의 무게보다 배낭의 무게가 적은 경우에는 이전행의 데이터를 그대로 복사 
		
		for (int i = 0; i < item.length; i++) {
			for (int w = 0; w < item[i][1]; w++) {
				K[i+1][w] = K[i][w];
			}
			for (int w = item[i][1]; w <= n; w++) {
				 int now = K[i][w-item[i][1]] + item[i][0];// 1번 물건을 고려한 경우
				 int pre = K[i][w];// 1번 물건을 고려하지 않은 경우
				 
				 K[i][w] = now >= pre ? now : pre;
			}	

			System.out.println(Arrays.toString(K[i]));
			
		}
		
		
	} // end of main
} // end of class

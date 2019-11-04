package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발 {
	private static char[][] map;
	private static int[][] color;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int min = Integer.MAX_VALUE;
			
			map = new char[N][M];
			color = new int[N][3];
			dp = new int[N][3];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='W') {
						color[i][0]++;
					} else if(map[i][j]=='B') {
						color[i][1]++;
					} else {
						color[i][2]++;
					}
				}
				dp[i][0] = color[i][1] + color[i][2];
				dp[i][1] = color[i][0] + color[i][2];
				dp[i][2] = color[i][0] + color[i][1];
			}
			
			for (int i = 1; i < N-1; i++) {
				int sumW = 0;
				for (int j = 0; j < i; j++) {
					sumW += dp[j][0];
				}
				for (int j = i+1; j < N; j++) {
					int sumB = 0;
					int sumR = 0;
					for (int j2 = i; j2 < j; j2++) {
						sumB += dp[j2][1];
					}
					for (int j2 = j; j2 < N; j2++) {
						sumR += dp[j2][2];
					}
					int total = sumW+sumB+sumR;
					if(total < min) {
						min = total;
					}
				}
			}
			
			System.out.println("#"+testCase+" "+min);
		}
	}
}

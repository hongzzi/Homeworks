package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7396_종구의딸이름짓기_박지홍2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] board = new char[N][M];
			boolean[][] flag = new boolean[N][M];
			for (int i = 0; i < board.length; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] = tmp.charAt(j);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + testCase + " ");
			
			flag[0][0] = true;
			
			for (int i = 0; i < N+M-1; i++) {
				char max = 'z';
				for (int j = 0; j <= i; j++) {
					if( (i-j < N && j < M) && flag[i-j][j] && (board[i-j][j] < max)) {
						max = board[i-j][j];
					}
				}
				for (int j = 0; j <= i; j++) {
					if( (i-j < N && j < M) && flag[i-j][j] && board[i-j][j] == max) {
						if(i-j+1 < N && j < M) {
							flag[i-j+1][j] = true;
						}
						if(i-j < N && j+1 < M) {
							flag[i-j][j+1] = true;
						}
					}
				}
				sb.append(max);
			}
			
			System.out.println(sb.toString());
		}
		
	}
}

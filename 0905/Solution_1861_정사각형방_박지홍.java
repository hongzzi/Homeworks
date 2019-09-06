package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방_박지홍 {
	
	static int[][] map;
	static int max, min;
	static int[] dirx = { 1, -1, 0, 0 };
	static int[] diry = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 1;
			min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					find(i,j,0);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(testCase).append(' ').append(min).append(' ').append(max+1);
			System.out.println(sb);
		}	// end of testcase
	}	// end of main
	private static void find(int i, int j, int cnt) {
		int value = map[i][j];
		
		if(cnt > max) {
			min = value - cnt;
			max = cnt;
		} else if (cnt == max) {
			min = Math.min(value - cnt, min);
		}
		for (int k = 0; k < 4; k++) {
			int nx = i+dirx[k];
			int ny = j+diry[k];
			if(map[nx][ny] == value+1) {
				find(nx, ny, cnt+1);
				break;
			}
		}
	}
}	// end of class

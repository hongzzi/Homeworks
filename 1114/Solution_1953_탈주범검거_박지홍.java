package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거_박지홍 {

	static class Pipe {
		boolean top;
		boolean bottom;
		boolean left;
		boolean right;

		public Pipe(boolean top, boolean bottom, boolean left, boolean right) {
			super();
			this.top = top;
			this.bottom = bottom;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Pipe [top=" + top + ", bottom=" + bottom + ", left=" + left + ", right=" + right + "]";
		}
	}

	private static Pipe[][] map;
	private static boolean[][] bmap;
	private static int answer;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			map = new Pipe[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					switch (temp) {
					case 1:
						map[i][j] = new Pipe(true, true, true, true);
						break;
					case 2:
						map[i][j] = new Pipe(true, true, false, false);
						break;
					case 3:
						map[i][j] = new Pipe(false, false, true, true);
						break;
					case 4:
						map[i][j] = new Pipe(true, false, false, true);
						break;
					case 5:
						map[i][j] = new Pipe(false, true, false, true);
						break;
					case 6:
						map[i][j] = new Pipe(false, true, true, false);
						break;
					case 7:
						map[i][j] = new Pipe(true, false, true, false);
						break;
					default:
						break;
					}
				}
			}
			bmap = new boolean[N][M];
			answer = 0;
			escape(R, C, L);
			System.out.println("#" + testCase + " " + answer);
		}
	}

	private static void escape(int r, int c, int l) {
		if (l == 0 || map[r][c] == null) {
			return;
		} else {
			if(!bmap[r][c]) answer++;
			bmap[r][c] = true;
			if (map[r][c].bottom) {
				if (r + 1 >= 0 && c >= 0 && r + 1 < N && c < M && map[r + 1][c] != null && map[r + 1][c].top) {
					escape(r + 1, c, l - 1);
				}
			}
			if (map[r][c].top) {
				if (r - 1 >= 0 && c >= 0 && r - 1 < N && c < M && map[r - 1][c] != null && map[r - 1][c].bottom) {
					escape(r - 1, c, l - 1);
				}
			}
			if (map[r][c].right) {
				if (r >= 0 && c + 1 >= 0 && r < N && c + 1 < M && map[r][c + 1] != null && map[r][c + 1].left) {
					escape(r, c + 1, l - 1);
				}
			}
			if (map[r][c].left) {
				if (r >= 0 && c - 1 >= 0 && r < N && c - 1 < M && map[r][c - 1] != null && map[r][c - 1].right) {
					escape(r, c - 1, l - 1);
				}
			}
		}
	}
}

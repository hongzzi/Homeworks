import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2206 {

	static int[][] map;
	static boolean[][] flag;
	static int[] dirx = { 1, 0, -1, 0 };
	static int[] diry = { 0, -1, 0, 1 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		flag[0][0] = true;
		dfs(0, 0, false, 1);

		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

	public static void dfs(int x, int y, boolean wall, int dist) {
		if (x == map.length - 1 && y == map[x].length-1) {
				min = Math.min(dist, min);
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dirx[i];
				int ny = y + diry[i];
				if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[nx].length) {
					if (flag[nx][ny]) {
						continue;
					} else {
						if (map[nx][ny] == 1 && wall) {
							continue;
						} else if (map[nx][ny] == 1 && !wall) {
							flag[nx][ny] = true;
							dfs(nx, ny, true, dist + 1);
							flag[nx][ny] = false;		
						} else {
							flag[nx][ny] = true;
							dfs(nx, ny, wall, dist + 1);
							flag[nx][ny] = false;
						}	
					}
				}

			}
		}
	}
}

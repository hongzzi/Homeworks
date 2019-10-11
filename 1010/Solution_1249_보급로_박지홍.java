package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249_보급로_박지홍 {

	private static Queue<Integer> que;
	private static int[] dirx = { 1, -1, 0, 0 };
	private static int[] diry = { 0, 0, 1, -1 };
	private static int[][] map;
	private static int[][] map2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			map2 = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = tmp.charAt(j) - '0';
					map2[i][j] = Integer.MAX_VALUE;
				}
			}
			que = new LinkedList<Integer>();
			bfs();
			System.out.println("#"+testCase+" "+map2[N-1][N-1]);
		}
	}

	private static void bfs() {
		//que.add(1);
		que.add(0);
		que.add(0);
		//que.add(1);
		map2[0][0] = 0;
		while (que.size() > 0) {
			int size = que.size();
			for (int i = 0; i < size / 2; i++) {
				int x = que.poll();
				int y = que.poll();
				for (int j = 0; j < dirx.length; j++) {
					int nx = x + dirx[j];
					int ny = y + diry[j];
					if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
						if (map2[nx][ny] > map2[x][y] + map[nx][ny]) {
							map2[nx][ny] = map2[x][y] + map[nx][ny];
							que.add(nx);
							que.add(ny);
						} 
					}
				}
			}
		}
	}

}

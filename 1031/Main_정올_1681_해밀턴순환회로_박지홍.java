package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로 {

	private static int[][] map;
	private static int[] delivery;
	private static boolean[] visited;
	private static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		delivery = new int[N];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of input

		min = Integer.MAX_VALUE;
		visited = new boolean[N];

		perm(0, 0, 0);

		System.out.println(min);
	} // end of main

	public static void perm(int cnt, int dist, int n) {
		if (cnt == map.length - 1) {
			if (map[n][0] == 0) {
				return;
			} else {
				dist += map[n][0];
				if (dist < min) {
					min = dist;
				}
			}
		} else {
			for (int i = 1; i < map[n].length; i++) {
				if (!visited[i] && map[n][i] != 0) {
					visited[i] = true;
					perm(cnt + 1, dist + map[n][i], i);
					visited[i] = false;
				}
			}
		}
	}

} // end of class

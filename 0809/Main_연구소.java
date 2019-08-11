package com.ssafy.swexpert.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_연구소 {

	static int[][] map, target;
	static List<Object> que = new LinkedList<Object>();
	static int N, M;
	static int max;
	static int[] dirx = { 0, 1, 0, -1 };
	static int[] diry = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 2) {
					int[] xy = { i, j };
					que.add(xy);
				}
			}
		}

		max = 0;
		wall(3, 0);
		System.out.println(max);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static void wall(int n, int a) {
		if (n == 0) {
			target = new int[N][M];
			for (int i = 0; i < target.length; i++) {
				target[i] = Arrays.copyOf(map[i], map[i].length);
			}
			virus();
		}
		for (int i = a; i < N * M; i++) {
			int y = i%M;
			int x = i/M;
			if (map[x][y] == 1 || map[x][y] == 2) {
				continue;
			} else {
				map[x][y] = 1;
				wall(n - 1, i);
				map[x][y] = 0;
			}

		}
	}

	public static void virus() {

		// 바이러스 뿌리기
		for (int i = 0; i < que.size(); i++) {
			int[] xy = (int[]) que.get(i);
			int x = xy[0];
			int y = xy[1];
			spread(x, y);
		}

		// 안전한 장소 카운트
		int cnt = 0;
		for (int i = 0; i < target.length; i++) {
			for (int j = 0; j < target[i].length; j++) {
				if (target[i][j] == 0) {
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}

	public static void spread(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dirx[i];
			int ny = y + diry[i];
			if (nx >= 0 && ny >= 0 && nx < target.length && ny < target[nx].length) {
				if (target[nx][ny] == 0) {
					target[nx][ny] = 2;
					spread(nx, ny);
				}
			}
		}
	}
}

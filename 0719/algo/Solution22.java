package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution22 {

	static int T, N, S, x, y, d, count;
	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			count = S;
			for (int i = 0; i < S; i++) {

				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());

				count = move(map, x, y, d, count);
			}

			System.out.printf("\n#%d %d",testcase+1,count);

		}

	}

	public static int move(int[][] map, int x, int y, int d, int count) {
		
		int newX = x;
		int newY = y;

		for (int i = 3; i >= 1; i--) {
			
			newX = newX + dx[d % 4] * i;
			newY = newY + dy[d % 4] * i;
			
			if (newX >= map.length || newX < 0 || newY >= map.length || newY < 0) { // case 1. 경계선을 넘어갔을 때 죽음
				count--;
				return count;
			} else if (map[newX][newY] == 1) { // case 2. 이미 소금쟁이가 있는곳에 가서 죽을 때
				count--;
				return count;
			} else { // case 3. 무사 도착
				continue;
			}
		}
		
		map[newX][newY] = 1;
		return count;
	}

}

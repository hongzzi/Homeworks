package com.ssafy.swexpert.lv2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

	static int[][] tomato;
	static int day, index;
	static Queue<Tom> queue = new LinkedList<Tom>();
	static int[] dirx = { 1, -1, 0, 0 };
	static int[] diry = { 0, 0, 1, -1 };

	public static class Tom {
		int x;
		int y;

		public Tom(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		boolean flag = false; // 변경된적있나여 
		tomato = new int[m][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				tomato[i][j] = stoi(st.nextToken());
				if (tomato[i][j] == 1) {
					Tom tom = new Tom(i, j);
					queue.add(tom);
					index++;
				}
			}
		}

		while (queue.size() > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Tom tom = queue.poll();
				for (int j = 0; j < 4; j++) {
					int nx = tom.x + dirx[j];
					int ny = tom.y + diry[j];
					if (nx >= 0 && ny >= 0 && nx < tomato.length && ny < tomato[nx].length) {
						if (tomato[nx][ny] == 0) {
							tomato[nx][ny] = 1;
							flag = true;
							queue.add(new Tom(nx, ny));
						}
					}
				}
			}
			if(flag) {
				day++;
			} else {
				break;
			}
			flag = false;
		}
		
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[i].length; j++) {
				if(tomato[i][j] == 0) {
					day = -1;
				}
			}
		}
		
		System.out.println(day);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}

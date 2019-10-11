package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_박지홍 {
	
	private static int[][] map;
	private static boolean[][] bmap;
	private static int[] dirx = {1, -1, 0, 0, 1, 1, -1, -1};
	private static int[] diry = {0, 0, 1, -1, 1, -1, 1, -1};
	static class Dot {
		int x;
		int y;
		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		while(w!=0 && h!=0) {
			int landCnt = 0;
			map = new int[h][w];
			bmap = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						bmap[i][j] = true;
					}
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(bmap[i][j] == true) {
						bmap[i][j] = false;
						dfs(i, j);
						landCnt++;
					}
				}
			}
			System.out.println(landCnt);
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
	}
	static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dirx[i];
			int ny = y + diry[i];
			if(isIn(nx, ny) && bmap[nx][ny]) {
				bmap[nx][ny] = false;
				dfs(nx, ny);
			}
		}
	}
	static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<map.length && y<map[0].length;
	}
}

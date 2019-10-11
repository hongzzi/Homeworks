package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3349_최솟값으로이동하기_박지홍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int val = 0;	// 이동비용의 최솟값 
			st = new StringTokenizer(br.readLine(), " ");
			int preX = Integer.parseInt(st.nextToken());
			int preY = Integer.parseInt(st.nextToken());
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				int dx = x-preX;
				int dy = y-preY;
				boolean cross = dx>0 && dy>0 || dx<0 && dy<0; // && 논리곱 || 논리덧셈
				if (dx < 0) dx = -dx;
				if (dy < 0) dy = -dy;
				
				if(cross) {	// 대각경로를 이용할 수 있다면
					val += dx <= dy ? dy : dx;
				} else  {
					val += dx + dy;
				}
				
				preX = x;
				preY = y;
			}
			
			
			
			System.out.println("#"+testCase+" "+val);
		}
	}
}

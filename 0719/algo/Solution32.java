package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution32 {

	static int T, Y, X, N; // 테스트케이스, 배열크기, 참가자 수
	static int[][] map;	// 게임판
	static int[][] user;	// 유저정보
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int PAY = -1000;
	static int AWARD = 100;
	static int x, y, jumpPlay;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {
			
			st = new StringTokenizer(br.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[Y+1][X+1];
			user = new int[N][3];
			
			
			/*
			 * 
			 * 값 읽어오는 단락
			 * 
			 */
			
			for (int i = 1; i <= Y; i++) {	// 게임판 저장
				
				st = new StringTokenizer(br.readLine());
				
				for (int j = 1; j <= X; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			
			
			for (int i = 0; i < N; i++) {	// 참가자 정보 저장
				
				st = new StringTokenizer(br.readLine());
				user[i][0] = Integer.parseInt(st.nextToken());
				user[i][1] = Integer.parseInt(st.nextToken());
				user[i][2] = Integer.parseInt(st.nextToken());
//				System.out.println(Arrays.toString(user[i]));
			}
			
			st = new StringTokenizer(br.readLine());
			int trapCount = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < trapCount; i++) {	// 함정 저장
				int ex = Integer.parseInt(st.nextToken());
				int ey = Integer.parseInt(st.nextToken());
				map[ex][ey] = 0;
			}
			

			/*
			 * 
			 * 게임 플레이
			 * 
			 */
			
			int getMoney = PAY * N;
			
			for (int i = 0; i < N; i++) {	// 참가자 수 만큼 게임
				
				x = user[i][0];
				y = user[i][1];	
				jumpPlay = user[i][2];
				
				int d, jumpCount;

				for (int j = 0; j < jumpPlay; j++) {
					
					if ( outRange(map,x,y) || isTrap(map,x,y)) {
						break;
						
					} else {
						
						d = map[x][y]/10;
						jumpCount  = map[x][y]%10;
						x = x + dx[d%4]*jumpCount;
						y = y + dy[d%4]*jumpCount;
						
					}

				}
				//if( outRange(map,x,y) || flag || isTrap(map,x,y) ) {

				//} else {
					getMoney += map[x][y] * AWARD;
				//}

			}
			
			System.out.printf("\n#%d %d",testcase+1, getMoney);
			
		}

	}
	
	// 함정일 때
	public static boolean isTrap (int[][] map, int x, int y) {
		if( map[x][y] == 0 )
			return true;
		else
			return false;
	}
	
	// 경계값 벗어날 때
	public static boolean outRange (int[][] map, int x, int y) {

		if( x >= map.length ||  y >= map.length || x <= 0 || y <= 0 )	
			return true;
		else 
			return false;
	}

}

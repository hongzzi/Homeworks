package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution13 {

	static int T, N;
	static int[] dir1 = {1, 0, -1, 0};
	static int[] dir2 = {1, 1, -1, -1};
	
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase= 0; testcase<T ; testcase ++) {
			
			int Top = 0;
			int tmp;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int[][] map2 = new int[N][N]; 
			
			
			// 맵 초기화
			for (int i = 0; i < map.length; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				for (int j =0 ; j < map.length ; j++) {
					if ( st.nextToken().equals("G") ) {
						map[i][j] = 0;
					} else 
						map[i][j] = 1;
				}
			}
			
			
			// 완전탐색
			for (int i = 0; i < map.length; i++) {
				
				for (int j = 0; j < map[i].length; j++) {
					
					tmp = 0;
					
					// 8방 탐색
					map2[i][j] = map[i][j] * get4DirSum1(map, i, j)*get4DirSum3(map, i, j);
					
					// 8방에 G가 없으면, 가로 세로 B의 갯수 구하기
					if (map2[i][j] == 1 ) {
						tmp = sumBcharRow(map, i) + sumBcharCol(map, j) - 1;
					} else {
						// G가 있으면 2
						tmp = 2;
					}
					
					// 최대값
					Top = Math.max(Top, tmp);
						
				}
//				System.out.println(Arrays.toString(map2[i]));
				
			}
			
			System.out.printf("\n#%d %d", testcase+1, Top);
		
		}
		
		
	}
	
	
	
	public static boolean isIn(int r, int c, int length) {
		
		 if ( (r < 0) || c < 0 || (r >= length) || (c >= length))	return false;
		 else return true;
		 
	}
	
	
	// 주어진 위치를 기준으로 4방 요소의 합을 리턴하시오 1
	public static int get4DirSum1(int[][] arr, int r, int c) {
		
		int sum = 1;
		
		for (int i = 0; i < dir1.length; i++) {
			int x = r+dir1[i%4];
			int y = c+dir1[(i+1)%4];
			// G가 있으면 0으로 만들기 위해 곱셈연산 ( B : 1, G : 0 )
			if(isIn(x, y, arr.length))
				sum *= arr[x][y];
		}
		
		return sum;
	}
	
	// 크로스 탐색
	public static int get4DirSum3(int[][] arr, int r, int c) {
		
		int sum = 1;
		
		for (int i = 0; i < dir2.length; i++) {
			int x = r+dir2[i%4];
			int y = c+dir2[(i+1)%4];
			// G가 있으면 0으로 만들기 위해 곱셈연산 ( B : 1, G : 0 )
			if(isIn(x, y, arr.length))
				sum *= arr[x][y];
		}
		
		return sum;
	}
	
	
	
	public static int sumBcharRow (int[][] arr, int col) {
		int count = 0;
		
		for (int i = 0; i<arr.length; i++) {				// ( B : 1, G : 0 ) 이므로 쭉 연산
			count += arr[col][i];
		}
		return count;	
	}
	
	public static int sumBcharCol (int[][] arr, int row) {	// ( B : 1, G : 0 ) 이므로 쭉 연산
		int count = 0;
		
		for (int i = 0; i<arr[row].length; i++) {
			count += arr[i][row];
		}
		
		return count;
	}

}

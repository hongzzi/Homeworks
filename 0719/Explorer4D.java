package com.ssafy.day3.array;

import java.util.Arrays;

public class Explorer4D {


	static int[] dir = {1, 0, -1, 0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 1;
		
		int[][] arr2D = new int[5][5];
		for (int i= 0; i<arr2D.length; i++) {
			for (int j = 0; j < arr2D.length; j++) {
				arr2D[i][j] = num++;
			}
		}
		
//		System.out.println(Arrays.toString(arr2D[0]));
//		System.out.println(Arrays.toString(arr2D[1]));
//		System.out.println(Arrays.toString(arr2D[2]));
//		System.out.println(Arrays.toString(arr2D[3]));
//		System.out.println(Arrays.toString(arr2D[4]));
		
		int max = 0;
		int maxX = 0;
		int maxY = 0;
		
		int[][] arr4D = new int[5][5];
		for (int i = 0; i < arr4D.length; i++) {
			for (int j = 0; j < arr4D.length; j++) {
				arr4D[i][j] = get4DirSum1(arr2D, i, j);
				if (arr4D[i][j] > max) {
					max = arr4D[i][j];
					maxX = i;
					maxY = j;
				}
				
			}
			System.out.println(Arrays.toString(arr4D[i]));
		}
		System.out.println(arr2D[maxX][maxY]);
		
	}
	
	public static boolean isIn(int r, int c, int length) {
		
		 if ( (r < 0) || c < 0 || (r >= length) || (c >= length))	return false;
		 else return true;
		 
	}
	
	
	// 주어진 위치를 기준으로 4방 요소의 합을 리턴하시오 1
	public static int get4DirSum1(int[][] arr, int r, int c) {
		
		int sum = 0;
		
		for (int i = 0; i < dir.length; i++) {
			int x = r+dir[i%4];
			int y = c+dir[(i+1)%4];
			if(isIn(x, y, arr.length))
				sum += arr[x][y];
		}
		
		return sum;
	}

	public static int get4DirSum2(int[][] arr, int r, int c) {
		
		int sum = 0;
		
		for (int i = 0; i < dir.length; i++) {
			int x = r+dir[i%4];
			int y = c+dir[(i+1)%4];
			if(isIn(x, y, arr.length))
				sum += arr[x][y];
		}
		
		return sum;
	}
	

}

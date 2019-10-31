package com.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크_박지홍 {
	
	private static int[][] map;
	private static int[] trr;
	private static int[] srr;
	private static int min;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		trr = new int[N/2];
		trr[trr.length-1] = N-1;
		srr = new int[N/2];
		
		min = Integer.MAX_VALUE;
		comb(N-1, N/2-1);
		
		System.out.println(min);
	}
	
	private static void comb(int n, int r) {
		if(min == 0) return;
		if(r==0) {	// 조합이 완성된 상황
			for (int i = 0, tIndex = 0, sIndex = 0; i < N; i++) {
				if(i==trr[tIndex]) {
					tIndex++;
				} else {
					srr[sIndex++] = i;
				}
			}
			check();
		} else if(n < r) {
			return;
		} else {
			trr[r-1] = n-1;
			comb(n-1, r-1);
			comb(n-1, r);
		}
	}

	/*trr팀과 orr팀의 능력치 차이*/
	private static void check() {
		int t = 0; // trr팀의  능력치 합
		for (int i = 0; i < trr.length; i++) {
			for (int j = 0; j < trr.length; j++) {
				t += map[trr[i]][trr[j]];
			}
		}
		int s = 0; // trr팀의  능력치 합
		for (int i = 0; i < srr.length; i++) {
			for (int j = 0; j < srr.length; j++) {
				s += map[srr[i]][srr[j]];
			}
		}
		
		int diff = t-s;
		if(diff < 0) 	diff = -diff;
		if(min > diff) min = diff;	// 최솟값 업데이트
	}
}

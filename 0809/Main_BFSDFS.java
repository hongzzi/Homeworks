package com.ssafy.swexpert.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BFSDFS {

	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int V = stoi(st.nextToken());
		
		map = new int[N+1][N+1]; 
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			map[a][b] = map[b][a] = 1; 
			
		}
		
		
		dfs(V, N);
		
		visited = new boolean[N+1];
		System.out.println();
		bfs(V, N);
		
		
	}

	public static void dfs(int v, int n) {
		if (visited[v]) {
			return;
		} else {
			
			visited[v] = true;
	
			System.out.print(v + " ");

			for (int i = 1; i <= n; i++) {
				if(map[v][i] == 1) {
					dfs(i, n);
				}
			}
		}
	}

	public static void bfs(int v, int n) {
		Queue<Integer> bfs = new LinkedList<>();
		
		bfs.add(v);
		visited[v] = true;
		while (bfs.size() != 0) {
			int temp = bfs.poll();
			System.out.print(temp + " ");
			for (int j = 1; j <= n; j++) {
				if (visited[j]) {
					continue;
				} else if(map[temp][j] == 1) {
					bfs.add(j);
					visited[j] = true;
				}
			}
			
		}
		
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}

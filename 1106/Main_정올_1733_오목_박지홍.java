package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1733_오목_박지홍 {
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		arr = new int[19][19];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean check = false;
		l1: for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j][i] != 0) {
					check = find(j, i, arr[j][i]);
					if (check) {
						System.out.println(arr[j][i]);
						System.out.println((j+1) + " " + (i+1));
						break l1;
					}
				}
			}
		}
		if (!check) {
			System.out.println(0);
		}
	}

	private static boolean find(int n, int m, int p) {
		int cnt = 0;
		for (int i = n; i < arr.length; i++) {
			// 아래로
			if (arr[i][m] != p) {
				break;
			}
			cnt++;
		}
		if (cnt == 5) {
			if (n - 1 >= 0 && arr[n - 1][m] == p) {
				cnt++;
			}
			if(cnt == 5) return true;
		}
		cnt = 0;
		for (int i = m; i < arr.length; i++) {
			// 옆으로
			if (arr[n][i] != p)
				break;
			cnt++;
		}
		if (cnt == 5) {
			if (m - 1 >= 0 && arr[n][m - 1] == p) {
				cnt++;
			}
			if(cnt == 5) return true;
		}
		cnt = 0;
		for (int j = 0; j < arr.length; j++) {
			if (n - j >= 0 && m + j < arr.length) {
				if (arr[n - j][m + j] == p) {
					cnt++;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		if (cnt == 5) {
			if (m - 1 >= 0 && n + 1 < arr.length && arr[n + 1][m - 1] == p) {
				cnt++;
			}
			if(cnt == 5) return true;
		}
		cnt = 0;
		for (int j = 0; j < arr.length; j++) {
			if (n + j < arr.length && m + j < arr.length) {
				if (arr[n + j][m + j] == p) {
					cnt++;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		if (cnt == 5) {
			if (m - 1 >= 0 && n - 1 >= 0 && arr[n - 1][m - 1] == p) {
				cnt++;
			}
			if(cnt == 5) return true;
		}
		return false;

	}
}

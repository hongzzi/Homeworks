package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_준환이의_양팔저울 {

	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			boolean[] visited = new boolean[N];
			powerSet(0, 0, 0, arr, visited);
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void powerSet(int l, int r, int cnt, int[] arr, boolean[] visited) {
		if (r > l) {
			return;
		} else if (cnt == arr.length) {
			answer++;
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					powerSet(l + arr[i], r, cnt + 1, arr, visited);
					powerSet(l, r + arr[i], cnt + 1, arr, visited);
					visited[i] = false;
				}
			}
		}
	}
}

package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {

	static int answer;
	static int[][] arr;
	static int[] check;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		arr = new int[H][N + 1];
		check = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = b + 1;
			arr[a][b + 1] = b;
			check[b]++;
			check[b + 1]++;
		}

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 1; i < check.length - 1; i++) {
			if (cnt > 3 || check[i - 1] % 2 == 1) {
				cnt = -1;
				break;
			}
			if (check[i] % 2 == 1) { // 홀수개의 선을 갖고있으면 그을 선 찾기시작
				stack.removeAllElements();
				for (int j = 0; j < H; j++) {
					if (arr[j][i] != 0) {
						if (stack.size() > 0 && stack.peek() == arr[j][i]) {
							stack.pop();
						} else {
							stack.push(arr[j][i]);
						}
					}
					if (arr[j][i] == 0) {
						if (isP(j, i)) {
							if (stack.size() == 0) {
								arr[j][i] = i + 1;
								arr[j][i + 1] = i;
								cnt++;
								check[i]++;
								check[i + 1]++;
								break;
							} else {
								if (stack.peek() == i + 1) {
									arr[j][i] = i + 1;
									arr[j][i + 1] = i;
									cnt++;
									check[i]++;
									check[i + 1]++;
									break;
								} else {
									continue;
								}
							}
						}
					}
				}
			} else { // 짝수면 다음칸
				continue;
			}
		}

		stack.removeAllElements();

		for (int i = 1; i < check.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (stack.size() > 0 && stack.peek() == arr[j][i]) {
					stack.pop();
				} else if (arr[j][i] != 0) {
					stack.push(arr[j][i]);
				}
			}
			if (stack.size() > 0) {
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);

	}

	public static boolean isP(int h, int w) {
		boolean right = false;
		if (arr[h][w + 1] == 0)
			right = true;
		return right;
	}

}

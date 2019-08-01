import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1809_박지홍 {

	public static void main(String[] args) throws IOException {
		// 스택으로 풀기..
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int num = Integer.parseInt(br.readLine());
		int[] height = new int[num + 1];
		int[] stack = new int[height.length];
		int top = -1;
		height[0] = Integer.MAX_VALUE;

		// 탑의 높이를 배열에 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < height.length; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = num; i > 0; i--) {
			
			for (int j = i - 1; j >= 0; j--) {
				if (height[i] < height[j]) {	// 나보다 큰 탑을 발견하면 stack push, for문 종료
					stack[++top] = j;
					break;
				}
			}

		}
		while (top > -1) {
			System.out.print(stack[top--] + " ");
		}
	}

}

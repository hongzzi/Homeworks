import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_5432_쇠막대기자르기_박지홍 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String input = br.readLine();

			Stack<Character> stack = new Stack<>();
			int piece = 0;

			for (int j = 0; j < input.length() - 1; j++) {

				if (input.charAt(j) == '(' && input.charAt(j + 1) == ')') {

					piece += stack.size();

				} else if (input.charAt(j) == '(' && input.charAt(j + 1) == '(') {

					stack.push(input.charAt(j));

				} else if (input.charAt(j) == ')' && input.charAt(j + 1) == ')') {

					stack.pop();
					piece++;

				} else
					continue;

			}
			System.out.println("#"+(i+1)+" "+piece);
		}

	}
}

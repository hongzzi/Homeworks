import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1224_SW문제해결기본6일차_계산기3_박지홍 {

	static int T = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testCase = 1; testCase < T; testCase++) {
			int len = Integer.parseInt(br.readLine()); // 문자열 길이

			String num = br.readLine();
			// 문자열
			char[] op = new char[len];
			int top = -1;
			char[] crr = new char[len];
			int index = 0;

			for (int i = 0; i < len; i++) {
				char c = num.charAt(i);
				switch (c) {
				case '(': 
					op[++top] = c;
					break;
				case '*': 
				case '/': 
					while (top >= 0 && op[top] == '*' || op[top] == '/') {
						crr[index++] = op[top--];
					}
					op[++top] = c;
					break;
				case '+': 
				case '-':
					while (top >= 0 && op[top] != '(') {
						crr[index++] = op[top--];
					}
					op[++top] = c;
					break;
				case ')': 
					while (top >= 0 && op[top] != '(') {
						crr[index++] = op[top--];
					}
					break;
				default: 
					crr[index++] = c;
					break;
				}
			}
			while(top>-1) {
				crr[index++]  = op[top--];
			}
			
			int [] stackNum = new int[crr.length];
			top = -1;	// top리셋
			
			for (int i = 0; i < index; i++) {
				char c = crr[i];
				int num1, num2; 
				switch (c) {
				case '+' :
					num2 = stackNum[top--];
					num1 = stackNum[top--];
					stackNum[++top] = num1 + num2;
					break;
				case '*' :
					num2 = stackNum[top--];
					num1 = stackNum[top--];
					stackNum[++top] = num1 * num2;
					break;
				default:
					stackNum[++top] = crr[i]-'0';
					break;
				}	
			}
			
			System.out.println(stackNum[top]);
		}
	}
}

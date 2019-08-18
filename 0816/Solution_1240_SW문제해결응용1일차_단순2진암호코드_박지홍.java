import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드_박지홍 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			String tmp = "";
			String[] str = new String[8];
			int[] code = new int[8];
			boolean flag = false;

			for (int i = 0; i < N; i++) {
				tmp = br.readLine();
				for (int j = M - 1; j >= M - 50; j--) {
					int c = tmp.charAt(j) - '0';
					if (c == 1) { // 1이 있는 줄을 발견하면 ~
						tmp = tmp.substring(j - 55, j + 1);
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			for (int i = 0; i < str.length; i++) {
				str[i] = tmp.substring(i * 7, (i + 1) * 7);
				switch (str[i]) {
				case "0001101":
					code[i] = 0;
					break;
				case "0011001":
					code[i] = 1;
					break;
				case "0010011":
					code[i] = 2;
					break;
				case "0111101":
					code[i] = 3;
					break;
				case "0100011":
					code[i] = 4;
					break;
				case "0110001":
					code[i] = 5;
					break;
				case "0101111":
					code[i] = 6;
					break;
				case "0111011":
					code[i] = 7;
					break;
				case "0110111":
					code[i] = 8;
					break;
				case "0001011":
					code[i] = 9;
					break;
				}
			}

			int sum = (code[0] + code[2] + code[4] + code[6]) * 3 + code[1] + code[3] + code[5] + code[7];
			int answer = 0;
			if (sum % 10 == 0) {
				sum = 0;
				for (int i = 0; i < code.length; i++) {
					sum+=code[i];
				}
				answer = sum;
			}

			System.out.println("#"+testCase+" "+answer);
		}

	}

}

// 01110110110001011101101100010110001000110100100110111011
package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3459_승자예측하기_박지홍 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] srr = { "Alice","Bob"};
		
		for (int testCase = 1; testCase <= T; testCase++) {
			long num = Long.parseLong(br.readLine());
			String bs = Long.toBinaryString(num);
			int len = bs.length();
			int ai = 1; // answerIndex

			System.out.println(bs + " " + len);
 
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(testCase).append(' ').append(srr[ai]);
			System.out.println(sb);
		}

	}

}

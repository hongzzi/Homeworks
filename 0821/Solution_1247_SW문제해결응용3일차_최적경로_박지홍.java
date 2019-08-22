import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1247_SW문제해결응용3일차_박지홍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int k = Integer.parseInt(br.readLine());
			
			String sen = br.readLine();
			String answer = "";
			
			if(k > sen.length()) {
				answer = "none";
			} else {
				String[] srr = new String[sen.length()];
				for (int i = 0; i < sen.length(); i++) {
					srr[i] = sen.substring(i, sen.length());
				}
				
				Arrays.sort(srr);
				answer = srr[k-1];
			}
			System.out.println("#"+testCase+" "+answer);
		}
	}
}

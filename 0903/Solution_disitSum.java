import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_disitSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] crr = new int[10];
		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();
			str = mknum(str);
			System.out.println("#"+testCase+" "+str);
		}
	}
	
	public static String mknum(String str) {
		if(str.length()==1) {
			return str;
		}
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		return mknum(String.valueOf(sum));
	}

}

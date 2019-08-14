import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7829 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		int p;
		long answer;
		
		for (int i = 1; i <= T; i++) {
			p = Integer.parseInt(br.readLine());
			int[] arr = new int[p];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < p; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			if (p == 1) {
				answer = (long) Math.pow(arr[0],2);
			} else {
				Arrays.sort(arr);
				answer = arr[0] * arr[arr.length-1];
			}
			
			System.out.println("#"+i+" "+answer);
		}
		

	}

}

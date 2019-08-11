import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_조만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

//			int student = n * k;
//			int[] answer = new int[k];
//			int index = 0;
//
//			for (int j = 1; j <= student; j++) {
//				if ( j > k && ((j-1) / k) % 2 == 1) {	// 역방향
//					answer[(--index)%k] += j;
//				} else {				// 정방향
//					answer[(index++)%k] += j;
//				}
//			}
//			
//			System.out.print("#" + i);
//			
//			for (int j = 0; j < answer.length; j++) {
//				System.out.print(" "+answer[j]);
//			}

			int answer = 0;

			System.out.print("#" + i);

			if (n % 2 == 0) {
				for (int j = 0; j < (n / 2); j++) {
					answer += (2 * j * k) + 1;
					answer += 2 * (j + 1) * k;
				}
			} else {
				for (int j = 0; j < (n / 2) + 1; j++) {
					answer += 2 * j * k;
					answer += 2 * j * k + 1;
				}
			}
			
//			if (k % 2 == 1 && n % 2 == 1) {
//				answer = answer + k - 1;
//				for (int j = 0; j < k; j++) {
//					System.out.print(" " + answer--);	
//				}
//			} else 
			if ( n % 2 == 0 ){
				for (int j = 0; j < k; j++) {
					System.out.print(" " + answer);
				}
			} else {
				for (int j = 0; j < k; j++) {
					System.out.print(" " + answer++);	
				}
			}

			System.out.println();
		}
	}

}

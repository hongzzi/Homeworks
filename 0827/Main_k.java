import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_k {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr1 = new int[N];
		int answer;
		st = new StringTokenizer(br.readLine());
		
		for (int i =0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr2 = Arrays.copyOfRange(arr1, 1, arr1.length-1);
		Arrays.sort(arr2);
		
		if(arr1[0] < arr2[K-1])
			answer = arr2[K-2];
		else
			answer = arr2[K-1];

		System.out.println(answer);
	}
}
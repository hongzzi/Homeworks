import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_1244_SW문제해결응용2일차_최대상금_박지홍 {	
	
	static int[] arr;
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			arr = new int[str.length()];
			
			cnt = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i)-'0';
			}
			
			dfs(0,0);
			
			System.out.println("#"+t+" "+max);
            max = 0;
		}
		
		br.close();
	}
	
	static int max = 0;
	
	public static void dfs(int num, int idx) {
		if(num==cnt) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			
			max = Math.max(max, Integer.parseInt(new String(sb)));
			
		}else {
			for (int i = idx; i < arr.length; i++) {
				for (int j = i+1; j < arr.length; j++) {
					if(arr[i]<= arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						
						dfs(num+1, i);
                        
                        temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
	}
}

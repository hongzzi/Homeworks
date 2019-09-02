import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_백만장자프로젝트 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
 
            long buy = 0;
            int cnt = 0;
            long sell = 0;
            long save = 0;
 
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > save) {
                    sell += save*cnt-buy;
                    buy = 0;
                    cnt = 0;
                    save = arr[i];
                } else {
                    buy += arr[i];
                    cnt ++;
                }
            }
            if (cnt > 0) {
                sell += save*cnt-buy;
            }
            System.out.println("#"+testCase+" "+sell);
        }
 
    }
}
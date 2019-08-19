import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_경사로 {

    static int n, l;
    static int[][] map;
    static int result = 0 ;

    static int stoi (String s) { return Integer.parseInt(s); }
    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        l = stoi(st.nextToken());

        map = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            if(line(i, 0, 0))
                result++;
            if(line(0, i, 1))
                result++;
        }

        System.out.println(result);
    }

    static boolean line(int a, int b, int c) {

        int[] height = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(c == 0) {
                height[i] = map[a][b+i];
            }
            else
                height[i] = map[a+i][b];
        }

        int len = 0;
        for(int i=0; i<n-1; i++) {

            int tmp = height[i] - height[i+1];

            if (tmp == 0) {
                len ++;
                continue;
            }

            if(Math.abs(tmp) > 1 )
                return false;

            if( tmp == 1 ) {
                for(int j=i+1; j<=i+l; j++) {
                    if(j >= n || height[i+1] != height[j] || visited[j] == true)
                        return false;
                    visited[j] = true;
                }

            } else if(tmp == -1) {
                for(int j=i; j>i-l;j--) {
                    if(j < 0 || height[i] != height[j] || visited[j] == true)
                        return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }

}

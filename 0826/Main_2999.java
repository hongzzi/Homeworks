import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2999 {

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String ans = "";
        int len = str.length();
        int row = getRC(len);
        int col = len/row;
        int index = 0;

        Character[][] arr = new Character[row][col];

        for (int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                arr[i][j] = str.charAt(index++);
            }
        }

        for (int i = 0; i<col; i++) {
            for(int j = 0; j<row; j++) {
                ans = ans + arr[j][i];
            }
        }

        bw.write(ans);
        bw.flush();
        bw.close();
    }

    public static int getRC(int len) {
        int result = 0;
        int sq = (int)Math.sqrt(len);
        for( int i = sq ; i > 0 ; i-- ) {
            if( len % i == 0 ) {
                result = len / i;
                break;
            }
        }
        return result;
    }
}

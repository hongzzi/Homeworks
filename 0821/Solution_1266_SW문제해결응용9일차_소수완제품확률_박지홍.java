import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_1266 {
    static int[] prime = {2, 3, 5, 7, 11, 13, 17};
    static int[] comPrime = {153, 816, 8568, 31824, 31824, 8568, 18};
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double aPer, bPer;
            aPer = getPercent(a);
            bPer = getPercent(b);
            
            double answer = (aPer+bPer)-(aPer*bPer);
            System.out.printf("#%d %.6f\n",testCase,answer);
            
        }
    }
    
    public static double getPercent(int per) {
        double success = per/100d;
        double fail = (100-per)/100d;
        double result = 0;
        
        System.out.println(success+" "+fail);
        
        for (int i = 0; i < prime.length; i++) {
            result += Math.pow(success, prime[i])*Math.pow(fail,(18-prime[i]))*comPrime[i];
        }
        
        return result;
    }
    
}
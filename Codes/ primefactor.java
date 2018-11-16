import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class PrimeFactors {
	public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
                while (n % i == 0) {
                        factors.add(i);
                        n /= i;
                }
        }
        if (n > 1) {
                factors.add(n);
        }
        return factors;
	}

        public static void main(String[] args) throws IOException {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	int n = Integer.parseInt(br.readLine());
        	for(int i =0 ;i<n;i++){
        		int t = Integer.parseInt(br.readLine());
                for (Integer integer : primeFactors(t)) {
                        System.out.print(integer+" ");
                }
                System.out.println();
        	}
        }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lcs_algorithm {
	public static int lcs(String[]s1,String[]s2) {  
	    int len1 = s1.length;  
	    int len2 = s2.length;  
	    int c[][] = new int[len1+1][len2+1];  
	    for (int i = 0; i <= len1; i++) {  
	        for( int j = 0; j <= len2; j++) {  
	            if(i == 0 || j == 0) {  
	                c[i][j] = 0;  
	            } else if (s1[i-1] .equals(s2[j-1])) {  
	                c[i][j] = c[i-1][j-1] + 1;  
	            } else {  
	                c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);  
	            }  
	        }  
	    }  
	    return c[len1][len2];  
	}  
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] c= br.readLine().split(" ");
		System.out.println(lcs(br.readLine().split(" "),br.readLine().split(" ")));
		
	}
}
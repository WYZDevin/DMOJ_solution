import java.io.*;
import java.util.*;

public class ccc13s3 {
	static BufferedReader br;
	static StringTokenizer st;
	static int [] ts= new int [5];
	static int fv;
	static boolean [] [] tp = new boolean [5][5];
	static int count=0;
	public static void move(){
		boolean c=false;
		for(int i=1;i<5;i++){
			for(int j=1;j<5;j++){
				if(i==4 && j==4){
//					System.out.println(Arrays.toString(ts));
					int fvs=ts[fv];
					boolean ck=true;
					for(int k = 1;k<5;k++){
						if(k==fv)continue;
						if(ts[k]>=fvs)ck=false;
					}
					if(ck){
						count++;
						
					}
				}
				if(!tp[i][j]){
					tp[i][j]=true;
					tp[j][i]=true;
					ts[i]+=3;
					move();
					ts[i]-=3;
					ts[j]+=3;
					move();
					ts[j]-=3;
					ts[i]++;
					ts[j]++;
					move();
					ts[i]--;
					ts[j]--;
					tp[i][j]=false;
					tp[j][i]=false;
					c=true;
					break;
				}
			}
			if(c)break;
		}
	}
	public static void main (String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	    fv = readInt();
	    int rm = readInt();
	    for(int i =0;i<rm;i++){
	    	int t1=readInt();
	    	int t2=readInt();
	    	int s1=readInt();
	    	int s2=readInt();
	    	tp[t1][t2]=true;
	    	tp[t2][t1]=true;
	    	if(s1>s2)ts[t1]+=3;
	    	else if(s2>s1)ts[t2]+=3;
	    	else{
	    		ts[t1]+=1;
	    		ts[t2]+=1;
	    	}
	    }
	   for(int i=1;i<5;i++){
		   tp[i][i]=true;
	   }
	   move();
	   System.out.println(count);
	    
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong () throws IOException {
		return Long.parseLong(next());
	}

	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter () throws IOException {
		return next().charAt(0);
	}

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
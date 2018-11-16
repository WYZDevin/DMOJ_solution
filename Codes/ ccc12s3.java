import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ccc12s3 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int [] ac = new int [1003];
		int b=0;
		for (int i = 1; i <=a; i++) {
			b=Integer.parseInt(br.readLine());
			ac[b]++;
		}
		int lar=0,slar=0;
		int [] f= new int[2];
		int [] s = new int[2];
		for (int i = 1; i < ac.length; i++) {
			if(ac[i]==0)continue;
			if(ac[i]>lar){
				slar=lar;
				lar=ac[i];
				for (int j = 0; j < 2; j++) {
					s[j]=f[j];
					f[j]=0;
				}
				f[0]=i;
				f[1]=i;
			}else if(ac[i]==lar){
				if(i<f[1]){
					f[1]=i;
				}
				if(i>f[0]){
					f[0]=i;
				}
			}else if(ac[i]>slar){
				slar=ac[i];
				s[0]=i;
				s[1]=i;
			}else if(ac[i]==slar){
				if(i<s[1]){
					s[1]=i;
				}
				if(i>s[0]){
					s[0]=i;
				}
			}
		}
		if(f[0]==f[1]){
			if(s[0]==s[1]){
				System.out.println(Math.abs(s[0]-f[0]));
			}else{
				int l=Math.abs(s[0]-f[0]);
				int k=Math.abs(s[1]-f[0]);
				if(l>k){
					System.out.println(l);
				}else{
					System.out.println(k);
				}
			}
		}else{
			System.out.println(f[0]-f[1]);
		}
	}
}
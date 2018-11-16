import java.util.Scanner;

public class ccc16j4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] l = s.toCharArray();
		int ini=1;
		for(int i=0;i<l.length;i++){
			for(int j=i+1;j<l.length;j++){
				if(l[i]==l[j]){
					int ip=i;
					int jp=j;
					int count=0;
					boolean is=true;
					while(true){
						if(ip>jp)break;
						if(ip==jp){
							count+=1;
							break;
						}
						if(l[ip]==l[jp]){
							count+=2;
							ip++;
							jp--;
						}else{
							is=false;
							break;
						}
					}
					if(is)if(count>ini)ini=count;
				}
			}
		}
		System.out.println(ini);
	}
}
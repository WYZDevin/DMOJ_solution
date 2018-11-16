import java.util.Scanner;

public class ccc05j5 {
	static char [] words;
	static int p;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String word;
		while(true){
			word=sc.nextLine();
			if(word.equals("X")){
				break;
			}
			if(word.equals("A")){
				System.out.println("YES");
				continue;
			}
			word+=" ";
			words=word.toCharArray();
			boolean check=true;
			int B=0,S=0;
			for(int i =0;i<words.length-1;i++){
				if(words[i]=='A'){
					if(words[i+1]=='N'){
					}else if(words[i+1]=='S'){
						
					}else if(words[i+1]==' '){
						break;
					}else{
						check=false;
						break;
					}
				}else if(words[i]=='S'){
					S++;
					if(words[i+1]=='N'){
					}else if(words[i+1]==' '){
						break;
					}else if(words[i+1]=='S'){
					}else{
						check=false;
						break;
					}
				}else if(words[i]=='B'){
					B++;
					if(words[i+1]=='B'){
					}else if(words[i+1]=='A'){
					}else{
						check=false;
						break;
					}
				}else if(words[i]=='N'){
					if(words[i+1]=='A'){
						
					}else if(words[i+1]=='B'){
						
					}else{
						check=false;
						break;
					}
				}
			}
			if(B!=S)System.out.println("NO");
			else if(!check)System.out.println("NO");else System.out.println("YES");
		}
	}
}
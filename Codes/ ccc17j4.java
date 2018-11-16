import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class favoriteTime {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int fd1,fd2,fd3;
		int [] cc = new int [4];
		int a = Integer.parseInt(br.readLine());
		int time=1200;
		int count=0;
		double dt=a%(12*60);
		String [] c= new String[4];
		for(int i = 1;i<=dt;i++){
			cc[0]=0;
			time++;
			c=Integer.toString(time).split("");
			if(c.length==3){
				cc[3]=Integer.parseInt(c[2]);
				cc[2]=Integer.parseInt(c[1]);
				cc[1]=Integer.parseInt(c[0]);
			}else{
				cc[3]=Integer.parseInt(c[3]);
				cc[2]=Integer.parseInt(c[2]);
				cc[1]=Integer.parseInt(c[1]);
				cc[0]=Integer.parseInt(c[0]);
			}
				if(cc[2]>=6){
					cc[2]-=6;
					cc[1]++;
					if(cc[1]>9){
						cc[1]-=10;
						cc[0]++;
						
					}
				}
				if(cc[0]==1&&cc[1]>2){
					cc[0]=0;
					cc[1]-=2;
				}
				fd1=cc[0]-cc[1];
				fd2=cc[1]-cc[2];
				fd3=cc[2]-cc[3];
			if(cc[0]==0){
				if(fd2==fd3){
					count++;
				}
			}else{
				if(fd2==fd3&&fd2==fd1){
					count++;
				}
			}
			time=cc[0]*1000+cc[1]*100+cc[2]*10+cc[3];	
		}
		double k=(int)(a-dt)/12/60;
		k=count+31*k;
		Double l = k;
		
		System.out.println(l.intValue());
	}
}
import java.util.Scanner;

public class ccc16j4 {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int speed =1;
		int fd =120;
		String [] t = sc.nextLine().split(":");
		int ho = Integer.parseInt(t[0]);
		int min = Integer.parseInt(t[1]);
		double count = 0;
		while(count!=120){
			if(ho>=7 &&ho<10){
				count+=0.5;
			}else if(ho>=15 && ho<19){
				count+=0.5;
			}else {
				count++;
			}
			min++;
			if(min==60){
				min=0;
				ho++;
			}
			if(ho==24){
				ho=0;
			}
		}
		String hoo =Integer.toString(ho);
		String minm = Integer.toString(min);
		if(hoo.length()==1)hoo="0"+hoo;
		if(minm.length()==1)minm="0"+minm;
		System.out.println(hoo+":"+minm);
	}
}
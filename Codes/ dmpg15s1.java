import java.util.Scanner;

public class dmpg15s1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cars= sc.nextInt();
		int [] list = new int [5];
		for(int x=0;x<5;x++){list[x]=sc.nextInt();}
		int count=0;
		count+=(list[0]/4);
		if(list[0]%4!=0){count++;}
		count+=(list[1]/5);
		if(list[1]%5!=0){count++;}
		count+=(list[2]/4);
		if(list[2]%4!=0){count++;}
		count+=(list[3]/3);
		if(list[3]%3!=0){count++;}
		count+=(list[4]/6);
		if(list[4]%6!=0){count++;}
		if(count>=cars)System.out.println(0);
		else System.out.println(cars-count);
	}
}
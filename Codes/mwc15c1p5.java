import java.util.Scanner;

public class test {
    static int pow(int b, int n,int mod){
        if(n==1)return b%mod;
        int t=pow(b,n/2,mod);
        if(n%2==1)return (t*t)%mod*b;
        else return t*t%mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0;
        String s1=sc.nextLine();
        for(int i=0;i<s1.length();i++){
            int num = (Character.toLowerCase(s1.charAt(i))-'a'+1)%10;
            sum+=pow(num,i+1,10);
        }
        sum%=10;
        int sum2=0;
        s1=sc.nextLine();
        for(int i=0;i<s1.length();i++){
            int num = (Character.toLowerCase(s1.charAt(i))-'a'+1)%10;
            sum2+=pow(num,i+1,10);
        }
        sum2%=10;
        if(sum==0)sum=10;
        if(sum2==0)sum2=10;
        System.out.println(sum+sum2);
    }
}
import java.util.*;
public class test {
    public static void main(String [] args){
        Scanner sc  = new Scanner(System.in);
        int h =sc.nextInt(),m=sc.nextInt(),s=sc.nextInt();
        m+=(s/60);
        h+=(m/60);
        s%=60;
        m%=60;
        h%=12;
        int sth = 12 ,stm = 60, sts = 60;
        if(s>0)stm=59;
        if(m!=0)sth=11;
        if((sth-h)%12==0)System.out.printf("00:");
        else if ((sth-h)%12<10)System.out.printf("0%d:",(sth-h)%12);
        else System.out.printf("%d:",(sth-h)%12);
        if((stm-m)%60==0)System.out.printf("00:");
        else if((stm-m)%60<10)System.out.printf("0%d:",(stm-m)%60);
        else System.out.printf("%d:",(stm-m)%60);
        if((sts-s)%60==0)System.out.printf("00");
        else if((sts-s)%60<10)System.out.printf("0%d",(sts-s)%60);
        else System.out.printf("%d",(sts-s)%60);
    }
}
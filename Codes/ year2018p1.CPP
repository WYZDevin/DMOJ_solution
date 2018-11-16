#include <bits/stdc++.h>
using namespace std;
int main(){
    int h,m,s;
    cin>>h>>m>>s;
    m+=(s/60);
    s%=60;
    h+=(m/60);
    m%=60;
    h%=12;
    int sth = 12 ,stm = 60, sts = 60;
    if(s>0)stm=59;
    if(m!=0)sth=11;
    if((sth-h)%12==0)printf("00:");
    else if ((sth-h)%12<10)printf("0%d:",(sth-h)%12);
    else printf("%d:",(sth-h)%12);
    if((stm-m)%60==0)printf("00:");
    else if((stm-m)%60<10)printf("0%d:",(stm-m)%60);
    else printf("%d:",(stm-m)%60);
    if((sts-s)%60==0)printf("00");
    else if((sts-s)%60<10)printf("0%d",(sts-s)%60);
    else printf("%d",(sts-s)%60);
}
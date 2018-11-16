#include <bits/stdc++.h>

using namespace std;
const int MAXN = 100003;

long long bit [MAXN],f[MAXN];
int l [MAXN];
int N,M;

int lowbit(int i){
    return i&(-i);
}

void add(int i,long long ar[MAXN],int y){
    for(;i<=MAXN;i+=lowbit(i)){
        ar[i]+=y;
    }
}

long long sum(int i,long long ar[MAXN]){
    long long sum=0;
    for(;i>0;i-=lowbit(i)){
        sum+=ar[i];
    }
    return sum;
}
int main(){
    scanf("%d %d",&N,&M);
    for(int i=1,x;i<=N;i++){
        scanf("%d", &x);
        add(i,bit,x);
        add(x, f,1);
        l[i]=x;
    }
    char in[2];
    for(int i=0;i<M;i++){
        scanf("%s",in);
        if(in[0]=='C'){
            int x,y;
            scanf("%d %d",&x,&y);
            int v = l[x];
            add(x,bit,y-v);
            add(y,f,1);
            add(v,f,-1);
            l[x]=y;
        }else if(in[0]=='Q'){
            int x;
            scanf("%d",&x);
            printf("%lld\n",sum(x,f));
        }else{
            int x,y;
            scanf("%d %d",&x,&y);
            printf("%lld\n",sum(y,bit)-sum(x-1,bit));
        }
    }
    return 0;
}
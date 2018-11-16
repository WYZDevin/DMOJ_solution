#include <bits/stdc++.h>
#define MAX 0x3f3f3f
using namespace std;
int mins=MAX,N,f[7],w[7];
bool vist[7];
int move(int floor,int stre, int visted,int s){
    if(visted==N && stre<mins){
        mins=stre;
        return 0;
    }
    for(int i=0;i<7;i++){
        if(f[i]==-1)break;
        if(!vist[i]){
            int news= stre+(abs(floor-f[i])+1)*s;
            vist[i]=true;
            move(f[i],news,visted+1,s-w[i]);
            vist[i]=false;
        }
    }
    return 0;
}
int main()
{
    memset(f,-1, sizeof(f));
    memset(w,-1, sizeof(w));
    scanf("%d",&N);
    int s=0;
    for(int i=0;i<N;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        f[i]=a;
        w[i]=b;
        s+=b;
    }
    int x=move(101,0,0,s);
    printf("%d",mins);
}
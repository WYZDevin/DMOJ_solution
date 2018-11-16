#include <bits/stdc++.h>
#define ll long long
using namespace std;
//variables
const int MAXN=252;
int N,Q;
ll cub[MAXN][MAXN][MAXN];
ll ans=0;
//3d bit from https://github.com/jimgao1/competitive-programming/blob/master/Algorithms/bit3d.cpp Jimgao's Git
int lowbit(int i){
    return i&(-i);
}
void update(int x,int y,int z,int v){
    int yi=y,zi=z;
    while(x<=N){
        y=yi;
        while(y<=N){
            z=zi;
            while(z<=N){
                cub[x][y][z]+=v;
                z+=lowbit(z);
            }
            y+=lowbit(y);
        }
        x+=lowbit(x);
    }
}
ll query(int x,int y,int z){
    ll sum=0;
    int yi=y,zi=z;
    while(x>0){
        y=yi;
        while(y>0){
            z=zi;
            while(z>0){
                sum+=cub[x][y][z];
                z-=lowbit(z);
            }
            y-=lowbit(y);
        }
        x-=lowbit(x);
    }
    return sum;
}
ll total(int x1,int y1,int z1,int x2,int y2,int z2){
    x1--;y1--;z1--;
    return query(x2, y2, z2) - query(x1, y2, z2) - query(x2, y1, z2) - query(x2, y2, z1)
           + query(x1, y1, z2) + query(x1, y2, z1) + query(x2, y1, z1)
           - query(x1, y1, z1);
}
//end bit
int main()
{
    cin.sync_with_stdio(0);cin.tie(0);
    cin>>N>>Q;
    for(int qq=0;qq<Q;qq++){
        string s;cin>>s;
        if(s=="C"){
            int a,b,c,d;
            cin>>a>>b>>c>>d;
            update(a,b,c,d-total(a,b,c,a,b,c));
        }else{
            int a,b,c,d,e,f;
            cin>>a>>b>>c>>d>>e>>f;
            ans+=total(a,b,c,d,e,f);
        }
    }
    cout<<ans;
}
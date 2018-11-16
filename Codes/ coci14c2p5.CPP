#include <bits/stdc++.h>
#define ld long double
#define MAXN 750
#define shabi 0x3f3f3f3f
using namespace std;
struct edge{
    int src,tar;
    ld t;
};
int h[MAXN][MAXN],g[MAXN][MAXN],cnt[MAXN][MAXN],N,sb=0;
int xm[]={1,0},ym[]={0,1},sz[MAXN*MAXN],osz[MAXN*MAXN],ods[MAXN*MAXN];
ld mark[MAXN*MAXN];
ld flag;
ld cal(int a,int b,int c,int d){
    if(a==c && b==d)return shabi;
    if(a==c)return 0;
    if(a!=c && b==d)return -1;
    return ((ld)(a-c)/(ld)(d-b));
}
vector<edge>caonima;
unordered_map<ld,vector<edge>>nmsl;
int ds[MAXN*MAXN],ans=0;
void buildSet(){
    for(int i=0;i<MAXN*MAXN;i++) {
        ds[i] = i;
        sz[i]=1;
    }
}
int root(int x) {
    if(mark[x]!=flag){
        mark[x]=flag;
        sz[x]=osz[x],ds[x]=ods[x];
    }
    return ds[x] == x ? x : (ds[x] = root(ds[x]));
}
bool sameSet(int a,int b){
    return root(a)==root(b);
}
void combine(int a,int b){
    if(sameSet(a,b))
        return;
    int ra = root(a), rb=root(b);
    if(sz[ra]>sz[rb]){
        sz[ra]+=sz[rb];
        ds[rb]=ra;
        ans=max(ans,sz[ra]);
    }else{
        sz[rb]+=sz[ra];
        ds[ra]=rb;
        ans=max(ans,sz[rb]);
    }
}
int main(){
    scanf("%d",&N);
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
            scanf("%d",&h[i][j]);
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++) {
            scanf("%d", &g[i][j]);
            cnt[i][j] = sb++;
        }
    for(int i=0;i<N;i++) {
        for (int j = 0; j < N; j++) {
            for(int k=0;k<2;k++){
                int src = cnt[i][j],tar=cnt[i+xm[k]][j+ym[k]];
                ld t = cal(h[i][j],g[i][j],h[i+xm[k]][j+ym[k]],g[i+xm[k]][j+ym[k]]);
                if(t<0)continue;
                if(t==shabi)caonima.push_back({src,tar,t});
                else nmsl[t].push_back({src,tar,t});
            }
        }
    }
    flag = -1;
    int fa=0;
    buildSet();
    for(int i=0;i<MAXN*MAXN;i++)
        mark[i]=-1;
    for(auto i :caonima){
        int src = i.src, tar = i.tar;
        combine(src,tar);
    }
    for(int i=0;i<MAXN*MAXN;i++){
        osz[i]=sz[i];
        ods[i]=ds[i];
    }
    for(auto i : nmsl){
        flag = i.first;
        for(auto j : i.second){
            int src=j.src,tar = j.tar;
            combine(src,tar);
        }
        fa=max(fa,ans);
    }
    cout<<fa<<"\n";
}
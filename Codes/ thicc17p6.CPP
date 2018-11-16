#include <bits/stdc++.h>
#define pii pair<int,int>
#define MAXN 200003
using namespace std;
int N,M,maxx[MAXN],smaxx[MAXN],idx[MAXN],dp[MAXN],pl=0;
vector<pii> adj[MAXN];
bool vis[MAXN];
void dfs(int cur){
    vis[cur]=true;
    for(pii i:adj[cur]){
        int n = i.first,d=i.second;
        if(vis[n])continue;
        dfs(n);
        if(maxx[n]+d>maxx[cur]){
            smaxx[cur]=maxx[cur];
            maxx[cur]=maxx[n]+d;
            idx[cur]=n;
        }else if(maxx[n]+d > smaxx[cur]){
            smaxx[cur]=maxx[n]+d;
        }
    }
    vis[cur]=false;
}
void dpdfs(int cur){
    vis[cur]=true;
    for(pii i:adj[cur]){
        int n=i.first,d=i.second;
        if(vis[n])continue;
        if(n==idx[cur]){
            dp[n]=max(dp[cur],smaxx[cur])+d;
        }else{
            dp[n]=max(dp[cur],maxx[cur])+d;
        }
        dpdfs(n);
    }
    dp[cur]=max(dp[cur],maxx[cur]);
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i=0;i<N-1;i++){
        int a,b,c;cin>>a>>b>>c;
        adj[a].push_back({b,c});
        adj[b].push_back({a,c});
        pl+=(c+c);
    }
    dfs(1);
//    for(int i=1;i<=N;i++)
//        printf("%d\n",maxx[i]);
    memset(vis,0,sizeof vis);
    dpdfs(1);
    for(int i=1;i<=N;i++){
        if(adj[i].size()==M){
            printf("%d %d\n",i,pl-dp[i]);
        }
    }

}
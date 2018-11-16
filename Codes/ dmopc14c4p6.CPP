#include <bits/stdc++.h>
#define MAXN 500003
using namespace std;
int N,M,maxx[MAXN],smaxx[MAXN],idx[MAXN],dp[MAXN],pl=0;
vector<int> adj[MAXN];
bool vis[MAXN];
void dfs(int cur){
    vis[cur]=true;
    for(auto i:adj[cur]){
        int n = i;
        if(vis[n])continue;
        dfs(n);
        if(maxx[n]+1>maxx[cur]){
            smaxx[cur]=maxx[cur];
            maxx[cur]=maxx[n]+1;
            idx[cur]=n;
        }else if(maxx[n]+1 > smaxx[cur]){
            smaxx[cur]=maxx[n]+1;
        }
    }
    vis[cur]=false;
}
void dpdfs(int cur){
    vis[cur]=true;
    for(auto i:adj[cur]){
        int n=i;
        if(vis[n])continue;
        if(n==idx[cur]){
            dp[n]=max(dp[cur],smaxx[cur])+1;
        }else{
            dp[n]=max(dp[cur],maxx[cur])+1;
        }
        dpdfs(n);
    }
    dp[cur]=max(dp[cur],maxx[cur]);
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0;i<N-1;i++){
        int a,b,c;cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    memset(dp,0,sizeof dp);
    dfs(1);
//    for(int i=1;i<=N;i++)
//        printf("%d\n",maxx[i]);
    memset(vis,0,sizeof vis);
    dpdfs(1);
    for(int i=1;i<=N;i++){
        printf("%d\n",dp[i]+1);
    }

}
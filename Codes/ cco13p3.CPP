#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define MAXN 400020
int N;
bool vis[MAXN];
vector<ll> adj[MAXN];
ll diameter=0,ans=0,dis[MAXN],ndis[MAXN];
void dfs(int cur){
    if(vis[cur])return;
    vis[cur]=true;
    ndis[cur]=1;
    for(ll i : adj[cur]){
        if(vis[i])continue;
        dfs(i);
        if(dis[i]+dis[cur]+1>diameter){
            diameter=dis[i]+dis[cur]+1;
            ans = ndis[cur]*ndis[i];
        }else if(dis[i]+dis[cur]+1==diameter){
            ans+=ndis[cur]*ndis[i];
        }
        if(dis[i]+1>dis[cur]){
            dis[cur]=dis[i]+1;
            ndis[cur]=ndis[i];
        }else if(dis[cur] == dis[i]+1){
            ndis[cur] += ndis[i];
        }
    }
    vis[cur]=false;
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0;i<N-1;i++){
        ll a,b;cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    dfs(1);
    printf("%lld %lld \n",diameter+1,ans);
}
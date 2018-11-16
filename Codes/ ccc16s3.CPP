#include <bits/stdc++.h>
using namespace std;
#define MAXN 100100
vector<int> adj[MAXN];
int dis[MAXN],N,M,sz=0;
bool pho[MAXN],path[MAXN];
void dfs(int cur,int last){
    for(int i:adj[cur]){
        if(i==last)continue;
        dfs(i,cur);
        if(path[i]) {
            path[cur] = true;
            sz++;
        }
    }
}
int dist(int cur,int last){
    for(int i:adj[cur]){
        if(i==last || !path[i])continue;
        dis[i]=dis[cur]+1;
        dist(i,cur);
    }
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    int p=0;
    for(int i=0;i<M;i++){
     int a;cin>>a;path[a]=true;p=a;
    }
    for(int i=0;i<N-1;i++){
        int a,b;
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    dfs(p,-1);
    dis[p]=0;
    dist(p,-1);
    int d=p;
    for(int i=0;i<N-1;i++){
        if(dis[i]>dis[d]){
            d=i;
        }
    }
    memset(dis ,0 , sizeof dis);
    int dd=d;
    dist(d,-1);
    for(int i=0;i<N;i++){
        if(dis[i]>dis[dd]){
            dd=i;
        }
    }
    printf("%d\n",sz*2-dis[dd]);
}
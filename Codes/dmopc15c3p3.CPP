#include <bits/stdc++.h>
#define MAXN 100
using namespace std;
struct node{
};
int dis[MAXN],vis[MAXN];
int N,M,f=0;
vector<int> adj[MAXN];
void dfs(int cur,int pre){
    for(int i:adj[cur]){
        if(vis[i]){
            if(i!=pre){
                int dist = dis[cur] - dis[i] + 1;
                if(dist>=6){
                    f=1;
                    return;
                }
            }
        }else{
            dis[i]=min(dis[cur]+1,dis[i]);
            vis[i]=true;
            dfs(i,cur);
            if(f) return;
            vis[i]=false;
        }
    }
}
int main(){
    cin>>N>>M;
    for(int i=0,a,b;i<M;i++){
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
memset(dis,0x3f3f3f,sizeof dis);
    dis[1]=1;
    vis[1]=true;
    dfs(1,-1);
//    for(int i=1;i<=N;i++){
//        printf("%d\n",dis[i]);
//    }
    if(f)printf("YES");
    else printf("NO");
}
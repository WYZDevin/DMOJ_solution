#include <bits/stdc++.h>
#define MAXN 100003
#define INF 0x3f3f3f
using namespace std;
int dis[MAXN],dis2[MAXN];
int N,M;
bool vis[MAXN];
vector<pair<int,int>> adj[MAXN];
void spfa(int st,int* dist){
    memset(vis,0,sizeof vis);
    queue<int>q;
    q.push(st);
    dist[st]=0;
    while(!q.empty()){
        int curp=q.front();q.pop();
        vis[curp]=false;
        for(pair<int,int> i:adj[curp]){
            int np=i.first,nd=i.second;
            if(dist[np]>dist[curp]+nd){
                dist[np]=dist[curp]+nd;
                if(!vis[np]){
                    vis[np]=true;
                    q.push(np);
                }
            }
        }
    }
}
int main(){
	cin.sync_with_stdio(0);cin.tie(0);
    cin>>N>>M;
    while(M--){
        int a,b,c;
        cin>>a>>b>>c;
        adj[a].push_back({b,c});
        adj[b].push_back({a,c});
    }
    memset(dis,0x3f,sizeof dis);
    memset(dis2,0x3f,sizeof dis2);
    spfa(0,dis);
    spfa(N-1,dis2);
    int ans=0;
    for(int i=0;i<N;i++){
//        printf("dis1 %d dis2 %d\n",dis[i],dis2[i]);
        ans=max(ans,dis[i]+dis2[i]);
    }
    printf("%d\n",ans);
}
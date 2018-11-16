#include <bits/stdc++.h>
using namespace std;
int disb[103],disg[103],N,M,W;
bool vis[103];
vector<int> adj [103];
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    memset(disb,0x3f3f3f,sizeof disb);
    for(int i=0;i<M;i++){
        int a,b;cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    queue <int> q;
    cin>>W;
    for(int i=0;i<W;i++){
        int a;cin>>a;
        q.push(a);
        disb[a]=0;
    }
    while(!q.empty()){
        int curp=q.front();q.pop();
        for(int i:adj[curp]){
           if(!vis[i]){
               q.push(i);vis[i]=true;
               disb[i]=min(disb[i],disb[curp]+4);
           }
        }
    }
    queue<int>q2;
    q2.push(1);
    memset(vis, 0 ,sizeof vis);
    while(!q2.empty()){
        int curp=q2.front();q2.pop();
        for(int i:adj[curp]){
            if(!vis[i] && disb[i]>disg[curp]+1){
                q2.push(i);
                disg[i]=disg[curp]+1;
                vis[i]=true;
            }
        }
    }
    if(disg[N]==0)printf("sacrifice bobhob314");
    else printf("%d\n",disg[N]);
}
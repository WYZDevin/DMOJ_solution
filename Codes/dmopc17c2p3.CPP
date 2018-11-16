#include <bits/stdc++.h>
#define pii pair<int,int>
#define MAXN 200010
using namespace std;
int N,R,S,E;
vector<int>adj[MAXN];
vector<int>rabit,road;
int pre[MAXN],dis[MAXN];
bool vis[MAXN],rb[MAXN];
void path(){
    for(int i=0;i<MAXN;i++)
        pre[i]=i;
    vis[S]=true;
    queue<pii>q;
    q.push({S,S});
    while(!q.empty()){
        int cur=q.front().first,last=q.front().second;q.pop();
        pre[cur]=last;
        for(int i:adj[cur]){
            if(vis[i])continue;
            q.push({i,cur});
            vis[i]=true;
        }
    }
}
int dist(int s){
    memset(dis,0,sizeof dis);
    memset(vis,0,sizeof vis);
    queue<pii> q;
    q.push({s,0});
    vis[s]=true;
    int ans=0x3f3f3f3f;
    while(!q.empty()){
        int cur=q.front().first,d=q.front().second;
        dis[cur]=d;
        q.pop();
        if(rb[cur])ans=min(ans,dis[cur]);
        for(int i:adj[cur]){
            if(vis[i])continue;
            vis[i]=true;
            q.push({i,d+1});
        }
    }
    return ans;
}
void go(){
    int p=E;
    while(pre[p]!=p){
        road.push_back(pre[p]);
        p=pre[p];
    }
}
int main()
{
    cin>>N>>R;
    for(int i=0;i<N-1;i++){
        int a,b;cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    for(int i=0;i<R;i++) {
        int a;
        cin >> a;
        rabit.push_back(a);
        rb[a]=true;
    }
    cin>>S>>E;
    path();
    go();
//    for(int i=1;i<=N;i++)
//        cout<<pre[i]<<endl;
//    cout<<endl;
//   for(int i:road)cout<<i<<endl;
    int ans=0x3f3f3f3f;
    for(int i:road){
        ans=min(ans,dist(i));
    }
    ans=min(ans,dist(S));
    ans=min(ans,dist(E));
    cout<<ans<<endl;
}
#include <bits/stdc++.h>
using namespace std;
vector<int>adj[100];
vector<pair<int,int>> edge;
int vis[100];
int N,M;
int main() {
    cin>>N>>M;
    for(int i=0;i<M;i++){
        int a,b;cin>>a>>b;
        adj[a].push_back(b);
        edge.push_back(make_pair(a,b));
    }
    for(auto i:edge){
        memset(vis,0,sizeof vis);
        vis[1]=1;
        int src = i.first, tar = i.second;
        queue<int>q;
        q.push(1);
        while(!q.empty()){
            int cur = q.front();
            q.pop();
            vis[cur]=true;
            for(int j:adj[cur]){
                if(cur == src && j == tar)continue;
                if(vis[j])continue;
                q.push(j);
            }
        }
        cout<< (vis[N]?"YES":"NO")<<endl;
    }
}
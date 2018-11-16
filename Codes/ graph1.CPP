#include <bits/stdc++.h>
using namespace std;

int N,M,st,ed;
vector<int>adj[10001];
bool vist[10001];
void dfs(int cur){
    vist[cur]=true;
    for(int i:adj[cur]){
        if(vist[i])continue;
        dfs(i);
    }
}
int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i=0;i<M;i++){
        int a,b;
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    cin>>st>>ed;
    dfs(st);
    printf("%d",vist[ed]?1:0);
}
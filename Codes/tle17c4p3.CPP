#include <bits/stdc++.h>
#define MAXN 300100
using namespace std;
vector<int>adj[MAXN];
int val[MAXN],N,M,D,day[MAXN],vis[MAXN];
void dfs(int cur){
    vis[cur]=1;
    if(adj[cur].empty()){
        val[cur]=day[cur];
        return;
    }
    for(int i:adj[cur]){
        if(vis[i])continue;
        dfs(i);
        val[cur]=max(val[cur],val[i]);
    }
    val[cur]=min(day[cur],val[cur]);
}
int main(){
    scanf("%d %d %d",&N,&M,&D);
    for(int ii = 0;ii<M;ii++){
        int a,b;scanf("%d %d",&a,&b);
        for(int j=0;j<b;j++){
            int c;scanf("%d",&c);
            adj[a].push_back(c);
        }
    }
    memset(day,0x3f3f3f3f,sizeof day);
    for(int i=1;i<=D;i++){
        int a;scanf("%d",&a);
        day[a]=min(day[a],i);
    }
    dfs(1);
    if(val[1]==0x3f3f3f3f)val[1]=-1;
    printf("%d\n",val[1]);
}
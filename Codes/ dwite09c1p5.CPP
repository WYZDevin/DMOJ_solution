#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAXN = 400009;
bool out[103];
int N,vis[103],maxx=0;
void dfs(int cur,int lv,vector<int>adj[103]){
    for(int i:adj[cur]){
            if(vis[i]==0){
                vis[i]=1;
                dfs(i,lv+1,adj);
                vis[i]=2;
            }else if(vis[i]==1){
                if(lv>maxx)
                maxx=lv;
            }
    }
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for(int gg = 0;gg<5;gg++) {
        maxx=0;
        vector<int> adj[103];
        cin >> N;
        for (int i = 0; i < N; i++) {
            int a, b;
            cin >> a >> b;
            adj[a].push_back(b);
        }
        memset(vis,0,sizeof vis);
        dfs(1,0,adj);
        printf("%d\n",maxx);
    }
}
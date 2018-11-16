#include<bits/stdc++.h>
#define MAXN 10010
#define ll long long
#define MOD 1000000000LL
using namespace std;
int N,M;
vector<int> adj [MAXN],order;
int state[MAXN];
ll dp[MAXN];
bool inf=false,use[MAXN],vis[MAXN];
void dfs2(int cur){
    if(vis[cur])return;
    vis[cur]=true;
    if(cur==2){
        use[cur]=true;
        return;
    }
    for(int i:adj[cur]){
        dfs2(i);
        if(use[i]){
            use[cur]=true;
        }
    }
}
void dfs(int cur){
    if(inf)return;
    for(int i : adj[cur]){
        if(!use[i])continue;
        if(!state[i]){
            state[i]=1;
            dfs(i);
            state[i]=2;
            if(inf)return;
        }else if(state[i]==1){
            inf=true;
            printf("xxx %d %d\n",cur,i);
            return;
        }
    }
    order.push_back(cur);
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i=0;i<M;i++){
        int a,b;
        cin>>a>>b;
        adj[a].push_back(b);
    }
    dfs2(1);
    dp[1]=1;
    dfs(1);
    if(inf){
        printf("inf");
        return 0;
    }
    reverse(order.begin(),order.end());
    bool flag=false;
    for(int i:order){
        for(int j:adj[i]){
            dp[j]+=dp[i];
            if(dp[j]>=MOD){
                flag=true;
                dp[j]%=MOD;
            }
        }
    }
    if(flag){
        printf("%09lld",dp[2]%MOD);
    }else{
        printf("%lld",dp[2]);
    }
}
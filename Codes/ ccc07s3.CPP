#include <bits/stdc++.h>
#define pii pair<int,int>
using namespace std;
const int MAXN=10001;
int N;
bool vis[MAXN];
vector<int>adj[MAXN];
int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0;i<N;i++){
        int a,b;cin>>a>>b;
        adj[a].push_back(b);
    }
    while(true){
        int a,b;cin>>a>>b;
        if(a==0 && b==0)break;
        queue<pii>q;
        q.push({a,-1});
        bool flag=false;
        memset(vis,0,sizeof(vis));
        vis[a]=true;
        while(!q.empty()){
            int curp=q.front().first,curd=q.front().second;q.pop();
            if(curp==b){
                printf("Yes %d\n",curd);flag=true;
                break;
            }
            for(int i:adj[curp]){
                if(!vis[i]){
                    q.push({i,curd+1});
                    vis[i]=true;
                }
            }
        }
        if(!flag)printf("No\n");
    }

}
#include <bits/stdc++.h>
#define INF 0x3f3f3f3f
#define pii pair<int,int>
using namespace std;
struct edge{
    int tar,dis,tik;
};
int N,M,K,A,B;
vector<edge> adj[2010];
int mins[2010][210];
bool in[2010][210];
void spfa() {
    memset(mins,INF,sizeof mins);
    queue<pii> q;
    q.push({A,0});
    mins[A][0]=0;
    in[A][0]=true;
    while(!q.empty()){
        int cp=q.front().first;
        int cc=q.front().second;
        in[cp][cc]=false;
        q.pop();
        for(edge i:adj[cp]){
            int np=i.tar;
            int nd=i.dis;
            int nc=i.tik;
            if(nc+cc>K)continue;
            if(mins[np][nc+cc]>mins[cp][cc]+nd){
                mins[np][nc+cc]=mins[cp][cc]+nd;
                    q.push({np,nc+cc});

                }
            }
        }
    }

int main()
{
    scanf("%d %d %d",&K,&N,&M);
    for(int i=0,a,b,c,d;i<M;i++){
        scanf("%d %d %d %d",&a,&b,&c,&d);
        adj[a].push_back({b,c,d});
        adj[b].push_back({a,c,d});
    }
    scanf("%d %d",&A,&B);
    spfa();
    int max=INF;
    for(int i=0;i<K;i++){
        max=min(max,mins[B][i]);
    }

    if(max==INF)max=-1;
    printf("%d",max);
}
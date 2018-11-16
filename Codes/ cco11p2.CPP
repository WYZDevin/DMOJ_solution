#include <bits/stdc++.h>
#define INF 0x3f3f3f3f
#define pii pair<int,int>
using namespace std;
struct edge{
    int tar,dis,status;
};
int N,M,S;
int mins[1610][3610];
bool in [1610][3610];
vector<edge> adj[1610];
void spfa() {
    memset(mins, 0x3f, sizeof(mins));
    mins[0][0] = 0;
    in[0][0] = true;
    queue<pii > q;
    q.push({0, 0});
    while (!q.empty()) {
        int cp = q.front().first;
        int cc = q.front().second;
        q.pop();
        in[cp][cc] = false;
        for (edge i:adj[cp]) {
            int np = i.tar;
            int nd = i.dis;
            int nc = i.status;
            if (cc + nc > S)continue;
            if (mins[np][cc + nc] > mins[cp][cc] + nd) {
                mins[np][cc + nc] = mins[cp][cc] + nd;
                if (!in[np][cc + nc]) {
                    q.push({np, cc + nc});
                    in[np][cc + nc] = true;
                }
            }
        }
    }
}
    int main()
    {
        scanf("%d",&S);
        scanf("%d %d",&N,&M);
        for(int i=0,a,b,c,d;i<M;i++){
            scanf("%d %d %d %d",&a,&b,&c,&d);
            adj[a].push_back({b,c,d*c});
            adj[b].push_back({a,c,d*c});
        }
        spfa();
        int max=INF;
        for(int i:mins[N-1])
            max=min(max,i);
        if(max==INF)printf("-1");
        else printf("%d",max);
    }
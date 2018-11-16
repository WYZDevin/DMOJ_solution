#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define pb push_back
#define mp make_pair
char _;
using namespace std;

typedef pair<int,int> pii;

int N, T, K, D, dist[5001], graph[5001][5001];
bool vis[5001];
int main()
{
    memset(dist,0x3f3f3f3f,sizeof(dist));
    memset(graph,0x3f3f3f3f,sizeof(graph));
    scan(N);scan(T);
    int a, b, c;
    for (int i = 0; i < T; ++i)
    {
        scan(a);scan(b);scan(c);
        graph[a][b] = graph[b][a] = c;
    }
    scan(K);
    for (int i = 0; i < K; ++i)
    {
        scan(a);scan(b);
        dist[a] = b;
    }
    for (int i = 0; i < N; ++i)
    {
        int u = 0;
        for (int j = 1; j <= N; ++j)
            if (!vis[j] && dist[j] < dist[u])
                u = j;
        vis[u] = 1;
        for (int j = 1; j <= N; ++j)
            if (dist[u] + graph[u][j] < dist[j])
                dist[j] = dist[u] + graph[u][j];
    }
    scan(D);
    printf("%d\n",dist[D]);
    return 0;
}
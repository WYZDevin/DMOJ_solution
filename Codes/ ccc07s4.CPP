#include <bits/stdc++.h>
#define INF 0x3f3f3f3f
using namespace std;
int N,a,b;
vector<int> adj[100000];
int step[100000];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    scanf("%d",&N);
    while(true){
        scanf("%d %d",&a,&b);
        if(a==0 && b==0)break;
        adj[a].push_back(b);
    }
    step[1]=1;
    for(int i=0;i<=N;i++){
        for(int j=0;j<adj[i].size();j++){
            step[adj[i][j]]+=step[i];
        }
    }
    printf("%d\n",step[N]);
}
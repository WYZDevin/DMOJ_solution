#include <bits/stdc++.h>
#define MAX 0x3f3f3f
using namespace std;
vector<int> adj[2002];
vector<int> adj2[2002];
bool vist[2003];
int main()
{
    int N,M,t;
    scanf("%d %d %d",&N,&M,&t);
    for(int i=0;i<t;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        adj[a].push_back(b);
        adj2[b].push_back(a);
    }
    for(int i=1;i<=N;i++){
        memset(vist,0, sizeof(vist));
        for(int j:adj[i]){
            for(int k:adj2[j]){
                if(!vist[k] && k!=i){
                    vist[k]=true;
                }else if(vist[k]){
                    printf("NO");
                    return 0;
                }
            }
        }
    }
    printf("YES");
}
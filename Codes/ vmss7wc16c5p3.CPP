#include <bits/stdc++.h>
using namespace std;
int N,M,da=0,lg=0;
vector<int>adj[10004];
bool in[10004];
void dfs(int src){
    memset(in,0, sizeof(in));
    stack <pair<int,int>> st;
    st.push({src,0});
    while(!st.empty()){
        int cr=st.top().first,cd=st.top().second;st.pop();
        in[cr]=true;
        if(cd>da){
            da=cd;
            lg=cr;
        }
        for(int i:adj[cr]){
            if(!in[i])
            st.push({i,cd+1});
        }
    }
}
int main()
{
    scanf("%d",&N);
    for(int i=0;i<N-1;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    dfs(1);
    dfs(lg);
    printf("%d",da);
}
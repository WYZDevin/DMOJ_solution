#include <bits/stdc++.h>
using namespace std;
int N,M;
int mins[1005];
vector<pair<int,int>> adj[1005];
void spfa(int sp){
    mins[sp]=0;
    queue<int>q;
    q.push(sp);
    while(!q.empty()){
        int cp=q.front();
        q.pop();
        for(pair<int,int> i:adj[cp]){
            if(mins[i.first]>mins[cp]+i.second){
                mins[i.first]=mins[cp]+i.second;
                q.push(i.first);
            }
        }
    }
}
int main(){
    scanf("%d %d",&N,&M);
    for(int i=0;i<M;i++){
        int a,b,c;
        scanf("%d %d %d",&a,&b,&c);
        adj[a].push_back(make_pair(b,c));
        adj[b].push_back(make_pair(a,c));
    }
    memset(mins,0x3f3f3f3f, sizeof(mins));
    spfa(1);
    for(int i=1;i<=N;i++){
        if(mins[i]==0x3f3f3f3f)mins[i]=-1;
        printf("%d\n",mins[i]);
    }
}
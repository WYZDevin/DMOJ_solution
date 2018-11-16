#include <bits/stdc++.h>
#define pii pair<int,int>
using namespace std;
struct node{
    int src,tar,w;
};
bool comp(node i,node j){
    return i.w>j.w;
}

int N,M;
vector<node> edge;
const int MAXN= 200005;
vector<pii> adj[MAXN];
int ds[MAXN],sz[MAXN],dis[MAXN];
vector<int> tree;

void buildSet(){
    for(int i=0;i<MAXN;i++)
        ds[i]=i,sz[i]=1;
}
int root(int a){
    int rt=a;
    while(rt!=ds[rt])
        rt=ds[rt];
    return rt;
}

bool sameSet(int a,int b){return root(a)==root(b);}

void combine(int a,int b){
    int ra=root(a),rb=root(b);
    if(ra==rb)return;
    if(sz[ra]>sz[rb]){
        ds[rb]=ra;
        sz[ra]+=sz[rb];
    }else{
        ds[ra]=rb;
        sz[rb]+=sz[ra];
    }
}
void dfs(int cur,int la){
    for(pair<int,int> i:adj[cur]){
        if(i.first==la)continue;
        dis[i.first]=min(dis[cur],i.second);
        dfs(i.first,cur);
    }
}
int main(){
    buildSet();
    scanf("%d %d",&N,&M);
    for(int i=0;i<M;i++) {
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);
            edge.push_back({a, b, c});
    }
    sort(edge.begin(),edge.end(),comp);
    for(int i=0;i<edge.size();i++){
        if(!sameSet(edge[i].src,edge[i].tar)){
            combine(edge[i].src,edge[i].tar);
            adj[edge[i].src].push_back({edge[i].tar, edge[i].w});
            adj[edge[i].tar].push_back({edge[i].src, edge[i].w});
        }
    }
    dis[1]=0x3f3f3f3f;
    dfs(1,-1);
    dis[1]=0;
    for(int i=1;i<=N;i++)
        printf("%d\n",dis[i]);
}
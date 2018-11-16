#include<bits/stdc++.h>
using namespace std;
int N;
struct edge{
    int src, tar, w;
};
bool comp(edge i,edge j){
    return i.w<j.w;
}
const int MAXN= 1000;
int ds[MAXN],sz[MAXN],e[1010],pr[5050];
vector<int>adj[1010][1010];
set<pair<int,int>> edges;
vector<edge>tree;
map<pair<int,int>,int> prr,rooms;
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


int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=1;i<=N;i++){
        int n;cin>>n;
        for(int j=0;j<n;j++){
            cin>>e[j];
        }
        for(int j=0;j<n;j++){
            cin>>pr[j];
        }
        for(int j=0;j<n;j++){
            int e1 = e[j],e2=e[(j+1)%n];
            if(e2<e1)swap(e1,e2);
            adj[e1][e2].push_back(i);
            if(adj[e1][e2].size()==2) {
                edges.erase({e1,e2});
                tree.push_back({adj[e1][e2][0], adj[e1][e2][1], pr[j]});
                adj[e1][e2].clear();
            }else{
                edges.insert({e1,e2});
                prr[{e1,e2}]=pr[j];
                rooms[{e1,e2}]=i;
            }
        }
    }
    int ans1=0;
    sort(tree.begin(),tree.end(),comp);
    buildSet();
//    for(auto i:tree)
//        printf("%d %d %d\n",i.src,i.tar,i.w);
    for(auto i:tree){
        int src = i.src,tar = i.tar;
        if(!sameSet(src,tar)){
            combine(src,tar);
            ans1+=i.w;
        }
    }
    for(auto i : edges){
        tree.push_back({0,rooms[i],prr[i]});
    }
    sort(tree.begin(),tree.end(),comp);
    int ans2=0;
    buildSet();
    for(auto i:tree){
        int src = i.src,tar = i.tar;
        if(!sameSet(src,tar)){
            combine(src,tar);
            ans2+=i.w;
        }
    }
    printf("%d\n",min(ans1,ans2));
}
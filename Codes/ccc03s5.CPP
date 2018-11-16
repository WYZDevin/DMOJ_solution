#include <bits/stdc++.h>
#define pii pair<int,int>
using namespace std;
const int MAXN = 10003;
int ds[MAXN],sz[MAXN],dis[MAXN];
int N,M,D;
struct node{
    int src,tar,w;
};
bool comp(node i,node j){
    return i.w>j.w;
}
vector<node>rd;
vector<pii> adj[MAXN];
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
    cin.sync_with_stdio(0);cin.tie(0);
    cin>>N>>M>>D;
    while(M--){
        int a,b,c;
        cin>>a>>b>>c;
        rd.push_back({a,b,c});
    }
    sort(rd.begin(),rd.end(),comp);
//    for(node i:rd)
//        cout<<i.w<<endl;
    buildSet();
    for(node i:rd){
        if(!sameSet(i.tar,i.src)){
            combine(i.tar,i.src);
            adj[i.tar].push_back({i.src,i.w});
            adj[i.src].push_back({i.tar,i.w});
        }
    }
    queue<pii> q;
    int ans=0x3f3f3f3f;
    q.push({1,0x3f3f3f3f});
    while(!q.empty()){
        int curp=q.front().first,curd=q.front().second;
        q.pop();
        dis[curp]=max(dis[curp],curd);
        for(pii i:adj[curp]){
            if(dis[i.first]<min(dis[curp],i.second)){
                q.push({i.first,min(dis[curp],i.second)});
            }
        }
    }
    while(D--){
        int a;cin>>a;
        ans=min(ans,dis[a]);
    }
    printf("%d\n",ans);
}
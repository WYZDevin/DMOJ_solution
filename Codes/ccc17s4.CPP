#include <bits/stdc++.h>
using namespace std;
struct node{
    int src,tar,w,s;
};
bool comp(node i,node j){
    if(i.w!=j.w)
        return i.w<j.w;
    return i.s<j.s;
}

int N,M,D,maxx,ans,ts,cnt;
vector<node> edge;
const int MAXN= 300003;
int ds[MAXN],sz[MAXN];

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
    buildSet();
    cin>>N>>M>>D;
    for(int i=0;i<M;i++){
        cnt++;
        int a,b,c;
        cin>>a>>b>>c;
        if(i<N-1)
            edge.push_back({a,b,c,0});
        else
            edge.push_back({a,b,c,1});
    }
    sort(edge.begin(),edge.end(),comp);
    for(node i : edge){
        if(ts==N-1)break;
        int src=i.src,tar = i.tar;
        if(!sameSet(src,tar)){
            combine(src,tar);
            maxx=i.w;
            if(i.s==1){
                ans++;
            }
        }
    }
    if(D>0){
        buildSet();
        for(node i : edge){
            if(sameSet(i.src,i.tar))continue;
            if(i.w<maxx || (i.w==maxx && i.s == 0) ){
                combine(i.src,i.tar);
            }else if(i.w>maxx && i.w<=D && i.s == 0){
                printf("%d\n",ans-1);
                return 0;
            }
        }
    }
    printf("%d\n",ans);
}
#include <bits/stdc++.h>
#define INF 0x3f3f3f3f
using namespace std;

const int MAXN = 500003;
int N,M;
vector<pair<int,int>> adjl[MAXN];
vector<pair<int,int>> adjl2[MAXN];
vector<int>sp[3];
int mins[MAXN],bmins[MAXN];
queue<int>q;

void spfa(int st){
    bool vist[MAXN];
    q.push(st);
    mins[st]=0;
    while(!q.empty()){
        int cp = q.front();
        vist[cp]=false;
        q.pop();
        for(int i=0;i<adjl[cp].size();i++){
            int np=adjl[cp][i].first;
            int nd=adjl[cp][i].second;
            if(mins[np]>mins[cp]+nd){
                mins[np]=mins[cp]+nd;
                if(!vist[np]){
                    vist[np]=true;
                    q.push(np);
                }
            }
        }
    }
}
void spfaa(int st){
    bmins[st]=0;
    bool vist[MAXN];
    q.push(st);
    while(!q.empty()){
        int cp = q.front();
        vist[cp]=false;
        q.pop();
        for(int i=0;i<adjl2[cp].size();i++){
            int np=adjl2[cp][i].first;
            int nd=adjl2[cp][i].second;
            if(bmins[np]>bmins[cp]+nd){
                bmins[np]=bmins[cp]+nd;
                if(!vist[np]){
                    vist[np]=true;
                    q.push(np);
                }
            }
        }
    }


}
int main() {
    scanf("%d %d",&N,&M);
    for(int i=0,a,b,c;i<M;i++){
        scanf("%d %d %d",&a,&b,&c);
        adjl[a].push_back({b,c});
        adjl2[b].push_back({a,c});
    }
    int k;
    scanf("%d",&k) ;
    for(int i=0,a,b,c;i<k;i++){
        scanf("%d %d %d",&a,&b,&c);
        sp[0].push_back(a);
        sp[1].push_back(b);
        sp[2].push_back(c);
    }
    for(int i=1;i<=N;i++){
        mins[i]=INF;
        bmins[i]=INF;
    }
    mins[1]=0;
    bmins[N]=0;
    spfa(1);
    spfaa(N);
    int ans=mins[N];
    for(int i=0;i<sp[0].size();i++){
        int st=sp[0][i],ed=sp[1][i],wd=sp[2][i];
        ans=min(ans,mins[st]+bmins[ed]+wd);
    }
    if(ans==INF)printf("-1");
    else
        printf("%d",ans);

}
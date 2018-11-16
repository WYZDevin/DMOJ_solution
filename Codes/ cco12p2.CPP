#include <bits/stdc++.h>
#define pii pair<int,int>
#define eg pair<pair <int,int>,int>
#define INF 0x3f3f3f3f
using namespace std;
int N,M;
const int MAXN=20003;
vector<pii> adj[MAXN],adj2[MAXN];
vector<eg> edge;
int mins[MAXN],mins2[MAXN];
bool in [MAXN];
void spfa(vector<pii>list[MAXN],int st,int mini[MAXN]){
    queue<int>q;
    q.push(st);
    mini[st]=0;
    while(!q.empty()){
        int cp=q.front(),cd=mini[cp];q.pop();
        in[cp]=false;
        for(auto i:list[cp]){
            int np=i.first,nd=i.second;
            if(nd+cd<mini[np]){
                mini[np]=nd+cd;
                if(!in[np]){
                    in[np]=true;
                    q.push(np);
                }
            }
        }
    }
}
int main(){
    scanf("%d %d",&N,&M);
    for(int i=0,a,b,c;i<M;i++){
        scanf("%d %d %d",&a,&b,&c);
        adj[a].push_back({b,c});
        adj2[b].push_back({a,c});
        edge.push_back({{a,b},c});
    }
    memset(mins,100, sizeof(mins));
    memset(mins2,100, sizeof(mins2));
    spfa(adj,1,mins);
    spfa(adj2,N,mins2);
    int ans=INF;
    int fdis=mins[N];
    for(auto i:edge){
        int newdis=mins[i.first.first]+i.second+mins2[i.first.second];
        if(newdis<ans && newdis>fdis){
            ans=newdis;
        }
    }
    if(ans==INF)cout<<-1;
    else cout<<ans;
}
#include <bits/stdc++.h>
#define pii pair<int,int>
using namespace std;
int N,M,Q;
set<pii> fav[104];
set<int>own[100005];
int dis[100005];
int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
   cin>>N>>M;
    for(int i=1;i<=N;i++){
        int a;
        cin>>a;
        dis[i]=a;
    }
    for(int i=0;i<M;i++){
        int a,b;
        cin>>a>>b;
        fav[b].insert({dis[a],a});
        own[a].insert(b);
    }
    cin>>Q;
    for(int i=0;i<Q;i++){
        string s;
        int a,b;
        cin>>s;
        if(s=="A"){
            cin>>a>>b;
            fav[b].insert({dis[a],a});
            own[a].insert(b);
        }else if(s=="S"){
            cin>>a>>b;
            if(own[a].count(b)){
                fav[b].erase(fav[b].lower_bound({dis[a],a}));
                own[a].erase(own[a].find(b));
            }
        }else if(s=="E"){
            cin>>a>>b;
            for(int i:own[a]){
                fav[i].erase(fav[i].lower_bound({dis[a],a}));
            }
            own[a].clear();
            dis[a]=b;
        }else if(s=="Q"){
            cin>>a;
            if(fav[a].empty()){
                printf("-1\n");
                continue;
            }
            set<pii>::iterator it=fav[a].begin();
            printf("%d\n",it->second);
        }
    }

}
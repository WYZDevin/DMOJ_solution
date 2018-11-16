#include <bits/stdc++.h>
#define pii pair<double,int>
#define pid pair<int,double>
using namespace std;
pii dis[1004];
vector<pid>adj[1004];
bool vis[1003];
int N,M;
int main(){
    cin.sync_with_stdio(0);cin.tie(0);
    cin>>N>>M;
    for(int i=0,a,b,c,d;i<M;i++){
        cin>>a>>b>>c>>d;
        adj[a].push_back({b,(1.0*c)/(1.0*d)*60});
        adj[b].push_back({a,(1.0*c)/(1.0*d)*60});
//        cout<<(1.0*c)/(1.0*d)*60<<endl;
    }
    for(int i=2;i<=N;i++)
        dis[i]={0x3f3f,0x3f3f};
    dis[1]=(make_pair(0,0));
    queue<int>q;
    q.push(1);
    while(!q.empty()){
        int cur=q.front();q.pop();
        vis[cur]=false;
        for(auto i:adj[cur]){
            int curp=i.first;double curd=i.second;
            if(dis[curp].first>dis[cur].first+curd){
                dis[curp].first=dis[cur].first+curd;
                dis[curp].second=dis[cur].second+1;
                if(!vis[curp]){
                    vis[curp]=true;
                    q.push(curp);
                }
            }else if(dis[curp].second>dis[cur].second+1){
                dis[curp].second=dis[cur].second+1;
                if(!vis[curp]){
                    vis[curp]=true;
                    q.push(curp);
                }
            }
        }
    }
//    for(int i=1;i<N+1;i++)
    printf("%d\n%.0f\n",dis[N].second,(dis[N].first/0.75-dis[N].first));
}
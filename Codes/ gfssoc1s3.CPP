#include <bits/stdc++.h>
#define pii pair<int,int>
#define INF 0x3f3f3f3f
using namespace std;
//variables
string grid[22];
int N,M,T;
int xm[]={1,0,-1,0},ym[]={0,1,0,-1};
int dis[22][22];
bool vist[22][22];
int road[6][6];
bool take[6];
pii st;
vector<pii> hider;
int mins=INF;
//funtion
bool valid(int x,int y){//point check
    if(x>=N || x<0||y>=M||y<0 )return false;
    return true;
}
void bfs(pii src){//BFS
    memset(dis,0x3f,sizeof(dis));
    memset(vist,false,sizeof(vist));
    dis[src.first][src.second]=0;
    queue<pii> q;
    q.push(src);
    while(!q.empty()){
        int x1=q.front().first,y1=q.front().second;
        q.pop();
        vist[x1][y1]=true;
        for(int i=0;i<4;i++){
            int x2=x1+xm[i],y2=y1+ym[i];
            if(!valid(x2,y2))continue;
            if(vist[x2][y2])continue;
            if(grid[x2][y2]=='X')continue;
//            printf("%d %d\n",x2,y2);
            if(dis[x2][y2]>dis[x1][y1]+1){
                dis[x2][y2]=dis[x1][y1]+1;
                q.push({x2,y2});
                vist[x2][y2]=true;
            }
        }
    }
}
//permutation
void per(int stg,int cur,int sum){
    if(stg==T){
        mins=min(mins,sum);
        return;
    }
    for(int i=1;i<=T;i++){
        if(!take[i]){
            take[i]=true;
            per(stg+1,i,sum+road[cur][i]);
            take[i]=false;
        }
    }
}
//main
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M>>T;
    int idx=0;
    for(int i=0;i<N;i++){
        string s;
        cin>>s;
        grid[i]=s;
        for(int j=0;j<M;j++){
            if(s[j]=='H') {
                hider.push_back({i,j});
            }
            idx++;
            if(s[j]=='G')st=make_pair(i,j);
        }
    }
//    for(int i=0;i<T;i++){
//        printf("hider i at %d %d\n",hider[i].first,hider[i].second);
//    }
    bfs(st);
    for(int i=0;i<T;i++){
        road[0][i+1]=dis[hider[i].first][hider[i].second];
    }
    for(int i=0;i<T;i++){
        bfs(hider[i]);
        for(int j=0;j<T;j++){
            road[i+1][j+1]=dis[hider[j].first][hider[j].second];
        }
    }
//    for(int i=0;i<=T;i++) {
//        for (int j = 0; j <=T; j++) {
//            printf("%d ",road[i][j]);
//        }
//        printf("\n");
//    }
    per(0,0,0);
    printf("%d",mins);
}
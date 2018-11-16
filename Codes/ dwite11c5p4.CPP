#include <bits/stdc++.h>

using namespace std;
int dis[13][13],xm[]={1,0,-1,0},ym[]={0,1,0,-1};
bool vis[13][13];
char grid [13][13];
queue<pair<int,int>> q;
int main(){
    for(int jjj =0; jjj<5;jjj++){
        memset(vis,0,sizeof vis);
        memset(dis,-1,sizeof dis);
        for(int i=0;i<10;i++){
            scanf("%s",grid[i]);
            for(int j=0;j<10;j++){
                if(grid[i][j]=='F') {
                    q.push({i, j});
                    dis[i][j]=0;
                }
            }
//            printf("%s\n",grid[i]);
        }
        while(!q.empty()){
            int curx = q.front().first,cury=q.front().second;
            q.pop();
            vis[curx][cury]=true;
            for(int i=0;i<4;i++){
                int nx=curx+xm[i],ny=cury+ym[i];
                if(nx<0 || ny<0 || nx>9 || ny>9)continue;
                if(vis[nx][ny])continue;
                if(grid[nx][ny]!='T')continue;
                q.push({nx,ny});
                if(dis[nx][ny]==-1){
                    dis[nx][ny]=dis[curx][cury]+1;
                }else{
                    dis[nx][ny]=min(dis[nx][ny],dis[curx][cury]+1);
                }
            }
        }
        int ans=-10;
        bool poss = false;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(grid[i][j]=='T'){
                    if(dis[i][j]==-1)poss=true;
                    ans=max(ans,dis[i][j]);
                }
            }
        }
//        for(int i=0;i<10;i++){
//            printf("%s\n",grid[i]);
//        }
        if(poss)ans=-1;
        printf("%d\n",ans);
        string s;
        cin>>s;
    }
}
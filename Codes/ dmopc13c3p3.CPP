#include <bits/stdc++.h>
#define pii pair<int,int>
using namespace std;
int N,H;
int grid[1508][1508];
bool vist[1508][1508];
int xm[]={-1,1,0,0};
int ym[]={0,0,-1,1};
int main()
{
    scanf("%d %d",&N,&H);
    for(int i=1;i<=N;i++){
        for(int j=1;j<=N;j++){
            int d;
            scanf("%d",&d);
            grid[i][j]=d;
        }
    }
    queue<pii> q;
    q.push({1,1});
    vist[1][1]=true;
    while(!q.empty()){
        int cx=q.front().first;
        int cy=q.front().second;
        q.pop();
        for(int i=0;i<4;i++){
            int nx=cx+xm[i],ny=cy+ym[i];
            if (nx>=1&&ny>=1&&nx<=N&&ny<=N && !vist[nx][ny] && abs(grid[nx][ny]-grid[cx][cy])<=H){
                        vist[nx][ny]=true;
                q.push({nx,ny});
            }
        }
    }
    if(vist[N][N])printf("yes");
    else printf("no");
}
#include <bits/stdc++.h>
using namespace std;
struct node{
    int x,y,dis;
};
int x,y,x2,y2;
int xm[] = {1, -1, 2, 2, 1, -1, -2, -2},ym[] = {-2, -2, -1, 1, 2, 2, -1, 1};
bool valid(int x,int y){
    if(x>8 || x<1 || y>8||y<1)return false;
    return true;
}
int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>x>>y>>x2>>y2;
    queue<node>q;
    q.push({x,y,0});
    while(!q.empty()){
        int xx=q.front().x,yy=q.front().y,d=q.front().dis;q.pop();
        if(xx==x2 && yy==y2){
            printf("%d",d);
            return 0;
        }
        for(int i=0;i<8;i++){
            int nx=xx+xm[i],ny=yy+ym[i];
            if(valid(nx,ny)){
                q.push({nx,ny,d+1});
            }
        }
    }
}
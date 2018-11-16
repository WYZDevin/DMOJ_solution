#include <bits/stdc++.h>
using namespace std;
int ori[253][253],pre[253][253],W,H,N;
int psum(int x1,int y1,int x2,int y2){
        return pre[x2][y2]+pre[x1-1][y1-1]-pre[x2][y1-1]-pre[x1-1][y2];
}
int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>W>>H>>N;
    for(int i=1;i<=H;i++){
        for(int j=1;j<=W;j++){
            cin>>ori[j][i];
        }
    }
    for(int i=1;i<=W;i++){
        for(int j=1;j<=H;j++){
            pre[i][j]=ori[i][j]+pre[i][j-1]+pre[i-1][j]-pre[i-1][j-1];
        }
    }
    int maxx=0;
    for(int i=1;i<=N;i++){
        for(int x=1;x<=W;x++){
            for(int y=1;y<=H;y++){
                int xl=i,yl=N/i;
                if(x+xl-1<=W && y+yl-1<=H)
                    maxx=max(maxx,psum(x,y,x+xl-1,y+yl-1));
                else
                    break;
            }
        }
    }
cout<<maxx;
}
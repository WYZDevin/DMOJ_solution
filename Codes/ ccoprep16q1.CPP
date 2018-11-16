#include <bits/stdc++.h>

using namespace std;
char grid[1003][1003];
int h[1003];
int N,r,c;
int main(){
	cin.sync_with_stdio(0);cin.tie(0);
    cin>>N;
    while(N--){
        cin>>r>>c;
       memset(h,0,sizeof h);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                cin>>grid[i][j];
            }
        }
        int ans=0;
        for(int x=0;x<r;x++){
            for(int y= 0;y<c;y++){
                if(grid[x][y]=='R'){
                    h[y]=0;
                }else{
                    h[y]++;
                    int low=h[y],curdis=0;
                    for(int c=y;c>=0;c--){
                        if(h[c]<low){
                            low=h[c];
                        }
                        curdis=max((y-c+1)*low,curdis);
                        ans=max(curdis,ans);
                    }
                }
//                cout<<grid[x][y]<<x<<" "<<y<<" ";
//                for(int i=0;i<c;i++)
//                    cout<<" "<<h[i]<<" ";
//                cout<<endl;cout<<endl;
//                cout<<grid[x][y]<<" ";
            }
        }
//        for(int i=0;i<r;i++){
//            cout<<grid[i];
//            cout<<endl;
//        }
        cout<<ans*3<<endl;
    }
}
#include <bits/stdc++.h>
using namespace std;
int N,M,a,b,x,y,xx,yy;
vector<pair<int,int>> xm,ym;
int main(){
   scanf("%d",&N);
    for(int i=0;i<N;i++){
        scanf("%d %d",&a,&b);
        xm.push_back({a,b});
        ym.push_back({b,a});
    }
    sort(xm.begin(),xm.end());
    sort(ym.begin(),ym.end());
    scanf("%d",&M);
    scanf("%d %d",&xx,&yy);
    long ans=0;
    for(int i=1;i<M;i++){
        scanf("%d %d",&x,&y);
        if(x==xx){
            ans+=upper_bound(xm.begin() , xm.end() , make_pair(x,max(y,yy)))-lower_bound(xm.begin() , xm.end() , make_pair(x,min(y,yy)));
        }
        if(y==yy){
            ans+=upper_bound(ym.begin() , ym.end() , make_pair(y,max(x,xx)))-lower_bound(ym.begin() , ym.end() , make_pair(y,min(x,xx)));
        }
        xx=x,yy=y;
    }
    cout<<ans;
   return 0;
}
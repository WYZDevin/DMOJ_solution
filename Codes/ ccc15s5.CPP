#include <bits/stdc++.h>
using namespace std;
int ori[3010],N,M,dp[3010][2][111][111];
vector<int>n;
int rec(int p,int take,int l, int r){
    if(dp[p][take][l][r]>=0)
        return dp[p][take][l][r];
    int &ans = dp[p][take][l][r];
    if(p==N+1){
        if(l<=r){
            if(take){
                return ans = n[r]+rec(p,0,l,r-1);
            }else{
                return ans = rec(p,1,l+1,r);
            }
        }
        return 0;
    }else if(take){
        ans = max(rec(p+1,0,l,r)+ori[p],rec(p+1,1,l,r));
        if(l<=r)ans = max(ans,n[r]+rec(p,0,l,r-1));
    }else{
        ans = rec(p+1,1,l,r);
        if(l<=r)ans = max(ans,rec(p,1,l+1,r));
    }
    return ans;
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;for(int i=1;i<=N;i++)cin>>ori[i];
    cin>>M;for(int i=1;i<=M;i++){
        int a;
        cin>>a;
        n.push_back(a);
    }
    n.push_back(-1000000000);
    sort(n.begin(),n.end());
    memset(dp,-1,sizeof dp);
    printf("%d",rec(1,1,1,M));
}
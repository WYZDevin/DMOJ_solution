#include <bits/stdc++.h>
#define MAXN 30100
using namespace std;
int T,n,k,w,v[MAXN],pre[MAXN],dp[510][MAXN];
int main(){
    scanf("%d",&T);
    while(T--){
        memset(v,0,sizeof v);
        memset(pre,0,sizeof pre);
        memset(dp,0,sizeof dp);
        scanf("%d %d %d",&n,&k,&w);
        for(int i=0;i<n;i++)
            scanf("%d",&v[i]);
        for(int i=0;i<n;i++){
            for(int j=i;j<n &&j-w!=i;j++){
                pre[i]+=v[j];
            }
        }
        for(int i=0;i<510;i++)dp[i][0]=v[0];
        for(int i=1;i<=k;i++){
            for(int j=0;j<n;j++){
                int ns = pre[j];
                if(j-w>0)ns+=dp[i-1][j-w];
                dp[i][j]=max(ns,dp[i][j-1]);
            }
        }
        cout<<dp[k][n-1]<<endl;
    }
}
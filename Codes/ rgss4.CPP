#include <bits/stdc++.h>
using namespace std;
int N,A[1010],dp[1010];
int main(){
    scanf("%d",&N);
    for(int i=0;i<N;i++){
        scanf("%d",&A[i]);
    }
    int maxx=-100000000;
    for(int i=0;i<N;i++){
        int best=0;
        for(int j=A[i]-1;j>=0;j--)
            best=max(best,dp[j]);
        dp[A[i]]=best+A[i];
        maxx=max(maxx,dp[A[i]]);
    }
    printf("%d\n",maxx);
}
#include<bits/stdc++.h>
#define INF 0x3f3f3f
using namespace std;
const int MAXN =10030;
int N;
double dp[MAXN],shoe[MAXN];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=1;i<=N;i++)
        cin>>shoe[i];
    dp[1]=shoe[1];
    dp[2]=shoe[1];
    for(int i=2;i<=N;i++){
        double min1 = dp[i-1]+shoe[i];
        double min2 = dp[i-2]+max(shoe[i],shoe[i-1])+min(shoe[i],shoe[i-1])*0.5;
        double summ = 0;
        for(int j=i-2;j<=i;j++){
            summ+=shoe[j];
        }
        double min3 = dp[i-3]+summ-min(shoe[i-1],min(shoe[i],shoe[i-2]));
        dp[i]=min(min1,min(min2,min3));
    }
    printf("%.1f",dp[N]);
}
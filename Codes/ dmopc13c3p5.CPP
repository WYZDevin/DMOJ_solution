#include <bits/stdc++.h>
using namespace std;
int R,M,U;
int dp [303][103];
int t[151],v[151],u[151];
int main()
{
    scanf("%d %d %d",&M,&U,&R);
    for(int i=1,vi,ti,fi; i<=R; i++)
    {
        scanf("%d %d %d",&vi,&ti,&fi);
        v[i]=vi;
        t[i]=ti;
        u[i]=fi;
    }
    for(int i=1;i<=R; i++)
    {
        for(int j=M; j>=0; j--)
        {
            for(int k=U; k>=0; k--)
            {
                if(k-u[i]>=0 && j-t[i]>=0)
                    dp[j][k]=max(dp[j][k],dp[j-t[i]][k-u[i]]+v[i]);
            }
        }
    }
    printf("%d",dp[M][U]);
}
#include <bits/stdc++.h>
using namespace std;
int N;
string grid[2010];
int dp [2010][2010];
int main() {
    cin >> N;
    for(int i = 0 ; i < N ; i ++)
        cin >> grid[i];
    int ans = 0;
    for(int i = N-1 ; i >= 0 ; i --){
        for(int j = 0 ; j < N ; j ++){
            if(grid[i][j] == '#'){
                dp[i][j] = 1+ min(dp[i+1][j-1],min(dp[i+1][j+1],dp[i+1][j]));
            }

            ans += dp[i][j];
        }
    }
    printf("%d\n",ans);
    return 0;
}
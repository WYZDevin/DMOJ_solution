#include <bits/stdc++.h>

using namespace std;

unsigned long long n, sum[4010], m = 0, ans = 0, num[2010];



int main() {
    scanf("%lld", &n);
    for(int i = 0, t; i < n; i++){
        scanf("%d", &t);
        num[t]++;
    }

    for(int i = 0; i <= 2000; i++){
        sum[i+i] += num[i]/2;
        for(int j = i + 1; j <= 2000; j++){
            sum[i+j] += min(num[i], num[j]);
        }
    }

    for(int i = 0; i < 4010; i++){
        if(sum[i] > m){
            m = sum[i];
            ans = 1;
        } else if(sum[i] == m){
            ans++;
        }
    }
    cout << m << " " << ans;
    return 0;

}
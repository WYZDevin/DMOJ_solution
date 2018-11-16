#include <bits/stdc++.h>
using namespace std;
int N, K; vector<int> f;
int main(){
    scanf("%d", &K);
    for(int i=0, x=0; i<K; i++){
        scanf("%d", &x); f.push_back(x);
    }
    sort(f.begin(), f.end());
    scanf("%d", &N);
    for(int i=0, x=0; i<N; i++){
        scanf("%d", &x);
        printf("%d\n", x - (upper_bound(f.begin(), f.end(), x) - f.begin()));
    }
}
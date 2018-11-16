#include <bits/stdc++.h>
#define MAXN 1000100
#define ll long long
using namespace std;
ll N, P, bit[MAXN],sb[MAXN];
vector<pair<ll, int>> order;
int lowbit(int i){
    return i&(-i);
}
void update(int i, int val) {
    for(;i<MAXN;i+=lowbit(i))
        bit[i] += val;
}
int query(int i) {
    int sum = 0;
   for(;i>0;i-=lowbit(i)) {
       sum += bit[i];
   }
    return sum;
}
int main() {
    ll ans = 0;
    scanf("%d",&N);
    for (int i = 1;i<=N;i++) scanf("%d",&sb[i]);
    scanf("%d",&P);
    for (int i = 1;i<=N;i++) {
        sb[i] -= P;
        sb[i] += sb[i - 1];
        if(sb[i]>=0)ans++;
        order.push_back({sb[i],i});
    }
    sort(order.begin(), order.end());
    for (auto i : order) {
        ans += query(i.second);
        update(i.second, 1);
    }
    printf("%lld\n",ans);
}
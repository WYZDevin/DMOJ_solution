#include <bits/stdc++.h>
#define ll long long
using namespace std;
//variables
const int MAXN=100001;
int N,bit[MAXN];
double sum=0;
vector<ll> ori,rk;
map<ll,int> m;
//solution
int lowbit(int i){
    return i&(-i);
}
void add(int i, int v){
    for(;i<=MAXN;i+=lowbit(i)){
        bit[i]+=v;
    }
}

int query(int i){
    ll total=0;
    for(;i>0;i-=lowbit(i)){
        total+=bit[i];
    }
    return total;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        ll a;
        cin >> a;
        ori.push_back(a);
        rk.push_back(a);
    }
    sort(rk.rbegin(), rk.rend());

    int r = 1;
    for (ll i:rk)
        if (m.count(i) == 0)
            m[i] = r++;
//    for(ll i:rk)
//        cout<<m[i]<<endl;
    for (ll i:ori) {
        int cur = m[i];
        add(cur, 1);
        int ranking = query(cur-1)+1;
//        cout<<ranking<<" ";
        sum += ranking;
    }
    printf("%.2f\n", (sum / (N * 1.00)));

}
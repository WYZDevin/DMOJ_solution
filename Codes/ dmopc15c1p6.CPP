#include<bits/stdc++.h>
using namespace std;
#define MAXN 200003
typedef long long ll;

ll B1[MAXN], B2[MAXN],ori[MAXN];

ll pQuery(ll* B, int i){
    ll sum = 0;
    while(i > 0){
        sum += B[i];
        i -= (i & -i);
    }
    return sum;
}

//Returns BIT{1..r}
ll query(int r){
    return pQuery(B1, r) * r - pQuery(B2, r);
}

ll rangeQuery(int i, int j){
    return query(j) - query(i - 1);
}

void pUpdate(ll* B, int i, ll v){
    while(i <= MAXN){
        B[i] += v;
        i += (i & -i);
    }
}
void rangeUpdate(int l, int r, ll v){
    pUpdate(B1, l, v);
    pUpdate(B1, r+1, -v);
    pUpdate(B2, l, v * (l - 1));
    pUpdate(B2, r + 1, -v * r);
}
int M,N,Q;
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>M>>N>>Q;
    for(int i=1;i<=N;i++){
        int a;cin>>a;
        rangeUpdate(i,i,a);
    }
    for(int i=0;i<Q;i++){
        int type;cin>>type;
        if(type==1){
            int a,b;
            ll c;
            cin>>a>>b>>c;
            rangeUpdate(a,b,c);
        }else{
            int a,b;
            cin>>a>>b;
            ll ans=rangeQuery(a,b);
            printf("%lld\n",ans % M);
        }
    }
}
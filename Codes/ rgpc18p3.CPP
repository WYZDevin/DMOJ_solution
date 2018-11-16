#include<bits/stdc++.h>
using namespace std;
#define MAXN 1000001
typedef long long ll;

ll B1[MAXN], B2[MAXN];

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
int N,T,L;
int A[1000100];
int main() {
    ios::sync_with_stdio(false);
    cin>>N>>T;
    while(T--){
        int a,b,c;
        cin>>a>>b>>c;
        rangeUpdate(a,b,c);
    }
    cin>>L;
    int summ=0;
    int length=0;
    int ans = 0;
    for(int i=1;i<=N;i++){
//        printf("%d %d %d %d\n",i,length,L,summ);
        int cur =rangeQuery(i,i);
        A[i]=cur;
        ll newsum = summ+A[i];
        int idx1 = i-length,idx2 =i;
        while(newsum>L){
            newsum -= A[idx1++];
            length--;
        }
        summ=newsum;
        length++;
        ans = max(ans,length);
    }
    cout<<ans<<endl;

}
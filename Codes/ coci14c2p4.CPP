#include <bits/stdc++.h>
#define ll long long
struct node{
    int c,h,type;
    ll sum;
};
using namespace std;
const int MAXN = 1003;
int ori[MAXN][MAXN],h[MAXN][MAXN],R,C;
node m[MAXN];
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>R>>C;
    ll ans=0;
    for(int i=0;i<R;i++){
        int top=-1;
        for(int j=0;j<C;j++){
            cin>>ori[i][j];
            h[i][j]=1;
            int summ=1;
            if(i>0 && ori[i-1][j]==ori[i][j])h[i][j]+=h[i-1][j];
            for(;top>=0&&m[top].type==ori[i][j]&&m[top].h>=h[i][j];top--){
                summ+=m[top].c;
            }
            ll asum=summ*h[i][j];
            if(m[top].type==ori[i][j])asum+=m[top].sum;
            ans+=asum;
            m[++top]={summ,h[i][j],ori[i][j],asum};
        }
    }
    printf("%lld\n",ans);
}
#include <bits/stdc++.h>
#define PI 3.1415926
#define ll long long
using namespace std;
ll mod=pow(10,9)+13;
ll powe(ll b, ll n){
    if(n==0)return 1L;
    if(n==1)return b;
    ll t=powe(b,n/2);
    if(n%2==1)return ((t*t)%mod*b)%mod;
    else return t*t%mod;
}
int main()
{
    ll n,ans;
    scanf("%lld",&n);
    if(n==1 || n==2 || n==3){
        cout<<1<<endl;
        return 0;
    }
    ll m=(n+2)%8;
    if(m==0 || m==4)ans=powe(2,n-2);
    else if(m==1 || m==2 || m==3)ans=(powe(2,n/2-1)+powe(2,n-2))%mod;
    else ans=(mod-powe(2,n/2-1)+powe(2,n-2))%mod;
    cout<<ans;

}
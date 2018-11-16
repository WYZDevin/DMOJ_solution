#include <bits/stdc++.h>
using namespace std;
int n;
int run(int n){
    if(n==1)return 0;
    for(int i=2;i<=n;i++){
        if(n%i==0){
            int x=n/i;
            n-=x;//pre
            return run(n)+(n/x);
        }
    }
}
int main()
{
    cin>>n;
    cout<<run(n);
}
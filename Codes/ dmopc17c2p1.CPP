#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N;cin>>N;
    long long sum=0;
    for(int i=0;i<N;i++){
        int a,b;cin>>a>>b;
        if(b>0)sum+=a;
    }
    cout<<sum;
}
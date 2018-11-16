#include <bits/stdc++.h>
using namespace std;
int n;
int main()
{
    cin>>n;
    int a=100,b=100;
    for(int i=0;i<n;i++){
        int c,d;
        cin>>c>>d;
        if(c>d)b-=c;
        if(d>c)a-=d;
    }
    cout<<a<<endl<<b;
}
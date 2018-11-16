#include <bits/stdc++.h>
using namespace std;
int main()
{
    int a,b,c,d,e,f;
    int D;
    cin>>a>>b>>c>>d>>e>>f>>D;
    if(pow(e-a,2)+pow(f-b,2)<=pow(D,2) ||(pow(e-c,2)+pow(f-d,2)<=pow(D,2)))cout<<"Yes";
    else cout<<"No";
}
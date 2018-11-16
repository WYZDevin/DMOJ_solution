#include <bits/stdc++.h>
using namespace std;
int n;
int main()
{
    cin>>n;
    int c=0;
    bool used[6];
    memset(used,0,sizeof(used));
    for(int i=0;i<=5;i++){
        for(int j=0;j<=5;j++){
            if(used[i] || used[j])continue;
            if(i+j==n){
                c++;
                used[i]=true;
                used[j]=true;
            }
        }
    }
    cout<<c;
}
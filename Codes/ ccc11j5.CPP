#include <bits/stdc++.h>
using namespace std;
int N[7];
//main
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for(int i=0;i<7;i++)N[i]=1;
    int a;
    cin>>a;
    for(int i=1;i<a;i++){
        int b;
        cin>>b;
        N[b]*=(N[i]+1);
    }
    printf("%d\n",N[a]);
}
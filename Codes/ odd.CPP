#include <bits/stdc++.h>
using namespace std;
//main
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int a,b=0;
    cin>>a;
    for(int i=0,c;i<a;i++){
        cin>>c;
        b^=c;
    }
    printf("%d",b);
}
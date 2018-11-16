#include <bits/stdc++.h>
using namespace std;
int main() {
        int a,b;
    cin>>a
       >>b;
    int count=0;
    for (int i = 1; i < b; ++i) {
        if(pow(i,6)<=b && pow(i,6)>=a){
            count++;
        }else if(pow(i,6)>b){
            break;

        }
    }
    cout<<count<<endl;
    return 0;
}
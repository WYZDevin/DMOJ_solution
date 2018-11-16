#include <bits/stdc++.h>
using namespace std;
char alp [] = {'I', 'O', 'S', 'H', 'Z', 'X', 'N'};
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    string s;cin>>s;
    bool check1=true;
    for(char i:s){
        bool check2=false;
        for(char j:alp){
            if(i==j)check2=true;
        }
       if(!check2)check1=false;
        if(!check1)break;
    }
    check1?cout<<"YES":cout<<"NO";
}
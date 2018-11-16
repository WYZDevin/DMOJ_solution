#include <bits/stdc++.h>
using namespace std;
int main(){
    int N; 
    cin>>N;
    string s;
    cin>>s;int a=0,b=0;
    for(char i: s){
        if(i=='A')a++;
        else b++;
    }
    if(a>b)cout<<"A";
    if(b>a)cout<<"B";
    if(b==a)cout<<"Tie";
}
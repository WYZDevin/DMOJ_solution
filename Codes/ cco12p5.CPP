#include <bits/stdc++.h>
#define MAXN 1000003
using namespace std;
int N,num[103];
bool vis[103];
vector<int> q;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    while(N--){
        int a;cin>>a;q.push_back(a);
    }
    for(int i=1;i<=100;i++){
        memset(vis,0,sizeof vis);
        vis[0]=true;
        for(int j=1;j<=i;j++){
            vis[(int)(100.0*j/i+0.5)]=true;
        }
        bool c=true;
        for(int j:q){
            if(!vis[j])c=false;
        }
        if(c){
           cout<<i;return 0;
        }
    }

}
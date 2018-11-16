#include <bits/stdc++.h>
using namespace std;
int T,N,ans=0,tree[1000003][27],cnt=1;
string word;
void solve(){
   int p=0,t=0;
    for(int i=0;i<word.length();i++){
        int c=word[i]-'a';
        if(tree[p][c]== -1){
            if(!t)t=i+1;
            tree[p][c]=cnt++;
        }
        p=tree[p][c];
    }
    if(!t)t=word.size();
    ans+=t;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin>>T;
    for(int i=1;i<=T;i++){
        cin>>N;
        ans=0;
        cnt=1;
        memset(tree,-1,sizeof tree);
        for(int j=0;j<N;j++){
            cin>>word;
            solve();
        }
        printf("Case #%d: %d\n",i,ans);
    }
}
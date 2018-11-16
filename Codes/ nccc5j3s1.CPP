#include <bits/stdc++.h>
using namespace std;
int A[110],N,X;
vector<int>q;
int main() {
    cin>>N>>X;
    for(int i=0;i<N;i++){
        int a;cin>>a;
        q.push_back(a);
    }
    sort(q.begin(),q.end());
    int ans=0;
    for(int i=0;i<q.size();i++){
        int j = q[i];
         if(j==X){
             ans+=(i*(q.size()-1-i));
         }
    }
    cout<<ans<<endl;
}
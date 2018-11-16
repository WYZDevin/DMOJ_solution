#include <bits/stdc++.h>
using namespace std;
int N,M;

int main(){
    cin>>N>>M;
    if(N%M==0){
        cout<<"yes "<<N/M<<endl;
    }else{
        int ans = 0x3f3f3f3f;
        for(int i=1;i<=N;i++){
            if(N%i == 0){
                if(i-M>=0){
                    ans = min(ans,i-M);
                }
            }
        }
        cout<<"no "<<ans<<endl;
    }
}
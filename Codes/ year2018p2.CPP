#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100003;
bool p[MAXN];
int main(){
    for(int i=2;i<=MAXN ; i ++ ){
        if(!p[i]){
            for(int j=i*i;j<=MAXN && j>0;j+=i){
                p[j]=true;
            }
        }
    }
    int N;
    scanf("%d",&N);
    int ans=0;
    for(int i=0;i<N;i++){
        int a;
        scanf("%d",&a);
        if(!p[a] && a!=1)
            ans++;
    }
    cout<<ans<<"\n";
}
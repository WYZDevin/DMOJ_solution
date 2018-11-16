#include <bits/stdc++.h>
using namespace std;
int N,n;
bool c=false;
int main(){
   scanf("%d",&N);
    for(int i=0;i<N;i++){
        scanf("%d",&n);
        for(int i=2;i<=n/i;i++){
            while(n%i==0){
                printf("%d ",i);
                n/=i;
            }
        }
        if(n>1)printf("%d ",n);
        cout<<endl;
    }
   return 0;
}
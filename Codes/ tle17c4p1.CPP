#include <bits/stdc++.h>
using namespace std;
int N,M,K;
int main(){
    cin>>M>>K>>N;
    int ans = ceil(0.595*N-K);
    if(ans>M)printf("have mercy snew\n");
    else printf("%d\n",max(ans,0));

}
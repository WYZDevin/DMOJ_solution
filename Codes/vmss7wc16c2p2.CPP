#include <bits/stdc++.h>
using namespace std;
int sum[100100];
int main(){
    string s;
    cin>>s;
    int Q;
    for(int i=0;i<s.length();i++){
        if(s[i]=='G')sum[i]++;
        if(i>0)sum[i]+=sum[i-1];
    }
    cin>>Q;
    while(Q--){
        int a,b;
        scanf("%d %d",&a,&b);
        printf("%d\n",sum[b]-sum[a-1]);
    }
}
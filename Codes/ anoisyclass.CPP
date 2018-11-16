#include<bits/stdc++.h>
using namespace std;
bool v[10003];
vector<int> adjlist [10003];
vector<int> ca;
int N,M;
bool run(int cp,int lp){
    if(v[cp])
        return true;
    v[cp]=true;
    for(int i:adjlist[cp]){
        if(i==lp)
            return true;
        if(run(i,cp))
            return true;
    }
    v[cp]=false;
    return false;
}
int main(){
    scanf("%d %d",&N,&M);
    for(int i=0;i<N;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        ca.push_back(a);
        adjlist[a].push_back(b);
    }
    bool check=false;
    for(int i:ca){
        if(run(i,i))
           check=true;
        if(check)
            break;
    }
    if(check)printf("N");
    else printf("Y");
    return 0;
}
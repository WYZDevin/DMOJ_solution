#include <bits/stdc++.h>
using namespace std;
struct node{
    int src,tar,key;
    bool flag = false;
    node(int a,int b,int c,bool f){
        src=a;tar=b;key=c;
        flag = f;
    }
};
bool comp(node i,node j){
    return i.key<j.key;
}
const int MAXK = 1000000010;
unordered_set<int>adj[1010];
pair<int,int> m[1010];
int N,M,S,T,K,sum=0;
bool vis[1010];
vector<node>A;
queue<int>q;
bool run(int S){
    while(!q.empty())q.pop();
    memset(vis,0,sizeof vis);
    q.push(S);
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        if(cur == T)return true;
        for(int i:adj[cur]){
            if(!vis[i]){
                vis[i]=true;
                q.push(i);
            }
        }
    }
    return false;
}
int main(){
    scanf("%d %d %d %d %d",&N,&M,&K,&S,&T);
    for(int i=0;i<M;i++){
        int a,b,c,d;
        scanf("%d %d %d %d",&a,&b,&c,&d);
        A.push_back(node(a,b,c, true));
        A.push_back(node(a,b,d+1,false));
    }
    sort(A.begin(),A.end(),comp);
    A.push_back({0,0,K,1});
    for(int j=0;j<A.size()-1;j++) {
        auto i = A[j];
//        printf("%d %d %d %d\n", i.src, i.tar, i.key, i.flag);
        if(i.flag)
            adj[i.src].insert(i.tar);
        else
            adj[i.src].erase(i.tar);
        if(run(S))
            sum+=(A[j+1].key - A[j].key);
    }
    cout<<sum<<endl;
}
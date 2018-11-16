#include <bits/stdc++.h>
#define MAX 0x3f3f3f
using namespace std;
struct node{
    int w,v;
};
bool compare(node i,node j){
   if(i.v==j.v)return i.w<j.w;
    return i.v>j.v;
}
int N,M;
vector<node> q;
multiset <int> bag;
int main()
{
    scanf("%d %d",&N,&M);
    for(int i=0;i<N;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        q.push_back({a,b});
    }
    sort(q.begin(),q.end(),compare);
    for(int i=0;i<M;i++){
        int a;
        scanf("%d",&a);
        bag.insert(a);
    }
//    for(int i=0;i<q.size();i++)
//        cout<<q[i].v<<" "<<q[i].w<<endl;
    long long ans=0;
    for(int i=0;i<N;i++){
        if(bag.empty())break;
        multiset <int>::iterator p = bag.lower_bound(q[i].w);
        if(p==bag.end())continue;
        bag.erase(p);
        ans+=q[i].v;
    }
    cout<<ans;
}
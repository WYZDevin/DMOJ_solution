#include <bits/stdc++.h>
using namespace std;
struct q{
    int begin,end,v,ans,id;
};
const int MAXN=100003;
int N,bit[MAXN],Q,arr[MAXN];
vector<q> ori,ans;
vector<pair<int,int>>in;
bool done[20003];
bool com(q i,q j){
    return i.v>j.v;
}
bool comp(pair<int,int> i, pair<int,int> j){
    return i.first>j.first;
}
//variables
int lowbit(int i){
    return i&(-i);
}
void update(int i,int v){
    for(;i<=MAXN;i+=lowbit(i)){
        bit[i]+=v;
    }
}
long long query(int i){
    long long sum=0;
    for(;i>0;i-=lowbit(i)){
        sum+=bit[i];
    }
    return sum;
}
long long rangeQuery(int i,int j){
    return query(j)-query(i-1);
}
//binary indexed tree
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0;i<N;i++){
        int a;cin>>a;
        in.push_back({a,i+1});
        arr[i]=a;
    }
    cin>>Q;
    for(int i=0;i<Q;i++){
        int a,b,c;
        cin>>a>>b>>c;a++;b++;
        ori.push_back({a,b,c,0,i});
        ans.push_back({a,b,c,0,i});
    }
    sort(ori.begin(),ori.end(),com);
    sort(in.begin(),in.end(),comp);
    int idx=0;
//    for(pair<int,int> i:in)
//        printf("%d %d\n",i.first,i.second);
    for(q i:ori){
//        printf("%d %d %d %d\n",i.begin,i.end,i.v,i.id);
        for(int j=idx;j<N;j++){
            if(in[j].first>=i.v){
                update(in[j].second,in[j].first);
                idx=j+1;
//                printf("%d %d\n",in[j].first,in[j].second);
            }else break;
        }
        ans[i.id].ans=rangeQuery(i.begin,i.end);
    }
    for(q i:ans){
        printf("%d\n",i.ans);
    }
}
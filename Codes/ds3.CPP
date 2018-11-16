#include <bits/stdc++.h>
#define MAXN 100005
#define INF 0x3f3f3f3f
using namespace std;
int segMin[MAXN*3],segGCD[MAXN*3],segn[MAXN*3],data[MAXN],N,Q;
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
void build(int id,int L, int R){
    if(L==R){
        segMin[id]=data[L];
        segGCD[id]=data[L];
        segn[id]=1;
        return;
    }
    int mid=(L+R)/2;
    int nl=id*2,nr=id*2+1;
    build(nl,L,mid);
    build(nr,mid+1,R);
    segMin[id]=min(segMin[nl],segMin[nr]);
    segGCD[id]=gcd(segGCD[nl],segGCD[nr]);
    if(segGCD[id]==segGCD[nl])
        segn[id]+=segn[nl];
    if(segGCD[id]==segGCD[nr])
        segn[id]+=segn[nr];
}
void update(int id,int L,int R,int qid,int v){
    if(L==R){
        segMin[id]=v;
        segGCD[id]=v;
        segn[id]=1;
        return;
    }
    int nl=id*2,nr=id*2+1,mid=(L+R)/2;
    if(qid<=mid){
        update(nl,L,mid,qid,v);
    }else{
        update(nr,mid+1,R,qid,v);
    }
    segMin[id]=min(segMin[nl],segMin[nr]);
    segGCD[id]=gcd(segGCD[nl],segGCD[nr]);
    segn[id]=0;
    if(segGCD[id]==segGCD[nl])
        segn[id]+=segn[nl];
    if(segGCD[id]==segGCD[nr])
        segn[id]+=segn[nr];
}
int queryMin(int id, int L, int R, int ql, int qr){
    if(L==ql && R==qr){
        return segMin[id];
    }
    int mid=(L+R)/2;
    if(qr<=mid)return queryMin(id*2,L,mid,ql,qr);
    if(ql>mid)return queryMin(id*2+1,mid+1,R,ql,qr);
    return min(queryMin(id*2,L,mid,ql,mid),queryMin(id*2+1,mid+1,R,mid+1,qr));
}
int queryGCD(int id, int L, int R, int ql, int qr){
    if(L==ql && R==qr){
        return segGCD[id];
    }
    int mid=(L+R)/2;
    if(qr<=mid)return queryGCD(id*2,L,mid,ql,qr);
    if(ql>mid)return queryGCD(id*2+1,mid+1,R,ql,qr);
    return gcd(queryGCD(id*2,L,mid,ql,mid),queryGCD(id*2+1,mid+1,R,mid+1,qr));
}
int queryn(int id,int L, int R, int ql,int qr,int v) {
    if(L==ql && R==qr){
        return segGCD[id]==v?segn[id]:0;
    }
    int mid=(L+R)/2;
    if(qr<=mid)return queryn(id*2,L,mid,ql,qr,v);
    if(ql>mid)return queryn(id*2+1,mid+1,R,ql,qr,v);
    return queryn(id*2,L,mid,ql,mid,v)+queryn(id*2+1,mid+1,R,mid+1,qr,v);
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>Q;
    for(int i=0;i<N;i++){
        cin>>data[i];
    }
    build(1,0,N-1);
    for(int i=0;i<Q;i++){
        string op;int a,b;
        cin>>op>>a>>b;
        a--;
        if(op=="C"){
            data[a]=b;
            update(1,0,N-1,a,b);
        }else if(op=="M"){
            cout<<queryMin(1,0,N-1,a,--b)<<"\n";
        }else if(op=="G"){
            cout<<queryGCD(1,0,N-1,a,--b)<<"\n";
        }else{
            int v=queryGCD(1,0,N-1,a,--b),ans=0;
            ans=queryn(1,0,N-1,a,b,v);
            cout<<ans<<"\n";
        }
    }
}
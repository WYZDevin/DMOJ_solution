#include <bits/stdc++.h>
#define ll long long
const int MAXN = 1001000;
ll node[MAXN];
ll lazy[MAXN];
using namespace std;

// range update with lazy propagation
// ql and qr define the update range
void rangeupdate(int stidx, int L, int R, int ql, int qr, int val)
{
    if (lazy[stidx]!=0) // need updating
    {
        //update current segment as everything is within range
        node[stidx] += lazy[stidx]; // if solving RMQ and alike don't multiply (R-L+1)
        //if it is not a leaf node, we need to update lazy value for the children
        if (L!=R)
        {
            lazy[stidx*2] += lazy[stidx];
            lazy[stidx*2+1] += lazy[stidx];
        }
        //finish updating for current idx
        lazy[stidx] = 0;
    }
    //out of range
    if (L>R || L > qr || R < ql)
        return;
    //Current segment is fully in update range. Use lazy propagation
    if (L >= ql && R <= qr)
    {
        node[stidx] += val;
        //if it is not a leaf node, we need to update lazy value for the children
        if (L!=R)
        {
            lazy[stidx*2] += val;
            lazy[stidx*2+1] += val;
        }
        return;
    }
    //if not, recur for children and use result to update
    int mid = (L+R)/2;
    rangeupdate(stidx*2,L,mid,ql,qr,val);
    rangeupdate(stidx*2+1,mid+1,R,ql,qr,val);
    node[stidx] = max(node[stidx*2] , node[stidx*2+1]);
}
// use this when using lazy propagation
ll rangequery(int stidx, int L, int R, int ql, int qr)
{
    if (lazy[stidx]!=0) // need updating
    {
        //update current segment as everything is within range
        node[stidx] +=lazy[stidx];
        //if it is not a leaf node, we need to update lazy value for the children
        if (L!=R)
        {
            lazy[stidx*2] += lazy[stidx];
            lazy[stidx*2+1] += lazy[stidx];
        }
        //finish updating for current idx
        lazy[stidx] = 0;
    }
    //out of range
    if (L>R || L > qr || R < ql)
        return 0;
    //Complete in range
    if (L >= ql && R <= qr)
        return node[stidx];
    //else do it the old way
    int mid = (L+R)/2;
    return max(rangequery(stidx*2,L,mid,ql,qr) , rangequery(stidx*2+1,mid+1,R,ql,qr));
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie();
    int N,K,Q;
    cin>>N>>K>>Q;
    while(Q--){
        int cmd,a,b;
        cin>>cmd>>a>>b;
        if(cmd == 0){
            rangeupdate(1,0,N-1,max(0,a-K+1),a,b);
        }else{
            if(a>=N)continue;
            printf("%lld\n",rangequery(1,0,N-1,a,min(b,N-1)));
        }
    }
}
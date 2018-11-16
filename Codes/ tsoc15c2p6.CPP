#include <bits/stdc++.h>
const int MAXN = 30100;
int node[MAXN*4];
int lazy[MAXN*4],A[MAXN];
using namespace std;
void buildtree(int id, int L, int R)
{
    if (L==R)
    {
        node[id] = A[L];
        //assign value to node[stidx];
        return;
    }
    int le = 2 * id, ri = le + 1, mid = (L + R) / 2;
    buildtree(le, L, mid);
    buildtree(ri, mid+1, R);
    int p1 = node[le], p2 = node[ri];
    //assign value to node[stidx];
    node[id]=min(p1,p2);
}
//call query(1,0,N-1,i,j);
// range update with lazy propagation
// ql and qr define the update range
void rangeupdate(int id, int L, int R, int ql, int qr, int val)
{
    if (lazy[id]!=0) // need updating
    {
        //update current segment as everything is within range
        node[id] = max(0,node[id]+lazy[id]); // if solving RMQ and alike don't multiply (R-L+1)
        //if it is not a leaf node, we need to update lazy value for the children
        if (L!=R)
        {
            lazy[id*2] += lazy[id];
            lazy[id*2+1] += lazy[id];
        }
        //finish updating for current idx
        lazy[id] = 0;
    }
    //out of range
    if (L>R || L > qr || R < ql)
        return;
    //Current segment is fully in update range. Use lazy propagation
    if (L >= ql && R <= qr)
    {
        node[id] = max(0,node[id]+val);
        //if it is not a leaf node, we need to update lazy value for the children
        if (L!=R)
        {
            lazy[id*2] += val;
            lazy[id*2+1] += val;
        }
        return;
    }
    //if not, recur for children and use result to update
    int mid = (L+R)/2;
    rangeupdate(id*2,L,mid,ql,qr,val);
    rangeupdate(id*2+1,mid+1,R,ql,qr,val);
    node[id] = min(node[id*2] , node[id*2+1]);
}
// use this when using lazy propagation
int rangequery(int id, int L, int R, int ql, int qr)
{
    if (lazy[id]!=0) // need updating
    {
        //update current segment as everything is within range
        node[id] = max(0,node[id]+lazy[id]);
        //if it is not a leaf node, we need to update lazy value for the children
        if (L!=R)
        {
            lazy[id*2] += lazy[id];
            lazy[id*2+1] += lazy[id];
        }
        //finish updating for current idx
        lazy[id] = 0;
    }
    //out of range
    if (L>R || L > qr || R < ql)
        return 0x3f3f3f3f;
    //Complete in range
    if (L >= ql && R <= qr)
        return node[id];
    //else do it the old way
    int mid = (L+R)/2;
    return min(rangequery(id*2,L,mid,ql,qr) , rangequery(id*2+1,mid+1,R,ql,qr));
}
int N,Q;
int main()
{
    scanf("%d %d",&N,&Q);
    for(int i=0;i<N;i++){
        scanf("%d",&A[i]);
    }
    buildtree(1,0,N-1);
    for(int i=0;i<Q;i++){
        int a,b,c;
        scanf("%d %d %d",&a,&b,&c);
        a--,b--;
        rangeupdate(1,0,N-1,a,b,-c);
        printf("%d %d\n",rangequery(1,0,N-1,a,b),rangequery(1,0,N-1,0,N-1));
    }
}
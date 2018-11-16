#include <bits/stdc++.h>
#define MAXN 250100
using namespace std;
struct node{
    int  sum=0, lazy;
    int cnt [10];
} seg[MAXN * 4];

int data[MAXN],N,M;
int neww[10];

void build(int id, int l, int r){
    seg[id].lazy=0;
    if(l!=r){
        int mid = (l+r)/2,nl=id*2,nr=id*2+1;
        build(nl,l,mid);
        build(nr,mid+1,r);
        seg[id].sum = seg[nl].sum+seg[nr].sum;
        for(int i=0;i<10;i++){
            seg[id].cnt[i]+=(seg[nl].cnt[i]+seg[nr].cnt[i]);
        }
        seg[id].sum = seg[nl].sum + seg[nr].sum;
    }else{
        seg[id].sum=data[l];
        seg[id].cnt[data[l]]++;
    }
}
char s[MAXN];
void push_down(int id,int l,int r,int val){
   for(int i=0;i<10;i++){
       int n=(i+val)%10;
       neww[n]=seg[id].cnt[i];
   }
    for(int i=0;i<10;i++){
        seg[id].cnt[i]=neww[i];
    }
    seg[id].sum=0;
    for(int i=0;i<10;i++)
        seg[id].sum +=seg[id].cnt[i]*i;
    if(l!=r){
        seg[id*2].lazy+=val;
        seg[id*2+1].lazy+=val;
    }

}
void update(int id, int l, int r,int ql,int qr,int val){
    if(seg[id].lazy!=0){
        push_down(id,l,r,seg[id].lazy);
        seg[id].lazy=0;
    }
    if(l>qr || r<ql)return;
    if(l>=ql && r<=qr){
        push_down(id,l,r,val);
        return;
    }
    int mid=(l+r)/2,nl=id*2,nr=id*2+1;
    update(nl,l,mid,ql,qr,val);
    update(nr,mid+1,r,ql,qr,val);
    for(int i=0;i<10;i++){
        seg[id].cnt[i]=seg[nl].cnt[i]+seg[nr].cnt[i];
    }
    seg[id].sum=0;
    for(int i=0;i<10;i++){
        seg[id].sum+=seg[id].cnt[i]*i;
    }
}
int query(int id,int l,int r,int ql, int qr){
    if(seg[id].lazy!=0){
        push_down(id,l,r,seg[id].lazy);
        seg[id].lazy=0;
    }
    if(l>qr || r<ql)return 0;
    if(l>=ql && r<=qr){
        return seg[id].sum;
    }
    int mid=(l+r)/2, nl =id*2, nr=id*2+1;
    int q1 = query(nl,l,mid,ql,qr),q2=query(nr,mid+1,r,ql,qr);
    return q1+q2;
}

int main(){
    scanf("%d %d",&N,&M);
    scanf("%s",s);
    for(int i=0;i<N;i++){
        data[i]=s[i]-'0';
    }
    build(1,0,N-1);
    for(int i=0;i<M;i++){
        int a,b;
//        printf("%d\n",i);
        scanf("%d %d",&a,&b);
        a--,b--;
        printf("%d\n",query(1,0,N-1,a,b));
        update(1,0,N-1,a,b,1);
//        printf("ssss");
    }
}
#include<bits/stdc++.h>
using namespace std;
const int MAXN = pow(2,20)+100;
int N,M,A[MAXN];
int seg[4 * MAXN],ans[MAXN];
void build(int id, int left, int right){
    if (left == right){
        seg[id] = left;
        ans[left]=0;
        return;
    }

    int mid = (left + right) / 2;
    build(id * 2, left, mid);
    build(id * 2 + 1, mid + 1, right);
    if(A[seg[id*2]] > A[seg[id*2+1]]){
        seg[id] = seg[id*2];
        ans[seg[id*2]]++;
    }else{
        seg[id] = seg[id*2+1];
        ans[seg[id*2+1]]++;
    }
}

void update(int id, int left, int right, int uid, int val){
    if (left == right){
        seg[id] = uid;
        ans[left] = 0;
        return;
    }
    ans[seg[id]]--;
    int mid = (left + right) / 2;

    if (uid <= mid){
        update(id * 2, left, mid, uid, val);
    } else {
        update(id * 2 + 1, mid + 1, right, uid, val);
    }

    if(A[seg[id*2]] > A[seg[id*2+1]]){
        seg[id] = seg[id*2];
        ans[seg[id*2]]++;
    }else{
        seg[id] = seg[id*2+1];
        ans[seg[id*2+1]]++;
    }
}

int query(int id, int left, int right, int qleft, int qright){
    if (left > qright || right < qleft) return -1000000;
    if (qleft <= left && qright >= right) return seg[id];

    int mid = (left + right) / 2;
    return min(query(id * 2, left, mid, qleft, qright),
               query(id * 2 + 1, mid + 1, right, qleft, qright));
}

int main() {
    scanf("%d %d",&N,&M);
    int end = pow(2,N);
    for(int i=1;i<=end;i++){
        scanf("%d",&A[i]);
    }
    build(1,1,end);
    while(M--){
        char s;
        cin>>s;
        int a,b;
        if(s == 'S'){
            scanf("%d",&a);
//            for(int i=1;i<=end;i++)
//                printf("%d ",A[i]);
//            printf("\n");
//            for(int i=1;i<=end;i++)
//                printf("%d ",ans[i]);
//            printf("\n");
            printf("%d\n",ans[a]);
        }else if(s == 'W'){
            printf("%d\n",query(1,1,end,1,end));
        }else{
            int a,b;
            scanf("%d %d",&a,&b);
            A[a]=b;
//            printf("update start\n");
            update(1,1,end,a,b);
        }
    }
}
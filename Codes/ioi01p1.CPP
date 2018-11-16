#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1030;
int bit[MAXN][MAXN],M,N,in;
int lowbit(int i){
    return i&(-i);
}
void update(int x,int y,int v){
    int y1;
    for(;x<=N;x+=lowbit(x)){
        y1=y;
        for(;y1<=N;y1+=lowbit(y1)){
            bit[x][y1]+=v;
        }
    }
}
int query(int x,int y){
    int sum=0;
    for(;x>0;x-=lowbit(x)){
        int y1=y;
        for(;y1>0;y1-=lowbit(y1)){
            sum+=bit[x][y1];
        }
    }
    return sum;
}
int rangeQuery(int x1,int y1,int x2,int y2){
    return query(x2,y2)-query(x2,y1-1)-query(x1-1,y2)+query(x1-1,y1-1);
}
int main(){
    cin.sync_with_stdio(0);cin.tie(0);
    cin>>M>>N;
    while(true) {
        cin >> in;
        if(in==3)break;
        if(in==1){
            int a,b,v;
            cin>>a>>b>>v;
            a++,b++;
            update(a,b,v);
        }else{
            int a,b,c,d;
            cin>>a>>b>>c>>d;
            a++,b++,c++,d++;
            printf("%d\n",rangeQuery(a,b,c,d));
        }
    }

}
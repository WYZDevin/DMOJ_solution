#include <bits/stdc++.h>
using namespace std;
bool find(int x,int y,int l){
    if(l==0)return false;
    int bl=pow(5,l-1);
    int x1=x/bl,y1=y/bl;
    if(((x1==1 || x1==3)&&y1==1) ||(x1==2&&y1==2) ){
        return find(x%bl,y%bl,l-1);
    }
    if((x1>0 &&x1<4 && y1==0) ||(x1==2 && y1==1)){
        return true;
    }
    return false;

}
int main(){
    int N;
    scanf("%d",&N);
    for(int i=0;i<N;i++){
        int a,b,c;
        scanf("%d %d %d",&a,&b,&c);
        if(find(b,c,a)){
            printf("crystal\n");
        }else{
            printf("empty\n");
        }
    }
}
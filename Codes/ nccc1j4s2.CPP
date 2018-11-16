#include <bits/stdc++.h>
using namespace std;
int N,ans;
string grid[36];
bool ocur(int r,int c,char l){
    int a1=0;
    for(int i = 0;i<N;i++){
        if(grid[i][c] == l)a1++;
    }
    if(a1>1)return false;
    a1=0;
    for(int i = 0;i<N;i++){
        if(grid[r][i] == l)a1++;
    }
    return a1==1;
}

int main(){
   cin>>N;
    for(int i=0;i<N;i++)
        cin>>grid[i];
    bool fuck = true;
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++){
            if(!ocur(i,j,grid[i][j])){
                fuck = false;
            }
        }

    if(!fuck){
        cout<<"No"<<endl;
        return 0;
    }
    bool shit = true;
    bool sb1=true,sb2=true,sb3=true,sb4=true;
    for(int i=1;i<N;i++){
        if(grid[i][0]<grid[i-1][0])sb1=false;
    }
//    for(int i=1;i<N;i++){
//        if(grid[i][0]>grid[i-1][0])sb2=false;
//    }
    if(!sb1)sb3=false;
    sb1=true,sb2=true;
    for(int i=1;i<N;i++){
        if(grid[0][i]<grid[0][i-1])sb1=false;
    }
//    for(int i=1;i<N;i++){
//        if(grid[0][i]>grid[0][i-1])sb2=false;
//    }
    if(!sb1)sb4=false;
    if(!sb3 || !sb4)cout<<"Latin"<<endl;
    else cout<<"Reduced"<<endl;
}
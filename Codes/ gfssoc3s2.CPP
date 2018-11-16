#include <bits/stdc++.h>
#define pii pair<int,int>
using namespace std;
struct node{
    int pr,pc,br,bc,ste;
};
int xm[]={-1,1,0,0};
int ym[]={0,0,1,-1};
int R,C;
pii B,P,X;
string grid[32];
bool vist[32][32][32][32];
queue<node>q;
bool valid(int cr,int cc){
    if(cr>=R || cr<0 || cc>=C || cc<0)return false;
    return true;
}
int main()
{
    cin>>R>>C;
    for(int i=0;i<R;i++){
        string c;
        cin>>c;
        for(int j=0;j<C;j++){
            if(c[j]=='B')B={make_pair(i,j)};
            if(c[j]=='P')P={make_pair(i,j)};
            if(c[j]=='X')X={make_pair(i,j)};
        }
        grid[i]=c;
    }
    q.push({P.first,P.second,B.first,B.second,0});
    while(!q.empty()){
        node cur=q.front();q.pop();
        int pr=cur.pr,pc=cur.pc,br=cur.br,bc=cur.bc,step=cur.ste;
//        printf("%d %d box %d %d target %d %d\n",pr,pc,br,bc,B.first,B.second);
        if(br==X.first && bc==X.second){
            cout<<step<<endl;
            return 0;
        }
        if(vist[pr][pc][br][bc])continue;
        vist[pr][pc][br][bc]=true;
        for(int i=0;i<4;i++){
            int nr=pr+xm[i],nc=pc+ym[i];
            if(!valid(nr,nc) || grid[nr][nc]=='#')continue;
            if(nr==br && nc==bc){
                int nbr=br+xm[i],nbc=bc+ym[i];
                if(!valid(nbr,nbc) || grid[nbr][nbc]=='#')continue;
                q.push({nr,nc,nbr,nbc,step+1});
            }else
                q.push({nr,nc,br,bc,step+1});
        }
    }
    cout<<-1;
}
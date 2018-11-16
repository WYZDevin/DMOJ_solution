#include <bits/stdc++.h>
#define MAX 0x3f3f3f
using namespace std;

map <string,int> m;
int N,M,st;
vector<pair<int,double>>adj[503];
int main()
{
    scanf("%d %d",&N,&M);
    for(int i=0;i<N;i++){
        string s;
        cin>>s;
        if(s=="APPLES")st=i;
        m[s]=i;
    }
    for(int i=0;i<M;i++){
        string s1,s2;
        double r;
        cin>>s1>>s2>>r;
        adj[m[s1]].push_back({m[s2],r});
    }
    double value[503];
    queue<pair<int,double>> q;
    q.push({st,1});
    double app=1;
    bool yes=false;
    while(!q.empty()){
        int cp=q.front().first;
        double num=q.front().second;
        if(cp==st && num>app && ceil(num)==num){
            yes=true;
            break;
        }
        q.pop();
        for(int j=0;j<adj[cp].size();j++){
            pair <int,double>i=adj[cp][j];
            double sum=i.second*num;
            if(sum<=value[i.first]) continue;
            value[i.first]=sum;
            q.push({i.first,i.second*num});
        }
    }
    if(yes)cout<<"YA";else cout<<"NAW";
}
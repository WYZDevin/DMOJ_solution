#include <bits/stdc++.h>
#define pll pair<long long ,long long>
#define INF 0x3f3f3f3f3f3f3f3f
#define ll long long
using namespace std;
int N,src;
vector<pll> edge;
vector<ll> ans;
ll dis[3003];
bool vist[3004];

long long cdis(pll a,pll b){
    return (a.first-b.first)*(a.first-b.first)+(a.second-b.second)*(a.second-b.second);
}

void dijkstra(){
    while(true){
        ll mindis=INF;
        int p = -1;
        for(int i=0;i<N;i++)
            if(!vist[i] && dis[i]<mindis)
                p=i,mindis=dis[i];
        if(p==-1)break;
        vist[p]=true;
        for(int i=0;i<N;i++){
            if(i!=p){
                if(dis[i]>dis[p]+cdis(edge[i],edge[p])){
                    dis[i]=dis[p]+cdis(edge[i],edge[p]);
                }
            }
        }
    }

}
int main()
{
    scanf("%d",&N);
    for(int i=0;i<N;i++){
        ll a,b;
        scanf("%lld %lld",&a,&b);
        edge.push_back({a,b});
    }
    scanf("%d",&src);
    src--;
    pll srn=edge[src];
    memset(dis, 0x3f3f3f3f, sizeof(dis));
    dis[src]=0;
    dijkstra();
    for(int i=0;i<N;i++)
        ans.push_back(dis[i]);
    sort(ans.begin(),ans.end());
    int k;
    scanf("%d",&k);
    for(int i=0;i<k;i++){
        ll d;
        scanf("%lld",&d);
        printf("%d\n",upper_bound(ans.begin(),ans.end(),d)-ans.begin());
    }

}
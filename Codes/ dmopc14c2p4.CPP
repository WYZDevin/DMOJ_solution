#include <bits/stdc++.h>
    using namespace std;
    int l[1000003];
    int ll[1000003];

    int N,Q;
    int main()
    {
       scanf("%d",&N);
        for(int i=1,h;i<=N;i++){
            scanf("%d",&h);
            l[i]=h;
            ll[i]=l[i]+ll[i-1];
        }
        scanf("%d",&Q);
        for(int i=0;i<Q;i++){
            int x,y;
            scanf("%d %d",&x,&y);
            printf("%d\n",ll[y+1]-ll[x]);
        }
    }
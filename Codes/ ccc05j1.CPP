#include <bits/stdc++.h>
#define pii pair<int,int>
using namespace std;

int main()
{
    int d,n,w;
    scanf("%d %d %d",&d,&n,&w);
    double pa=0,pb=0;
    if(d-100>0)pa+=(d-100)*0.25;
    pa+=n*0.15;
    pa+=w*0.2;

    if(d-250>0)pb+=(0.45*(d-250));
    pb+=0.35*n;
    pb+=0.25*w;
    printf("Plan A costs %.2f\n",pa);
    printf("Plan B costs %.2f\n",pb);
    if(pa>pb)
        printf("Plan B is cheapest.\n");
    else if(pb>pa)
        printf("Plan A is cheapest.\n");
    else
        printf("Plan A and B are the same price.\n");
}
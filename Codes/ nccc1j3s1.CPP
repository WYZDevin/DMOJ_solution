#include <bits/stdc++.h>
using namespace std;

int main(){
    int k,p,x;
    scanf("%d %d %d",&k,&p,&x);
    double m = sqrt((double)k*p/x);
    printf("%.3f\n",min(ceil(m)*x+k*p/ceil(m),floor(m)*x+k*p/floor(m)));
}
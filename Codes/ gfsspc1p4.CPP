#include <bits/stdc++.h>
    using namespace std;
    bool f[502];
    int fib[502];
    int fibo(int x)
    {
        if(x==1 || x==0)return 1;
        if(fib[x]>0)return fib[x];
        int l=fibo(x-1)+fibo(x-2);
        fib[x]=l;
        return l;
    }
    int N;
    int main()
    {
        fibo(16);
        f[1]=true;
        fib[0]=1;
        fib[1]=1;
        scanf("%d",&N);
        char l[N];
        bool check=false;
        scanf("%s",l);
        for(int i=0;i<14;i++)
            f[fib[i]]=true;

        for(int i=0;i<N;i++){
            if(f[i+1] && l[i]!='A')
                check=true;
            if(l[i]=='A'){
                if(!f[i+1])
                    check=true;
            }
        }
        if(check)
            printf("Bruno, GO TO SLEEP");
        else
            printf("That's quite the observation!");

    }
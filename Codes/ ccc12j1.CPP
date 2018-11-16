#include <bits/stdc++.h>
using namespace std;
int limit,speed;
int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>limit>>speed;
    int ans=speed-limit;
    if(ans<=0)printf("Congratulations, you are within the speed limit!");
    else if(ans<=20){
        printf("You are speeding and your fine is $100.");
    }else if(ans<=30){
        printf("You are speeding and your fine is $270.");
    }else{
        printf("You are speeding and your fine is $500.");
    }
}
#include <bits/stdc++.h>
#define ll long long
using namespace std;
const int MAXN=3000009;
ll N,M;
ll nums[MAXN];
deque<ll>maxx,minn;
ll cnt=0;
int main(){
    cin>>N>>M;
    for(int i=0;i<N;i++)
        cin>>nums[i];
    ll l=0,r=0;
    for(;r<N;r++){
        ll cur=nums[r];
        while(!maxx.empty() && cur>maxx.back()){
            maxx.pop_back();
        }
        maxx.push_back(cur);
        while(!minn.empty()&&cur<minn.back()){
            minn.pop_back();
        }
        minn.push_back(cur);
        if(maxx.front()-minn.front()<=M){
            cnt+=r-l+1;
        }else{
            while(maxx.front()-minn.front()>M){
                int o=nums[l];
                if(maxx.front()==o)maxx.pop_front();
                if(minn.front()==o)minn.pop_front();
                l++;
            }
            cnt+=r-l+1;
        }
    }
    cout<<cnt;
}
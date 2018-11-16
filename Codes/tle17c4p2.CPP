#include <bits/stdc++.h>
using namespace std;
#define MAXN 300010
#define pii pair<int,int>
#define ll long long
int A1,A2,A3,tot;
vector<int> FUCK;
vector<int>nums;
unordered_map<int,pii>m;
char bs[11];
using namespace std;
int main() {
    scanf("%d:%d:%d",&A1,&A2,&A3);
    scanf("%s",&bs);
    for(int i=0;i<strlen(bs);i++){
        nums.push_back(bs[i]-'0');
    }
    for(int i:nums) {
        for (int j:nums) {
            m[i * 10 + j] = {i, j};
            FUCK.push_back(i * 10 + j);
        }
    }
    tot=A1*3600+A2*60+A3;
    int a1,a2,a3;
    int diff= 0x3f3f3f3f;
    for(int i:FUCK){
        for(int j:FUCK){
            for(int k:FUCK){
                int summ=i*3600+j*60+k;
                if(abs(tot-summ)<diff){
                    diff=abs(tot-summ);
                    a1=i,a2=j,a3=k;
                }
            }
        }
    }
    printf("%d%d:%d%d:%d%d",m[a1].first,m[a1].second,m[a2].first,m[a2].second,m[a3].first,m[a3].second);
//    printf("%d:%d:%d",a1,a2,a3);
}
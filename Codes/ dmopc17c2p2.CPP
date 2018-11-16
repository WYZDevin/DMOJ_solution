#include <bits/stdc++.h>
using namespace std;
int main()
{
    string s;
    cin>>s;
    int st=0;
    bool use=false,ok=true;
    for(char i:s){
        if(i=='('){
            st++;
        }else{
            if(st==0){
                if(!use) {
                    st++;
                    use = true;
                }else{
                    ok=false;
                }
            }else {
                st--;
            }
        }
    }
    if(ok && (st==0 || (st==2&&!use)))cout<<"YES";
    else cout<<"NO";
}
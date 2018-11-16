#include<bits/stdc++.h>

using namespace std;
int M, N;
string a[100], b[100];
bool ans = false;
stack<int> s;

bool rec(int cur, string a1, string b1) {
    if (ans)return true;
    if (a1 == b1 && a1!="") {
        int sz=s.size();
        printf("%d\n", sz);
        ans=true;
        stack<int> s2;
        for(int i=0;i<sz;i++) {
            int ss = s.top();
            s2.push(ss);
            s.pop();
        }
        for(int i=0;i<sz;i++){
            printf("%d\n",s2.top());
            s2.pop();
        }
        return true;
    }
    if (cur >M) {
        return false;
    }
    for (int i = 0; i < N; i++) {
        s.push(i+1);
        rec(cur+1,a1+a[i],b1+b[i]);
        if(ans)
            return true;
        s.pop();
    }
    return false;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin >> M >> N;
    for (int i = 0; i < N; i++)
        cin >> a[i];
    for (int i = 0; i < N; i++)
        cin >> b[i];
    rec(0,"","");
    if(!ans){
        printf("No solution.");
    }
}
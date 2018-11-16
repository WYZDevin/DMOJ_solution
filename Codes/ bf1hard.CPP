#include <bits/stdc++.h>

using namespace std;

int main() {
    int a;
    cin >>a;
    int b[a];
    for (int i = 0; i <a ; ++i) {
        cin>>b[i];
    }
    sort(b,b+a);
    for (int j = 0; j < a; ++j) {
        cout<< b[j]<<endl;
    }
    return 0;
}
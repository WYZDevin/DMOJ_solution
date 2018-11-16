//: CCC2009S5
// Wireless
#include <bits/stdc++.h>
using namespace std;

int M,N,K,x,y,R,B;
int A[30001];
int C[1000];
int D[1000];
int E[1000];
int F[1000];
int z = 0;
int w = 0;
int main() {
    cin >> N
        >> M
        >> K;
    for(int i=0; i<K; i++) {
        cin >> x >> y >> R >> B;
        C[i] = x;
        D[i] = y;
        E[i] = R;
        F[i] = B;
    }
    for(int i=1; i<=M; i++) {
        if(i == 1) {
            for(int j=0; j<K; j++) {
                int c = pow(E[j],2) - pow(abs(C[j]-i),2);
                if(c >= 0) {
                    int a = floor(sqrt(c));
                    for(int k=max(1,D[j]-a); k<=min(N,D[j]+a); k++) {
                        A[k] = A[k] + F[j];
                    }
                }
            }
        }
        else {
            for(int j=0; j<K; j++) {
                int c = pow(E[j],2) - pow(abs(C[j]-i),2);
                if(c >= 0) {
                    int d = pow(E[j],2) - pow(abs(C[j]-i+1),2);
                    if(d >= 0) {
                        int a = floor(sqrt(c));
                        int b = floor(sqrt(d));
                        if(a >= b) {
                            for(int k=max(1,D[j]+b+1); k<=min(N,D[j]+a); k++) {
                                A[k] = A[k] + F[j];
                            }
                            for(int k=max(1,D[j]-a); k<=min(N,D[j]-b-1); k++) {
                                A[k] = A[k] + F[j];
                            }
                        }
                        else {
                            for(int k=max(1,D[j]+a+1); k<=min(N,D[j]+b); k++) {
                                A[k] = A[k] - F[j];
                            }
                            for(int k=max(1,D[j]-b); k<=min(N,D[j]-a-1); k++) {
                                A[k] = A[k] - F[j];
                            }
                        }
                    }
                    else {
                        int a = floor(sqrt(c));
                        for(int k=max(1,D[j]-a); k<=min(N,D[j]+a); k++) {
                            A[k] = A[k] + F[j];
                        }
                    }
                }
                else {
                    int d = pow(E[j],2) - pow(abs(C[j]-i+1),2);
                    if(d >= 0) {
                        A[D[j]] = A[D[j]] - F[j];
                    }
                }
            }
        }
        for(int j=1; j<=N; j++) {
            if(A[j] > z) {
                z = A[j];
                w = 1;
            }
            else {
                if(A[j] == z) {
                    w++;
                }
            }
        }
    }
    cout << z << endl;
    cout << w << endl;
}
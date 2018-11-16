#include <bits/stdc++.h>
using namespace std;
int arr [1000040];
int N;
int main(){
    scanf("%d",&N);
    for(int i = 0 ; i < N ; i ++)
        scanf("%d",&arr[i]);
    printf("0 ");
    for(int i = 1 ; i < N ; i ++){
        int j =  i - 1 , ans = 0;
        while(true){
            ans ++ ;
            if(arr[j] > arr[i]) break;
            j --;
            if(j < 0)break;
        }
        printf("%d ",ans);
    }
}
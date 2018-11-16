// Example program
#include <iostream>
#include <string>
using namespace std;
int arr[110];
bool taken[110];
int main()
{
    int k,n,a;
  scanf("%d",&k);
  for(int i = 1 ; i <= k ; i ++){
    arr[i] = i;
    taken[i] = true;
  }
    scanf("%d",&n);
    for(int j = 0 ; j < n ; j++){
        scanf("%d",&a);
        int cnt = 0;
        for(int i = 1 ; i <= k ; i++){
            if(taken[i] == false){
                continue;
            }
            cnt = cnt + 1;
            if(cnt%a == 0){
                taken[i] = false;
                cnt = 0;
            }
        }
    }
    for(int i = 1 ; i <= k ; i ++){
        if(taken[i] == true){
            printf("%d\n",arr[i]);
        }
    }
  

}
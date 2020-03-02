#include <iostream>

using namespace std;

char arr[7];

void go(int cnt, int n){
	// 종료
	if(cnt == n){
		printf("%s\n", arr);
		return;
	}
	
	// 재귀
	arr[cnt] = 'O';
	go(cnt+1, n);
	arr[cnt] = 'X';
	go(cnt+1, n);		
	 
}

int main(int argc, char **argv)
{
	int n;
	scanf("%d", &n);
	
	go(0, n);
    return 0;
}
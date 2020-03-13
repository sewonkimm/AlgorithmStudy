#include <iostream>

using namespace std;

long long int tri[51][51];

int main(int argc, char **argv)
{
	int n;
	scanf("%d", &n);
	
	// 파스칼 삼각형 만들기 
	for(int i=1; i<=n; i++){
		for(int j=1; j<=i; j++){
			
			// 맨 첫번째, 맨 마지막 요소는 1 
			if(j == 1 || j == i){
				tri[i][j] = 1;
				continue;
			}
			
			// 나머지 요소 
			tri[i][j] = tri[i-1][j] + tri[i-1][j-1];
		}
	}
	
	// print
	for(int i=1; i<=n; i++){
		for(int j=1; j<=i; j++){
			printf("%lld ", tri[i][j]); 
		}
		printf("\n");
	}
	
    return 0;
}
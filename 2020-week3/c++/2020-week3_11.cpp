#include <iostream>

using namespace std;

static char map[10000][10000];

void isStar(int x, int y, int n){
	int m = n/3;
	
	if(n == 1){
		map[x][y] = '*';
	}
	else {
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				
				// 가운데 빈 칸 
				if(i == 1 && j == 1){
					continue;
				}
				
				isStar(m*i+x, m*j+y, m);
			}
		}
	}
}

int main() {
	int N;
	scanf("%d", &N);
	
	// 공백으로 초기화 
	for(int i=0;i<N; i++){
		for(int j=0; j<N; j++){
			map[i][j] = ' ';
		}
	}
	
	// 별찍기 실행 
	isStar(0, 0, N);
	
	// 출력 
	for(int i=0;i<N; i++){
		for(int j=0; j<N; j++){
			printf("%c", map[i][j]);
		}
		printf("\n");
	}
	
	return 0;
}
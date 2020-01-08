#include <iostream>

using namespace std;

char chess[51][51];

string white[8] = {
		{ "WBWBWBWB" },
		{ "BWBWBWBW" },
		{ "WBWBWBWB" },
		{ "BWBWBWBW" },
		{ "WBWBWBWB" },
		{ "BWBWBWBW" },
		{ "WBWBWBWB" },
		{ "BWBWBWBW" }
	};

string black[8] = {
		{ "BWBWBWBW" },
		{ "WBWBWBWB" },
		{ "BWBWBWBW" },
		{ "WBWBWBWB" },
		{ "BWBWBWBW" },
		{ "WBWBWBWB" },
		{ "BWBWBWBW" },
		{ "WBWBWBWB" }
	};

int whiteCnt(int x, int y){
	int block = 0;
	for(int i=x; i<x+8; i++){
		for(int j=y; j<y+8; j++){
			if(chess[i][j] != white[i-x][j-y]){
				block++;
			}
		}
	}
	return block;
}

int blackCnt(int x, int y){
	int block = 0;
	for(int i=x; i<x+8; i++){
		for(int j=y; j<y+8; j++){
			if(chess[i][j] != black[i-x][j-y]){
				block++;
			}
		}
	}
	return block;
}
int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			scanf("%1s", &chess[i][j]);
		}
	}	
	// 브루트포스
	int ans = 100;
	for(int i=0; i<n-7; i++){
		for(int j=0; j<m-7; j++){
			int x = whiteCnt(i, j);
			if(blackCnt(i, j) < x){
				x = blackCnt(i, j);
			} 
				
			if(x < ans){
				ans = x;
			}
		}
	}
	
	printf("%d\n", ans);
	return 0;
}
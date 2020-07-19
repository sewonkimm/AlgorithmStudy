#include <iostream>

using namespace std;

int n, m;
int answer;
int dp[301][301];

int slice(int x, int y){
	if(x == 1){
		return y-1;
	}
	
	if(y == 1){
		return x-1;
	}
	
	if(x > y){
		return {slice(x-1, y) + dp[1][y] + 1};
	}
	else {
		return {slice(x, y-1) + dp[x][1] + 1};
	}
}

int main(int argc, char** argv) {
	// input
	cin >> n >> m;
	
	// 초기 설정 
	for(int i=1; i<=n; i++){
		dp[i][1] = i-1;
	}
	for(int j=1; j<=m; j++){
		dp[1][j] = j-1;
	}

	// 계산
	answer = slice(n, m);
	cout << answer;
	return 0;
}
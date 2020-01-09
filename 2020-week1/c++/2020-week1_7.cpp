#include <iostream>
#include <vector>

using namespace std;

int dp[501][501];

int main() {
	int n;
	scanf("%d", &n);
	
	vector<vector<int> > tri(n, vector<int>());
	
	for(int i=0; i<n; i++){
		for(int j=0; j<=i; j++){
			int x;
			scanf("%d", &x);
			tri[i].push_back(x);
		}
	}
	
	dp[0][0] = tri[0][0];
	for(int i=1; i<n; i++){
		for(int j=0; j<=i; j++){
			
			// 맨 첫번째 
			if(j == 0){
				dp[i][j] = dp[i-1][j] + tri[i][j];
			}
			// 맨 마지막 요소
			else if(j == i){
				dp[i][j] = dp[i-1][j-1] + tri[i][j];
			}
			// 중간 요소 
			else {
				if(dp[i-1][j-1] > dp[i-1][j]){
					dp[i][j] = dp[i-1][j-1] + tri[i][j];
				}
				else {
					dp[i][j] = dp[i-1][j] + tri[i][j];
				}
			}
		}
	}
	
	
	int answer = dp[n-1][0];
	for(int i=1; i<n; i++){
		if(answer < dp[n-1][i]){
			answer = dp[n-1][i];
		} 
	}
	printf("%d\n", answer);
	
	return 0;
}
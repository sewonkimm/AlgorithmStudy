#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	vector< pair<int, int> > lines;
	while(n--){
		int a, b;
		scanf("%d %d", &a, &b);
		lines.push_back(make_pair(a, b));
	}
	
	sort(lines.begin(), lines.end());
	vector<int> dp;
	for(int i=0; i<lines.size(); i++){
		dp.push_back(0);
	}
	
	for(int i=0; i<lines.size(); i++){
		int m = 0;
		for(int j=0 ; j<i; j++){
			if(lines[i].second > lines[j].second){
				m = max(dp[j], m);
			}
		}
		dp[i] = m+1; 
	}
	
	int ans = 0;
	for(int i=0; i<dp.size(); i++){
		ans = max(ans, dp[i]);
	}
	printf("%d\n", lines.size()-ans);
	return 0;
}
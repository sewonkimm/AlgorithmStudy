#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n, k;
	scanf("%d %d", &n, &k);
	
	vector<int> money(n, 0);
	for(int i=0; i<n; i++){
		scanf("%d", &money[i]);
	}
	
	int cnt = 0;
	
	// 가장 큰 동전부터 사용
	while(k > 0){
		for(int i=n-1; i>=0; i--){
			cnt += k/money[i];
			k %= money[i]; 
		}
	} 
	printf("%d", cnt);
	return 0;
}
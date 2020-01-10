#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	
	vector<int> p(n, 0);
	for(int i=0; i<n; i++){
		scanf("%d", &p[i]);
	}
	
	// 오름차순 정렬 
	sort(p.begin(), p.end());
	
	int ans=0;
	for(int i=0; i<n; i++){
		for(int j=0; j<=i; j++){
			ans+=p[j];
		}
	}
	printf("%d\n", ans);
	
	return 0;
}
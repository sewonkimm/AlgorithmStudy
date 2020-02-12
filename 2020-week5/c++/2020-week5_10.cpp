#include <iostream>
#include <vector>

using namespace std;

int n, m;
vector<int> ans;

void getArr(int cnt){
	if(cnt == m){
		for(int i=0; i<ans.size(); i++){
			printf("%d ", ans[i]);
		}
		printf("\n");
		return;
	}
	
	for(int i=0; i<n; i++){
		ans.push_back(i+1);
		getArr(cnt+1);
		ans.pop_back();
	}
}

int main() {
	
	// input
	scanf("%d %d", &n, &m);
	
	getArr(0);
	return 0;
}
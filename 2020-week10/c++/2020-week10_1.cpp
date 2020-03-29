#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char **argv){
	
	// input
	int n;
	scanf("%d", &n);
	
	vector< pair<int, int> > arr;
	for(int i=0; i<n; i++){
		int x, y;
		scanf("%d %d", &x, &y);
		
		arr.push_back(make_pair(x, y));
	}
	
	sort(arr.begin(), arr.end());
	
	for(int i=0; i<n; i++){
		printf("%d %d\n", arr[i].first, arr[i].second);
	}
	
	return 0;
}
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
	
	// input
	int n;
	scanf("%d", &n);
	
	vector< vector<int> > arr(n, vector<int>(2, 0));
	for(int i=0; i<n; i++){
		scanf("%d %d", &arr[i][0], &arr[i][1]);
	}
	
	// 덩치 큰 사람 구하기 
	vector<int> rank(n, 1);
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			if(i == j)	continue;
			
			if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
				rank[i]++;
			}
		}
	}
	
	// print 
	for(int i=0; i<n; i++){
		cout << rank[i] << endl;
	}
	return 0;
}
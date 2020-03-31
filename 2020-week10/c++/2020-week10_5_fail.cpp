// 시간초과
// 브루트 포스로 다 때려박지 말고, 수학적 사고를 해보는게 어떨까요?
// 유클리드 호제법  
  
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char **argv){
	
	// input
	int n;
	cin >> n;
	
	vector<int> nums;
	for(int i=0; i<n; i++){
		int x;
		cin >> x;
		nums.push_back(x);
	} 
	sort(nums.begin(), nums.end());
	
	// 탐색
	for(int i=2; i<=nums[n-1]; i++){
		
		int result = nums[0] % i;
		bool isSame = true;
		for(int j=1; j<nums.size(); j++){
			int temp = nums[j] % i;
			
			if(result != temp){
				isSame = false;
				break;
			}
		}
		
		if(isSame){
			cout << i << " ";
		}
	} 
	
	return 0;
}
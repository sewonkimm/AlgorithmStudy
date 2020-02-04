#include <iostream>
#include <vector>

using namespace std;

int getNum(int n){
	vector<int> nums;
	while(n > 0){
		nums.push_back(n%10);
		n /= 10;
	}
	
	if(nums[0]-nums[1] == nums[1]-nums[2]){
		return 1;
	}
	else {
		return 0;
	}
}

int main() {
	
	int n;
	scanf("%d", &n);
	
	int ans = 0;
	if(n <= 99){
		ans = n;
	}
	else if(n == 1000){
		ans = 99;
		for(int i=100; i<1000; i++){
			if(getNum(i) != 0)	ans++;
		}
	}
	else {
		ans = 99;
		for(int i=100; i<=n; i++){
			if(getNum(i) != 0)	ans++;
		}	
	}
	
	printf("%d\n", ans);
	return 0;
}
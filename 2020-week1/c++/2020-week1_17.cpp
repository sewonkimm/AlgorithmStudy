#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	
	priority_queue< int, vector<int>, greater<int> > minh;
	priority_queue< int, vector<int>, less<int> > maxh;
	
	for(int i=0; i<n; i++){
		int x;
		scanf("%d", &x);
		
		// max heap 크기는 항상 min heap 크기와 같거나 하나 더 크다.
		// max heap의 첫번째 값은 min heap 첫번째 값보다 작거나 같다. 
		if(maxh.empty()){
			maxh.push(x);
		}
		else if(maxh.size() == minh.size()){
			maxh.push(x);
		}
		else {
			minh.push(x);
		}
		
		// 중간값 출력 
		if(!maxh.empty() && !minh.empty() && !(maxh.top() <= minh.top())){
			int a = maxh.top();
			int b = minh.top();
			
			maxh.pop();
			minh.pop();
			maxh.push(b);
			minh.push(a);
		}
		
		printf("%d\n", maxh.top());	
	}
	return 0;
}
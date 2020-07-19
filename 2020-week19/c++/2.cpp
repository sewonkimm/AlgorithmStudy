#include <iostream>
#include <vector>

using namespace std;

int n, m;

void getSequence(int index, int count, vector<int> check){
	// 종료 조건 
	if(count == m){
		for(int i=0; i<check.size(); i++){
			cout << check[i] << " ";
		}
		cout << "\n";
		return;
	}
	
	if(index <= n){
		check.push_back(index);
		getSequence(index, count+1, check);
		
		check.pop_back();
		getSequence(index+1, count, check);
	}	

}

int main(int argc, char** argv) {
	// input
	cin >> n >> m;
	
	// 백트래킹 
	vector<int> check;
	getSequence(1, 0, check);	
	
	return 0;
}
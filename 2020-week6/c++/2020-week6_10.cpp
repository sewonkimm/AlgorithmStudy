#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool isLucky(string str){
	
	for(int i=0; i<str.size()-1; i++){
		if(str[i] == str[i+1]){
			return false;
		}
	}
	return true;
}

int main() {
	
	string str;
	cin >> str;
	
	int ans = 0;
	sort(str.begin(), str.end());
	
	do{
		// 문자열 판별 
		if(isLucky(str)){
			ans++;
		}
	}while(next_permutation(str.begin(), str.end()));
	
	cout << ans << endl;
	return 0;
}
#include <iostream>
#include <string>

using namespace std;

bool isNum(int n){
	string str = to_string(n);
	for(int i=0; i<str.size(); i++){
		if(str[i] != '4' && str[i] != '7'){
			return 0;
		}
	}	
	return 1;
}

int main(int argc, char** argv) {
	// input
	int n;
	cin >> n;
	
	for(int i=n; i>=4; i--){
		if(isNum(i)){
			cout << i;
			return 0;
		}
		else continue;
	}
}
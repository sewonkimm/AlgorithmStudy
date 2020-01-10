#include <iostream>
#include <string>

using namespace std;

int main() {
	string str;
	cin >> str;
	
	bool minus = false;
	int ans = 0;
	string temp;
	for(int i=0; i<=str.size(); i++){
		
		if(str[i] == '+' || str[i] == '-' || str[i] == '\0'){
			if(minus){
				ans -= stoi(temp);
			}
			else {
				ans += stoi(temp);
			}
			temp = "";
		}
		
		if(str[i] == '-'){
			minus = true;
			continue;
		}
		
		temp += str[i];
	}
	
	cout << ans << endl;
	return 0;
}
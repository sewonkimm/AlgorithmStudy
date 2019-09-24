#include <iostream>
#include <string>

using namespace std;

int main() {
	int n;
	cin >> n;
	
	int count = 0;
	int num = 666;
	int answer = 0;
	while (count < n) {
		string str = to_string(num);
		if (str.find("666", 0) != string::npos) {
			count++;
			answer = num;
		}
		num++;
	}

	cout << answer << endl;

	return 0;
}
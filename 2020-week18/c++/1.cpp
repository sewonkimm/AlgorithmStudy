#include <algorithm>
#include <iostream>
#include <vector>
#include <string>
#include <tuple>

using namespace std;

int n;
vector<tuple<int, int, string>> members;

int main(int argc, char** argv) {
	cin >> n;
	for(int i=0; i<n; i++){
		int age;
		string name;
		cin >> age >> name;
		
		members.push_back(make_tuple(age, i, name));
	}
	
	sort(members.begin(), members.end());
	
	for(int i=0; i<n; i++){
		cout << get<0>(members[i]) << " " << get<2>(members[i]) << "\n";
	}
	return 0;
}

// "\n"을 "endl"으로 적으면 시간초과
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// sort 
int comp(const string &s1, const string &s2){
	
	// 사이즈가 같으면 사전순 
	if(s1.size() == s2.size()){
		return s1 < s2;
	}
	
	// 사이즈가 작은 순 
	return s1.size() < s2.size();
} 

int main() {
	
	int n;
	scanf("%d", &n);
	
	vector<string> words;
	
	while(n--){
		string str;
		cin >> str;
		words.push_back(str);	
	}
	
	// 1. 정렬
	sort(words.begin(), words.end(), comp);
		
	vector<string> dup;
	for(int i=0; i<words.size(); i++){
		
		// 2. 중복 제거
		bool isDup = false;
		for(int k=0; k<dup.size(); k++){
			if(dup[k] == words[i]){
				isDup = true;
				break;
			}
		}
		
		if(!isDup){
			printf("%s\n", words[i].c_str());
			dup.push_back(words[i]);
		}
	}
	
	return 0;
}
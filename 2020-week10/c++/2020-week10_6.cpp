#include <iostream>
#include <string>
#include <vector>

using namespace std;

string dial[8] = { {"ABC"},		// 2
				   {"DEF"},		// 3
				   {"GHI"}, 	// 4
				   {"JKL"}, 	// 5
				   {"MNO"},		// 6
				   {"PQRS"},	// 7
				   {"TUV"},		// 8
				   {"WXYZ"},	// 9
				 };

int main(int argc, char **argv){
	
	// input
	string str;
	cin >> str;
	
	int answer = 0;
	
	// 탐색
	for(char ch : str){
		for(int i=0; i<8; i++){
			for(int j=0; j<dial[i].size(); j++){
				if(dial[i][j] == ch){
					answer += (i+3);
					break;
				}
			}
		}
	} 
	
	cout << answer;
	return 0;
}
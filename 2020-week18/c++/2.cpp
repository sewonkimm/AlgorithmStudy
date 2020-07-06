#include <iostream>
#include <vector>
#include <string>

using namespace std;

int count = 0;
 
int main(int argc, char** argv) {
	
	// input 
	int n = 0;
	cin >> n;
	
	vector<int> nums;
	vector<int> strikes;
	vector<int> balls;
	
	for(int i=0; i<n; i++){
		int num, strike, ball;
		cin >> num >> strike >> ball;
		
		nums.push_back(num);
		strikes.push_back(strike);
		balls.push_back(ball);
	}
	
	// 123~987까지 탐색 
	int x=123;
	while(x <= 987){
		string str_x = to_string(x);		
		
		// 세자리 수가 중복일 경우 | 0이 들어가는 경우 =>  통과
		if(str_x[0]==str_x[1] || str_x[1]==str_x[2] || str_x[0]==str_x[2]){
			x++;
			continue;
		}	
		if(str_x[0]=='0' || str_x[1]=='0' || str_x[2]=='0'){
			x++;
			continue;
		}
		
		// 탐색 시작 
		bool isNum = true;
		for(int i=0; i<n; i++){
			string str_input = to_string(nums[i]);
			
			int st=0;
			int ba=0;
			
			for(int a=0; a<3; a++){
				for(int b=0; b<3; b++){
					if(str_x[a] == str_input[b]){
						if(a == b){
							st++;
						}
						else {
							ba++;
						}
					}
				}
			}
			
			if(st != strikes[i] || ba != balls[i]){
				isNum = false;
			}
		}
		
		if(isNum){
			count++;
		}
		
		x++;
	}
	
	cout << count;
	return 0;
}
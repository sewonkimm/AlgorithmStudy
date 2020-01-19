#include <iostream>
#include <string>
#include <deque>

using namespace std;

int main() {
	int t;
	scanf("%d", &t);
	
	while(t--){
		// 입력 
		string cmd;
		cin >> cmd;
		
		int n;
		scanf("%d", &n);
		deque<int> dq;
		
		string arr;
		cin >> arr;
		string temp = "";
		for(int i=0; i<arr.size(); i++){
			if(arr[i] == '['){
				continue;
			}
			else if(arr[i] == ']' || arr[i] == ','){
				if(temp != ""){
					dq.push_back(stoi(temp));
				}
				temp = "";
			}
			else {
				temp += arr[i];
			}
		}
		
		// 명령어 수행
		bool isFirst = true;
		bool error = false;
		for(int i=0; i<cmd.size(); i++) {
			if(cmd[i] == 'R'){
				isFirst = !isFirst;
			}
			else if(cmd[i] == 'D'){
				if(dq.empty()){
					error = true;
					break;
				}
				
				if(isFirst){
					dq.pop_front();
				}
				else{
					dq.pop_back();
				}
			}
		}
		
		if(error){
			printf("error\n");
		}
		else {
			printf("[");
			if(isFirst){
				while(!dq.empty()){
					if(dq.size() == 1){
						printf("%d", dq.front());
					}
					else {
						printf("%d,", dq.front());
					}
					dq.pop_front();
				}
			}
			else {
				while(!dq.empty()){
					if(dq.size() == 1){
						printf("%d", dq.back());
					}
					else {
						printf("%d,", dq.back());
					}
					dq.pop_back();
				}
			}
			printf("]\n");
		}
	}
	
	
	return 0;
}
// 메모리초과

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
vector< vector<int> > answer;

void go(int count, vector<int> num, vector<int> array){
	if(count == m){
		// Add to array
		answer.push_back(array); 
		return;
	}
	
	for(int i=0; i<n; i++){
		array.push_back(num[i]);
		go(count+1, num, array);
		array.pop_back();
	}
}

void deleteDuplication(vector< vector<int> > array){
	
	for(int k=0; k<m; k++){
    	printf("%d ", answer[0][k]);
	}
	printf("\n");
	vector<int> temp = array[0];
	
	for(int i=1; i<array.size(); i++){
		if(array[i] == temp){
			continue;
		}
		
		for(int k=0; k<m; k++){
    		printf("%d ", answer[i][k]);
		}
		printf("\n");
		
		temp = array[i];
	}
}

int main(int argc, char **argv){
	
	// input
    scanf("%d %d", &n, &m);
    
    vector<int> num(n, 0);
    for(int i=0; i<n; i++){
    	scanf("%d", &num[i]);
	}
	sort(num.begin(), num.end());
    
    // calculate
    vector<int> array;
    go(0, num, array);
    
    // print
    
    for(int i=0; i<answer.size(); i++){
    	sort(answer[i].begin(), answer[i].end());
	}
	sort(answer.begin(), answer.end());
	deleteDuplication(answer);
    
    
	return 0;
}
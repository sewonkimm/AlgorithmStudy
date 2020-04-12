#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool pass(int x, vector<int> stones, int k){
    
    // 0의 연속이 k보다 크거나 같으면 pass 불가
    int count = 0;
    for (int i = 0; i < stones.size(); i++) {
        if (stones[i] - x <= 0){
            count++;
        }
        else{
            count = 0;
        }
        
        // 종료
        if (count >= k)
            return false;
    }
    return true;
}

int solution(vector<int> stones, int k) {
    int left = 0;
    int right = 0;
    
    for(int s : stones){
        right = max(right, s);
    }
    
    while(left <= right){
        int mid = (left+right) / 2;
        if(pass(mid, stones, k)){
            // 통과하면 좌측 탐색
            left = mid+1;
        }
        else {
            // 통과 못하면 우측 탐색
            right = mid-1;
        }
    }
    
    return left;
}
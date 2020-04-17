#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int getBudgets(int left, int right, vector<int> budgets, int M){
    int tmp = 0;
    
    while(left <= right){      
        long long sum = 0;       
        int mid = (left+right)/2;
        
        for(int bg:budgets){            
            bg > mid ? sum += mid : sum += bg;
        }
        
        if(sum > M){
            right = mid-1;
        }
        else {
            left = mid+1;
            tmp = max(tmp, mid);
        }
    }
    return tmp;
}
int solution(vector<int> budgets, int M) {
    
    sort(budgets.begin(), budgets.end(), greater<int>());
    
    int left = 0;
    int right = budgets[0];
    return getBudgets(left, right, budgets, M);
}
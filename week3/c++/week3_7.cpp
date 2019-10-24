#include <string>
#include <vector>
using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    
    // retrun 행렬 크기는 row*col
    int row = arr1.size();
    int col = arr2[0].size();
    
    vector<vector<int>> answer(row, vector<int>(col, 0));
        
    for(int i=0; i<row; i++){
        
        vector<int> arr;
        for(int j=0; j<col; j++){
            int sum = 0;
            for(int k=0; k<arr1[i].size(); k++){
                sum += arr1[i][k]*arr2[k][j];
            }
            arr.push_back(sum);
        }
        answer[i] = arr;
    }
    return answer;
}
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> answer;

// 원판1~n을 x로부터 y로 이동
void move(int n, int x, int y){

    vector<int> hanoi(2, 0);

    if(n > 1){
        // 그룹을 시작 기둥에서 중간기둥으로 옮김
        // 중간기둥 = 6-x-y
        move(n-1, x, 6-x-y);
    }

    // 밑 바닥 원판을 목표기둥으로 옮김
    hanoi[0] = x;
    hanoi[1] = y;
    answer.push_back(hanoi);

    if(n > 1){
        // 그룹을 중간기둥에서 목표 기둥으로 옮김
        move(n-1, 6-x-y, y);
    }
}

vector<vector<int>> solution(int n) {
    move(n, 1, 3);
    return answer;
}
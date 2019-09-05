#include <string>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int solution(vector<int> priorities, int location) {

    queue<pair<int, int>> q;
    // 큐에 인쇄 문서 넣기
    for(int i=0; i<priorities.size(); i++){
        q.push(make_pair(i, priorities[i]));
    }

    while(true) {
        tuple <int, int> now = q.front();

        // 맨 첫번째 문서보다 중요도가 높은 문서가 있는지 검색
        int find = true;
        queue<pair<int, int>> temp = q;
        temp.pop();
        while(!temp.empty()){
            if(temp.front().second <= get<1>(now)) {
                temp.pop();
            }
            // 중요도 높은 문서 발견
            else {
                q.pop();
                q.push(make_pair(get<0>(now), get<1>(now)));
                find = false;
                break;
            }
        }

        // 중요도 높은 문서 발견하지 못했으면 반복문 종료
        if(find == true)    break;
    }

    int answer = 1;
    while(!q.empty()){
        if(q.front().first != location){
            q.pop();
            answer++;
        }
        else {
            return answer;
        }

    }
}
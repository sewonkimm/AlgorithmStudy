/*
1. queries 탐색
2. query 1개를 탐색할 때마다 words를 돌면서 탐색
    - word가 해당 query와 매치되는지 검사
    - 매치되면 갯수 카운트
3. 카운트를 result에 넣어줌

매치 검사 logic
0. 문자 길이 먼저 검사
1. 문자열 탐색
2. 알파벳이 같을 경우 통과
3. 알파벳이 다를 경우 탐색 종료
4. 와일드카드 문자는 무조건 통과
*/

#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;
    
    for(string query: queries){
        int count = 0;
        
        for(string word: words){
            bool flag = true;
            if(query.size() != word.size()) continue;
            
            for(int i=0; i<query.size(); i++){
                if(query[i] == '?')     continue;
                
                if(query[i] != word[i]){
                    flag = false;
                    break;
                }
            }
            
            if(flag)    count++;
        }
        
        answer.push_back(count);
    }
    return answer;
}
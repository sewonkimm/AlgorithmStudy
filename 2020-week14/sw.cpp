// map => list로 변경
// 초기 설정 부분을 제거

#include <list>
#include <string>
#include <vector>
#include <cctype>
#include <algorithm>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    
    int answer = 0;
    list<string> cache;
    
    // 대소문자 구분 x
    for(int i=0; i<cities.size(); i++){
        transform(cities[i].begin(), cities[i].end(), cities[i].begin(), ::tolower);
    }
    
    // cacheSize = 0 일 때
    if(cacheSize == 0){
        answer = 5*cities.size();
        return answer;
    }
    
    // 탐색 시작
    for(int i=0; i<cities.size(); i++) {
        
        // 겹치는 게 있는지 검사
        if(find(cache.begin(), cache.end(), cities[i]) != cache.end()){
            // cache hit
            answer += 1;
            cache.erase(find(cache.begin(), cache.end(), cities[i]));
            cache.push_back(cities[i]);
        }
        else {
            // cache miss
            answer += 5;
            
            if(cache.size() >= cacheSize){
                cache.pop_front();
                cache.push_back(cities[i]);
            }
            else {
                cache.push_back(cities[i]);
            }
            
        }
    }
    
    return answer;
}
// queue 가 나을까 map 이 나을까?
// 정확성: 80.0
// 합계: 80.0 / 100.0

#include <map>
#include <string>
#include <vector>
#include <cctype>
#include <algorithm>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    
    int answer = 0;
    map<int, string> cache;
    
    // 대소문자 구분 x
    for(int i=0; i<cities.size(); i++){
        transform(cities[i].begin(), cities[i].end(), cities[i].begin(), ::tolower);
    }
    
    // cacheSize = 0 일 때
    if(cacheSize == 0){
        answer = 5*cities.size();
        return answer;
    }
    
    // 초기 설정
    int index;
    for(index=0; index<cacheSize; index++){
        cache.insert(make_pair(index, cities[index]));
        answer += 5;
    }
    
    // 나머지 탐색
    while(index < cities.size()){
        // 큐에 겹치는 게 있는지 검사
        bool hit = false;
        map<int, string>::iterator iter;
        for(iter=cache.begin(); iter != cache.end(); iter++){
            
            // cache hit
            if(iter->second == cities[index]){   
                hit = true;
                answer += 1;
                cache.erase(iter++);                
                break;
            }
        }
        
        // cache miss
        if(hit == false){
            answer += 5;
            cache.erase(cache.begin());
        }
        cache.insert(make_pair(index, cities[index]));
        index++;        
    }
    
    return answer;
}
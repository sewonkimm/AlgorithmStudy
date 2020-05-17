#include <map>      // 사전 구현
#include <string>
#include <vector>

using namespace std;

vector<int> solution(string msg) {
    
    vector<int> answer;
    map<string, int> dict;
    string key = "A";   // A~Z까지 사전 초기화
    for(int i=1; i<=26; i++){
        dict[key] = i;
        key = (char)('A'+i);
    }
    
    // msg 처리
    int w = 0;
    int c = 0;
    map<string, int>::iterator found;
    
    while(c < msg.size()){
        string curr = "";
        curr += msg[w];
        string before = "";
        
        // w가 마지막 일 경우
        if(c == msg.size()-1){
            answer.push_back(dict.find(curr)->second);
            break;
        }
        
        for(c = w+1; c < msg.size(); c++){
            before = curr;
            curr += msg[c];
            found = dict.find(curr);
            
            if(found != dict.end()){   // 사전에 有
                if(c == msg.size()-1){
                    answer.push_back(dict.find(curr)->second);
                    continue;
                }
            }
            else {  // 사전에 無
                answer.push_back(dict.find(before)->second);
                int k = dict.size();
                dict[curr] = k+1;

                w = c;
                break;
            }
        }
    }
    
    
    return answer;
}
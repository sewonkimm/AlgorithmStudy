#include <string>
#include <vector>
#include <stack>

// substr(a, b) : a부터 b길이만큼 반환

using namespace std;

bool isRight(string p){
    stack<char> st;
    for(int i=0; i<p.size(); i++){
        if(p[i] == '('){
            st.push(p[i]);
        }
        else{
            if(st.empty()){
                return false;
            }
            st.pop();
        }
    }
    
    if(st.empty()){
        return true;
    }
    else {
        return false;
    }
}

string solution(string p) {
    
    // 올바른 문자열이면 종료
    if(isRight(p)){
        return p;
    }
    
    // 올바른 문자열이 아닌경우u, v로 분리
    string u = "";
    string v = "";    
    string answer = "";
    
    int Lcnt = 0;
    int Rcnt = 0;
    
    // 2
    for(int i=0; i<p.size(); i++){
        if(p[i] == '('){
            Lcnt++;    
        }
        else{
            Rcnt++;
        }
        
        if(Lcnt == Rcnt){
            u = p.substr(0, Lcnt+Rcnt);
            v = p.substr(Lcnt+Rcnt, p.size() - (Lcnt+Rcnt));
            break;
        }
        
    }
    
    // 3
    if(isRight(u)){
        answer += u;
        string temp = solution(v);
        answer += temp;
    }
    
    // 4
    else {
        // 4-1
        string str1 = "(";
        
        // 4-2
        string str2 = solution(v);
        str1 += str2;
        
        // 4-3
        str1 += ")";
        
        // 4-4
        string str3 = u.substr(1, u.size()-2);  // 1번째부터 끝까지 반환
        for(int k=0; k<str3.size(); k++){
            if(str3[k] == '('){
                str1 += ')';
            }
            else {
                str1 += '(';
            }
        }
        
        answer = str1;
    }
    
    return answer;
}
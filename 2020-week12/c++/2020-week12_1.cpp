#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes)
{

    // cloth count
    map<string, int> m;
    for (int i = 0; i < clothes.size(); i++)
    {
        m[clothes[i][1]]++;
    }

    vector<int> list;
    for (auto iter = m.begin(); iter != m.end(); iter++)
    {
        list.push_back(iter->second);
    }

    // 모든 경우의 수
    int answer = 1;
    for (int x : list)
    {
        answer *= (x + 1);
    }
    return answer - 1;
}
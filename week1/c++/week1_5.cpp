#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> answer;

bool dfs(string from, vector<vector<string>> tickets, vector<bool> check, int cnt)
{
    answer.push_back(from);

    // dfs 종료
    if (cnt == tickets.size())
    {
        return true;
    }

    for (int i = 0; i < tickets.size(); i++)
    {
        if (tickets[i][0] == from && check[i] == false)
        {

            check[i] = true;

            // 이어지는 경로가 있는지 확인
            bool success = dfs(tickets[i][1], tickets, check, cnt + 1);
            // 이어지는 경로가 있을 때
            if (success)
            {
                return true;
            }

            // 이어지는 경로가 없을 때 취소하고 다른 경로 찾기
            check[i] = false;
        }
    }

    answer.pop_back();
    return false;
}

vector<string> solution(vector<vector<string>> tickets)
{

    sort(tickets.begin(), tickets.end());

    vector<bool> check(tickets.size(), false);

    // 인천부터 시작
    string from = "ICN";
    dfs(from, tickets, check, 0);

    return answer;
}
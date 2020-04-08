#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<string>> str;
int answer = 0;

bool isSame(string banned, string user)
{
    for (int i = 0; i < user.size(); i++)
    {

        if (banned[i] == '*')
        {
            continue;
        }

        if (banned[i] != user[i])
        {
            return false;
        }
    }
    return true;
}

void find(vector<string> user_id, vector<string> banned_id, int index, vector<int> visited)
{
    if (index >= banned_id.size())
    {

        // 배열에 집어 넣기
        vector<string> arr;
        for (int i = 0; i < visited.size(); i++)
        {
            if (visited[i])
            {
                arr.push_back(user_id[i]);
            }
        }
        str.push_back(arr);

        return;
    }

    for (int i = 0; i < user_id.size(); i++)
    {

        if (!visited[i] && user_id[i].size() == banned_id[index].size())
        {

            if (isSame(banned_id[index], user_id[i]))
            {
                visited[i] = 1;
                find(user_id, banned_id, index + 1, visited);
                visited[i] = 0;
            }
        }
    }
}

int solution(vector<string> user_id, vector<string> banned_id)
{

    vector<int> visited(user_id.size(), 0);
    find(user_id, banned_id, 0, visited);

    // 중복되는 배열 삭제
    sort(str.begin(), str.end());
    vector<string> last;
    for (int i = 0; i < str.size(); i++)
    {
        if (last != str[i])
        {
            last = str[i];
            answer++;
        }
    }

    return answer;
}
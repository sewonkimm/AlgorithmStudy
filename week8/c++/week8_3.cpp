#include <string>
#include <vector>
#include <queue>
#include <math.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds)
{

    queue<int> q;

    for (int i = 0; i < progresses.size(); i++)
    {
        q.push(ceil((100 - progresses[i]) / speeds[i]));
    }

    vector<int> answer;
    while (!q.empty())
    {
        int n = q.front();
        int cnt = 1;
        q.pop();

        while (!q.empty() && q.front() <= n)
        {
            cnt++;
            q.pop();
        }
        answer.push_back(cnt);
    }

    return answer;
}
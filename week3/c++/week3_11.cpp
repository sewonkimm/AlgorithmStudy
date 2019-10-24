#include <string>
#include <vector>
#include <deque>
#include <algorithm>
#include <sstream>

using namespace std;

vector<int> solution(vector<string> operations)
{
    vector<int> answer;

    deque<int> q;

    for (int i = 0; i < operations.size(); i++)
    {
        stringstream ss(operations[i]);

        string command;
        string num;
        ss >> command >> num;

        if (command == "I")
        {
            q.push_back(stoi(num));
            sort(q.begin(), q.end(), greater<int>());
        }
        else if (command == "D" && !q.empty())
        {
            if (num == "1")
            {
                q.pop_front();
            }
            else if (num == "-1")
            {
                q.pop_back();
            }
        }
    }

    if (q.empty())
    {
        answer.push_back(0);
        answer.push_back(0);
    }
    else
    {
        answer.push_back(q.front());
        answer.push_back(q.back());
    }

    return answer;
}
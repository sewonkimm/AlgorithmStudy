#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool visit[100001];

int cmp(vector<int> a, vector<int> b)
{
    return a.size() < b.size();
}

vector<int> solution(string s)
{

    vector<vector<int>> nums;
    vector<int> temp;
    string num = "";
    bool isNum = false;
    // 맨 앞&맨 뒤 대괄호 제외
    for (int i = 1; i < s.size() - 1; i++)
    {
        if (s[i] == '{')
        {
            num = "";
            isNum = true;
        }
        else if (s[i] == '}')
        {
            temp.push_back(stoi(num));
            nums.push_back(temp);
            temp.clear();
            isNum = false;
        }
        else if (s[i] == ',' && isNum)
        {
            temp.push_back(stoi(num));
            num = "";
        }
        else
        {
            num += s[i];
        }
    }

    // 집합 길이대로 정렬
    sort(nums.begin(), nums.end(), cmp);

    // 튜플 원소 구하기
    vector<int> answer;
    for (int i = 0; i < nums.size(); i++)
    {
        for (int j = 0; j < nums[i].size(); j++)
        {
            if (!visit[nums[i][j]])
            {
                visit[nums[i][j]] = true;
                answer.push_back(nums[i][j]);
            }
        }
    }

    return answer;
}
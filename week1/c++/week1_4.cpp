#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int target)
{

    vector<vector<int>> d(numbers.size(), vector<int>());

    d[0].push_back(numbers[0]);
    d[0].push_back(numbers[0] * (-1));

    for (int i = 1; i < numbers.size(); i++)
    {
        for (int j = 0; j < d[i - 1].size(); j++)
        {
            d[i].push_back(d[i - 1][j] + numbers[i]);
            d[i].push_back(d[i - 1][j] - numbers[i]);
        }
    }

    // 정답 출력
    int answer = 0;
    int len = numbers.size();
    for (int i = 0; i < d[len - 1].size(); i++)
    {
        if (d[len - 1][i] == target)
        {
            answer++;
        }
    }
    return answer;
}
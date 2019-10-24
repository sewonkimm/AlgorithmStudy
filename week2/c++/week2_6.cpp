#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int d[501][10000];

int solution(vector<vector<int>> triangle)
{

    // DP bottom-up
    for (int i = 0; i < triangle.size(); i++)
    {
        for (int j = 0; j < i + 1; j++)
        {

            if (i == 0)
            {
                d[i][j] += triangle[i][j];
            }

            else
            {
                if (j == 0)
                {
                    d[i][j] = d[i - 1][j] + triangle[i][j];
                }
                else if (j == i)
                {
                    d[i][j] = d[i - 1][j - 1] + triangle[i][j];
                }
                else
                {
                    d[i][j] = max(d[i - 1][j], d[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }
    }

    // 맨 마지막 줄 d[i][j]의 최댓값
    int answer = d[triangle.size() - 1][0];
    for (int i = 1; i < triangle.size(); i++)
    {
        if (answer < d[triangle.size() - 1][i])
        {
            answer = d[triangle.size() - 1][i];
        }
    }

    return answer;
}
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> routes)
{

    sort(routes.begin(), routes.end());

    // 카메라는 최소 1대
    int answer = 1;

    // 카메라 설치 위치
    int pos = routes[0][1];
    for (int i = 0; i < routes.size() - 1; i++)
    {
        if (pos > routes[i][1])
        {
            pos = routes[i][1];
        }

        if (pos < routes[i + 1][0])
        {
            answer++;
            pos = routes[i + 1][1];
        }
    }

    return answer;
}
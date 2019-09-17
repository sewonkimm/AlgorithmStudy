#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int d[101][100001];

int solution(int K, vector<vector<int>> travel)
{

    int answer = 0;

    // 방문해야 하는 도시의 수 city
    int city = travel.size();

    d[0][travel[0][0]] = travel[0][1];
    d[0][travel[0][2]] = travel[0][3];

    // bottom-up
    for (int i = 1; i < city; i++)
    {
        for (int j = 0; j <= K; j++)
        {
            if (d[i - 1][j] == 0)
                continue;

            // 도보로 갈 경우
            if (j + travel[i][0] <= K)
            {
                d[i][j + travel[i][0]] = d[i - 1][j] + travel[i][1];
                answer = max(answer, d[i][j + travel[i][0]]);
            }
            // 자전거로 갈 경우
            if (j + travel[i][2] <= K)
            {
                d[i][j + travel[i][2]] = max(d[i][j + travel[i][2]], d[i - 1][j] + travel[i][3]);
                answer = max(answer, d[i][j + travel[i][2]]);
            }
        }
    }

    return answer;
}
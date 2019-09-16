#include <string>
#include <vector>

using namespace std;

int d[101][101];
int visit[101][101];

int solution(int m, int n, vector<vector<int>> puddles)
{
    // 물에 잠긴 지역은 갈 수 없도록 표시
    for (int k = 0; k < puddles.size(); k++)
    {
        visit[puddles[k][1]][puddles[k][0]] = -1;
    }

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {

            // 시작지점 1 저장
            if (i == 1 && j == 1)
            {
                d[i][j] = 1;
                continue;
            }

            // 물웅덩이 부분
            if (visit[i][j] == -1)
                continue;

            // 물웅덩이가 아닌 부분
            if (visit[i - 1][j] != -1 && i - 1 > 0)
            {
                d[i][j] = d[i - 1][j] % 1000000007;
            }
            if (visit[i][j - 1] != -1 && j - 1 > 0)
            {
                d[i][j] += d[i][j - 1] % 1000000007;
            }
        }
    }

    return d[n][m] % 1000000007;
}
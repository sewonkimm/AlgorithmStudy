#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> land)
{

    for (int i = 0; i < land.size() - 1; i++)
    {
        land[i + 1][0] += max(max(land[i][1], land[i][2]), land[i][3]);
        land[i + 1][1] += max(max(land[i][0], land[i][2]), land[i][3]);
        land[i + 1][2] += max(max(land[i][0], land[i][1]), land[i][3]);
        land[i + 1][3] += max(max(land[i][0], land[i][1]), land[i][2]);
    }

    int n = land.size() - 1;
    int answer = max(max(land[n][0], land[n][1]), max(land[n][2], land[n][3]));
    return answer;
}
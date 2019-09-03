#include <string>
#include <vector>

using namespace std;

bool check[201];

void dfs(int x, vector<vector<int>> a)
{
    check[x] = true;

    for (int i = 0; i < a[x].size(); i++)
    {
        if (a[x][i] == 1 && check[i] == false)
        {
            dfs(i, a);
        }
    }
}

int solution(int n, vector<vector<int>> computers)
{
    int answer = 0;

    for (int i = 0; i < n; i++)
    {
        if (check[i] == false)
        {
            dfs(i, computers);
            answer++;
        }
    }

    return answer;
}
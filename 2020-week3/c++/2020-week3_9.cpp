#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int map[30][30];
int d[30][30];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int find(int i, int j, int cnt, int n)
{

    d[i][j] = 1;

    for (int a = 0; a < 4; a++)
    {
        int nx = i + dx[a];
        int ny = j + dy[a];

        if (nx >= 0 && nx < n && ny >= 0 && ny < n)
        {
            if (map[nx][ny] == 1 && d[nx][ny] == 0)
            {
                cnt = find(nx, ny, cnt + 1, n);
            }
        }
    }

    return cnt;
}

int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%1d", &map[i][j]);
        }
    }

    vector<int> ans;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (map[i][j] == 1 && d[i][j] == 0)
            {
                ans.push_back(find(i, j, 1, n));
            }
        }
    }

    sort(ans.begin(), ans.end());
    printf("%d\n", ans.size());
    for (int k = 0; k < ans.size(); k++)
    {
        printf("%d\n", ans[k]);
    }

    return 0;
}
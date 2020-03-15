#include <iostream>
#include <algorithm>

using namespace std;

int candy[101][101];
int d[101][101];

int main()
{

    // input
    int n, m;
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d", &candy[i][j]);
        }
    }

    // calculate
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {

            if (i == 0 && j == 0)
            {
                d[i][j] = candy[i][j];
            }
            else if (i == 0)
            {
                d[i][j] = d[i][j - 1] + candy[i][j];
            }
            else if (j == 0)
            {
                d[i][j] = d[i - 1][j] + candy[i][j];
            }
            else
            {
                d[i][j] = max(d[i - 1][j], d[i][j - 1]) + candy[i][j];
            }
        }
    }

    // print
    printf("%d", d[n - 1][m - 1]);

    return 0;
}
#include <iostream>
#include <algorithm>

using namespace std;

int w[101];
int v[101];
int d[101][100001];

int main(void)
{
    int n, k;
    cin >> n >> k;

    for (int i = 1; i <= n; i++)
    {
        cin >> w[i] >> v[i];
    }

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= k; j++)
        {
            d[i][j] = d[i - 1][j];

            if (j - w[i] >= 0)
            {
                d[i][j] = max(d[i][j], d[i - 1][j - w[i]] + v[i]);
            }
        }
    }

    cout << d[n][k] << endl;

    return 0;
}
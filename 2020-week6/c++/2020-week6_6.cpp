#include <iostream>

long long int d[101][10];

using namespace std;

int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
    {

        // 길이가 1인 계단수
        if (i == 1)
        {
            for (int j = 1; j <= 9; j++)
            {
                d[i][j] = 1;
            }
            continue;
        }

        // 길이가 1이상인 계단수
        for (int j = 0; j <= 9; j++)
        {

            if (j - 1 >= 0)
            {
                d[i][j] += d[i - 1][j - 1];
            }
            if (j + 1 <= 9)
            {
                d[i][j] += d[i - 1][j + 1];
            }

            d[i][j] %= 1000000000;
        }
    }

    long long int ans = 0;
    for (int i = 0; i <= 9; i++)
    {
        ans += d[n][i];
    }

    ans %= 1000000000;
    cout << ans << endl;
    return 0;
}
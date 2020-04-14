#include <stdio.h>

using namespace std;

long long dp[100001][3];

int main()
{

    // input
    int n;
    scanf("%d", &n);

    // dp[i] : i번째 줄에 배치하는 경우의 수
    for (int i = 1; i <= n; i++)
    {
        if (i == 1)
        {
            dp[1][0] = 1;
            dp[1][1] = 1;
            dp[1][2] = 1;
            continue;
        }

        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
    }

    long long answer = (dp[n][0] + dp[n][1] + dp[n][2]) % 9901;
    printf("%lld\n", answer);

    return 0;
}
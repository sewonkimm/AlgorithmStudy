#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    scanf("%d", &T);

    for (test_case = 1; test_case <= T; ++test_case)
    {
        int n;
        scanf("%d", &n);
        vector<int> a(n);
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &a[i]);
        }

        vector<int> dp(n);
        dp[0] = a[0];
        for (int i = 1; i < n; i++)
        {
            dp[i] = max(dp[i - 1] + a[i], dp[i - 1] * a[i]);
        }

        printf("#%d %d\n", test_case, dp[n - 1]);
    }
    return 0;
}
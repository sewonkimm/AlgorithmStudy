#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char **argv)
{
    int n;
    cin >> n;
    vector<int> score(n + 1, 0);
    for (int i = 1; i <= n; i++)
    {
        cin >> score[i];
    }

    vector<int> dp(n + 1, 0);
    dp[1] = score[1];
    dp[2] = dp[1] + score[2];

    for (int i = 3; i <= n; i++)
    {
        dp[i] = max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
    }

    cout << dp[n] << endl;
    return 0;
}
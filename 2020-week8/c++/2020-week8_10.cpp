#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char **argv)
{

    int a, b, k;
    scanf("%d %d %d", &a, &b, &k);

    vector<int> dp(b + 1, 0);
    for (int i = a; i <= b; i++)
    {

        int temp = i;
        while (temp)
        {
            if (temp % 10 == k)
            {
                dp[i]++;
            }
            temp /= 10;
        }
    }

    int ans = 0;
    for (int i = a; i <= b; i++)
    {
        ans += dp[i];
    }

    if (b == 0 && k == 0)
    {
        ans = 1;
    }
    printf("%d", ans);

    return 0;
}
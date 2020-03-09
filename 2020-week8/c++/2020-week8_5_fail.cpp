// 시간초과 fail

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char **argv)
{

    int n, k;
    scanf("%d %d", &n, &k);

    vector<int> c(n, 0);
    for (int i = 0; i < k; i++)
    {
        c[i] = 1;
    }
    sort(c.begin(), c.end());

    int ans = 0;
    do
    {
        bool isOK = true;
        for (int i = 0; i < n - 1; i++)
        {
            if (c[i] && c[i + 1])
            {
                isOK = false;
            }
        }

        if (isOK)
        {
            ans++;
        }

    } while (next_permutation(c.begin(), c.end()));

    printf("%d\n", ans);

    return 0;
}
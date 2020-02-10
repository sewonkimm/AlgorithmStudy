#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char **argv)
{

    int n, m;
    scanf("%d %d", &n, &m);

    vector<int> card(n, 0);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &card[i]);
    }

    // n개중 3개 뽑기
    vector<int> com(n, 0);
    for (int i = 0; i < 3; i++)
    {
        com[i] = 1;
    }
    sort(com.begin(), com.end());

    int ans = 0;
    do
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            if (com[i] == 0)
            {
                continue;
            }

            sum += card[i];
        }

        if (sum > ans && sum <= m)
        {
            ans = sum;
        }
    } while (next_permutation(com.begin(), com.end()));

    printf("%d\n", ans);
    return 0;
}
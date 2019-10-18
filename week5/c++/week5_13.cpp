#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
    int n, m;
    cin >> n >> m;

    vector<int> card(n + 1);
    for (int i = 0; i < n; i++)
    {
        cin >> card[i];
    }

    vector<int> com(n);
    for (int i = 0; i < 3; i++)
    {
        com[i] = 1;
    }
    for (int i = 3; i < n; i++)
    {
        com[i] = 0;
    }
    sort(com.begin(), com.end());

    int output = 0;
    do
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            if (com[i] == 1)
            {
                sum += card[i];
            }
            else
            {
                continue;
            }
        }

        if (sum <= m)
        {
            output = max(sum, output);
        }
    } while (next_permutation(com.begin(), com.end()));

    cout << output;
    return 0;
}
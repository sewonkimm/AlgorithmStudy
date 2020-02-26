#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int n, k;
    cin >> n >> k;

    vector<int> c(n + 1, 0);
    for (int i = 1; i <= n; i++)
    {
        cin >> c[i];
    }
    sort(c.begin(), c.end());

    vector<int> d(k + 1, 0);
    d[0] = 1;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= k; j++)
        {

            if (j >= c[i])
            {
                d[j] += d[j - c[i]];
            }
        }
    }

    cout << d[k] << endl;

    return 0;
}
#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
    int n;
    cin >> n;

    vector<int> d(n + 1, 0);
    for (int i = 0; i <= n; i++)
    {
        if (i == 0)
        {
            d[i] = 1;
            continue;
        }

        if (i == 1)
        {
            d[i] = 1;
            continue;
        }

        d[i] = (d[i - 1] + d[i - 2]) % 15746;
    }

    cout << d[n] << endl;

    return 0;
}
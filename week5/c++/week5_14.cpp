#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);

    for (int i = 0; i < n; i++)
    {
        int price;
        cin >> price;

        coins[i] = price;
    }

    reverse(coins.begin(), coins.end());

    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        ans += k / coins[i];
        k %= coins[i];
    }

    cout << ans << endl;

    return 0;
}
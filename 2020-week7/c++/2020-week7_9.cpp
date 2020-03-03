#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char **argv)
{

    int n, k;
    cin >> n >> k;

    vector<int> com(n, 0);
    for (int i = 0; i < k; i++)
    {
        com[i] = 1;
    }
    sort(com.begin(), com.end());

    int ans = 0;
    do
    {
        ans++;
    } while (next_permutation(com.begin(), com.end()));

    cout << ans;

    return 0;
}
#include <iostream>

using namespace std;

long long int p[101];

int main(void)
{

    int t;
    cin >> t;

    p[1] = p[2] = p[3] = 1;
    p[4] = 2;

    while (t--)
    {
        int n;
        cin >> n;

        if (p[n] != 0)
        {
            cout << p[n] << endl;
            continue;
        }

        for (int i = 5; i <= n; i++)
        {
            p[i] = p[i - 1] + p[i - 5];
        }
        cout << p[n] << endl;
    }

    return 0;
}
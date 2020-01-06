#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n;
    cin >> n;

    vector<long long int> fibo(n + 1, 0);
    if (n <= 1)
    {
        fibo[n] = n;
    }
    else
    {
        fibo[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }

    cout << fibo[n] << endl;
    return 0;
}
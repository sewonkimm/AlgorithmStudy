#include <iostream>
#include <algorithm>

using namespace std;

int d[1000001];

int cal(int n)
{
    if (n == 1)
    {
        return 0;
    }

    if (d[n] > 0)
    {
        return d[n];
    }
    else
    {
        int temp = cal(n - 1);
        if (n > 1 && d[n] == 0)
        {
            if (n % 3 == 0)
            {
                temp = min(temp, cal(n / 3));
            }

            if (n % 2 == 0)
            {
                temp = min(temp, cal(n / 2));
            }
        }

        d[n] = temp + 1;
    }

    return d[n];
}
int main(int argc, char **argv)
{

    int n;
    cin >> n;

    cout << cal(n) << endl;
    return 0;
}
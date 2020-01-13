#include <iostream>

using namespace std;

int main(int argc, char **argv)
{
    int n;
    cin >> n;

    int cnt = 0;
    while (1)
    {
        if (n % 5 == 0)
        {
            cnt += n / 5;
            break;
        }

        n -= 3;
        cnt++;

        if (n < 0)
        {
            cout << "-1\n";
            return 0;
        }
    }

    cout << cnt << endl;
    return 0;
}
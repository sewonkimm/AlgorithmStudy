#include <iostream>
#include <algorithm>

using namespace std;

int cal(int n)
{
    int sum = 0;

    while (n / 10 > 0)
    {
        sum += n % 10;
        n /= 10;
    }
    sum += n;
    return sum;
}

int main(int argc, char **argv)
{
    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        int num[10];
        for (int i = 0; i < 10; i++)
        {
            cin >> num[i];
            num[i] = cal(num[i]);
        }

        int maxN, minN;
        maxN = -10000;
        minN = 100000;
        for (int i = 0; i < 10; i++)
        {
            maxN = max(maxN, num[i]);
            minN = min(minN, num[i]);
        }

        cout << "#" << test_case << " ";
        cout << maxN << " " << minN << endl;
    }
    return 0;
}
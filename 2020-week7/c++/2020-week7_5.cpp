#include <iostream>

using namespace std;

int arr[8] = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

int main(int argc, char **argv)
{

    int n;
    cin >> n;

    int cnt = 0;
    int i = 0;
    while (n > 0)
    {
        cnt += n / arr[i];
        n %= arr[i];
        i++;
    }

    cout << cnt;
    return 0;
}
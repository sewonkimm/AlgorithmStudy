#include <iostream>

using namespace std;

int main(void)
{

    int n;
    cin >> n;

    int sum = 0;
    while (n--)
    {
        char num;
        cin >> num;

        sum += (num - 48);
    }
    cout << sum << endl;
}
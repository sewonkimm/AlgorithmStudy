#include <iostream>

using namespace std;

int main(int argc, char **argv)
{
    int a, b, c;
    cin >> a >> b >> c;

    if (b >= c)
    {
        cout << "-1\n";
    }
    else
    {
        cout << a / (c - b) + 1 << endl;
    }

    return 0;
}
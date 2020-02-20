#include <iostream>
#include <string>

using namespace std;

int main()
{
    string a, b;
    cin >> a >> b;

    int diff = 51;
    for (int i = 0; i < b.size() - a.size() + 1; i++)
    {
        int temp = 0;

        for (int j = 0; j < a.size(); j++)
        {
            if (b[i + j] != a[j])
            {
                temp++;
            }
        }

        if (diff > temp)
        {
            diff = temp;
        }
    }

    cout << diff << endl;
    return 0;
}
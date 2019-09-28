#include <iostream>
#include <cstring>
#include <string>

using namespace std;

int main(void)
{
    int n;
    cin >> n;

    int count = 0;
    while (n--)
    {
        string str;
        cin >> str;

        bool d[26];
        memset(d, false, sizeof(d));

        bool isGroup = true;
        for (int i = 0; i < str.length(); i++)
        {
            int index = str[i] - 97;
            if (d[index] == false)
            {
                d[index] = true;
            }
            else if (d[index] == true && str[i] == str[i - 1])
            {
                continue;
            }
            else
            {
                isGroup = false;
                break;
            }
        }

        if (isGroup)
        {
            count++;
        }
    }

    cout << count << endl;

    return 0;
}
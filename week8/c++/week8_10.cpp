#include <iostream>
#include <string>

using namespace std;

int main()
{
    string n;
    cin >> n;

    int cnt = 1;
    int check[10];
    for (int i = 0; i < 10; i++)
    {
        check[i] = 1;
    }

    for (int i = 0; i < n.size(); i++)
    {
        int num = n[i] - '0';

        if (num == 6 && check[num] == 0)
        {
            if (check[9] != 0)
            {
                check[9] -= 1;
            }
            else
            {
                cnt++;
                for (int i = 0; i < 10; i++)
                {
                    check[i] += 1;
                }
                check[num] -= 1;
            }
            continue;
        }
        else if (num == 9 && check[num] == 0)
        {
            if (check[6] != 0)
            {
                check[6] -= 1;
            }
            else
            {
                cnt++;
                for (int i = 0; i < 10; i++)
                {
                    check[i] += 1;
                }
                check[num] -= 1;
            }
            continue;
        }

        if (check[num] == 0)
        {
            cnt++;
            for (int i = 0; i < 10; i++)
            {
                check[i] += 1;
            }
        }
        check[num] -= 1;
    }

    cout << cnt << endl;
    return 0;
}
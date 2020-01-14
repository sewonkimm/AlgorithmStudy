#include <iostream>
#include <string>

using namespace std;

bool check(string ps)
{

    int size = ps.size();
    int num = 0;

    // 길이가 홀수면 VPS 아님
    if (size % 2 != 0)
    {
        return false;
    }

    if (ps[size - 1] == '(' || ps[0] == ')')
    {
        return false;
    }
    else
    {
        for (int i = 0; i < size; i++)
        {
            if (ps[i] == '(')
            {
                num++;
            }
            else
            {
                if (num == 0)
                {
                    return false;
                }
                else
                {
                    num--;
                }
            }
        }
    }

    if (num == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

int main(int argc, char **argv)
{
    int t;
    cin >> t;

    while (t--)
    {
        string ps;
        cin >> ps;

        if (check(ps))
        {
            cout << "YES" << endl;
        }
        else
        {
            cout << "NO" << endl;
        }
    }
    return 0;
}
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char **argv)
{
    string str;
    getline(cin, str);

    int cnt = 0;
    for (int i = 0; i < str.size(); i++)
    {

        if (i == 0 && str[i] == ' ')
        {
            continue;
        }
        else if (i == str.size() - 1)
        {
            cnt++;
            break;
        }

        if (str[i] == ' ')
        {
            cnt++;
        }
    }

    cout << cnt << endl;
    return 0;
}
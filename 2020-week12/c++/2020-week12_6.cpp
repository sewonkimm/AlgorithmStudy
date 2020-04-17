#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
    int n;
    cin >> n;

    vector<string> str;
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        str.push_back(s);
    }

    string answer = "";
    int index = 0;
    while (index < str[0].size())
    {
        char tmp = str[0][index];
        bool isSame = true;
        for (int i = 1; i < n; i++)
        {
            if (str[i][index] != tmp)
            {
                answer += '?';
                isSame = false;
                break;
            }
        }

        if (isSame)
        {
            answer += tmp;
        }
        index++;
    }

    cout << answer;

    return 0;
}

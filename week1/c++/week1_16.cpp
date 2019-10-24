#include <string>

using namespace std;

bool solution(string s)
{
    int a = 0;
    int b = 0;
    bool answer = true;

    for (int i = 0; i < s.length(); i++)
    {
        if (a < b)
        {
            answer = false;
            break;
        }

        if (s[i] == '(')
            a++;
        else
            b++;
    }

    if (a != b)
    {
        answer = false;
    }

    return answer;
}
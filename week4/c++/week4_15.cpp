#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(void)
{

    while (1)
    {
        string in;
        getline(cin, in);

        // 종료
        if (in.length() == 1 && in[0] == '.')
        {
            break;
        }

        // 판단
        stack<char> bracket;
        bool isRight = true;
        for (int i = 0; i < in.length(); i++)
        {
            if (in[i] == '(' || in[i] == '[')
            {
                bracket.push(in[i]);
            }
            else if (in[i] == ')')
            {
                if (!bracket.empty() && bracket.top() == '(')
                {
                    bracket.pop();
                }
                else
                {
                    isRight = false;
                    break;
                }
            }
            else if (in[i] == ']')
            {
                if (!bracket.empty() && bracket.top() == '[')
                {
                    bracket.pop();
                }
                else
                {
                    isRight = false;
                    break;
                }
            }
        }

        if (isRight && bracket.empty())
        {
            cout << "yes" << endl;
        }
        else
        {
            cout << "no" << endl;
        }
    }
    return 0;
}
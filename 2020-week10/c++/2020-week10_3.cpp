#include <iostream>
#include <string>

using namespace std;

string alpha[8] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

int main()
{

    // input
    string str;
    cin >> str;

    // 검사
    int answer = 0;
    for (int i = 0; i < str.size(); i++)
    {
        switch (str[i])
        {
        case 'c':
        {
            if (str[i + 1] == '=' || str[i + 1] == '-')
            {
                answer++;
                i++;
                break;
            }

            answer++;
            break;
        }

        case 'd':
        {
            if (str[i + 1] == '-')
            {
                answer++;
                i++;
                break;
            }
            if (str[i + 1] == 'z' && str[i + 2] == '=')
            {
                answer++;
                i += 2;
                break;
            }
            answer++;
            break;
        }

        case 'l':
        {
            if (str[i + 1] == 'j')
            {
                answer++;
                i++;
                break;
            }
            answer++;
            break;
        }

        case 'n':
        {
            if (str[i + 1] == 'j')
            {
                answer++;
                i++;
                break;
            }
            answer++;
            break;
        }

        case 's':
        {
            if (str[i + 1] == '=')
            {
                answer++;
                i++;
                break;
            }
            answer++;
            break;
        }

        case 'z':
        {
            if (str[i + 1] == '=')
            {
                answer++;
                i++;
                break;
            }
            answer++;
            break;
        }

        default:
        {
            answer++;
            break;
        }
        }
    }

    cout << answer;
    return 0;
}
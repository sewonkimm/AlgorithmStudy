#include <iostream>
#include <string>

using namespace std;

int main(void)
{

    string in;
    cin >> in;

    int sum = 0;
    for (int i = 0; i < in.length(); i++)
    {

        switch (in[i])
        {
        case 'c':
            if (in[i + 1] == '=' || in[i + 1] == '-')
            {
                sum += 1;
                i++;
                break;
            }

            sum += 1;
            break;

        case 'd':
            if (in[i + 1] == 'z' && in[i + 2] == '=')
            {
                sum += 1;
                i += 2;
                break;
            }
            else if (in[i + 1] == '-')
            {
                sum += 1;
                i++;
                break;
            }

            sum += 1;
            break;

        case 'l':
            if (in[i + 1] == 'j')
            {
                sum += 1;
                i++;
                break;
            }

            sum += 1;
            break;

        case 'n':
            if (in[i + 1] == 'j')
            {
                sum += 1;
                i++;
                break;
            }

            sum += 1;
            break;

        case 's':
            if (in[i + 1] == '=')
            {
                sum += 1;
                i++;
                break;
            }

            sum += 1;
            break;

        case 'z':
            if (in[i + 1] == '=')
            {
                sum += 1;
                i++;
                break;
            }

            sum += 1;
            break;

        default:
            sum += 1;
            break;
        }
    }

    cout << sum << endl;

    return 0;
}
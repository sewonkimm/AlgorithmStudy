#include <iostream>
#include <string>

using namespace std;

int main(void)
{

    string sen;
    getline(cin, sen);

    int count = 0;
    for (int i = 0; i < sen.length(); i++)
    {

        if (i == 0 && sen[i] == ' ')
        {
            continue;
        }
        else if (i == sen.length() - 1 && sen[i] == ' ')
        {
            count++;
            break;
        }
        else if (i == sen.length() - 1 && sen[i] != ' ')
        {
            count++;
            break;
        }

        if (sen[i] == ' ')
        {
            count++;
        }
    }

    cout << count << endl;
    return 0;
}
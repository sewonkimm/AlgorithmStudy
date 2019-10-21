#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        for (int k = 1; k <= T; k++)
        {
            string str[3];
            for (int i = 0; i < 3; i++)
            {
                cin >> str[i];
                transform(str[i].begin(), str[i].end(), str[i].begin(), ::toupper);
            }

            cout << "#" << k << " " << str[0][0] << str[1][0] << str[2][0] << endl;
        }
    }
    return 0;
}
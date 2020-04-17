#include <iostream>
#include <vector>
#include <string>

using namespace std;

char arr[10][4] = {{}, {}, {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};

int main()
{
    string str;
    cin >> str;

    int answer = 0;
    for (auto s : str)
    {
        for (int i = 2; i <= 9; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (s == arr[i][j])
                {
                    answer += i + 1;
                }
            }
        }
    }

    cout << answer;
    return 0;
}

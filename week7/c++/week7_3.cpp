#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

char key[10][4] = {
    {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

int main(int argc, char **argv)
{
    int test_case;
    int T;
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        string s;
        cin >> s;

        int n;
        cin >> n;
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            string word;
            cin >> word;

            bool okay = true;
            for (int k = 0; k < word.size(); k++)
            {
                int index = s[k] - 48;
                if (word[k] == key[index][0] || word[k] == key[index][1] || word[k] == key[index][2] || word[k] == key[index][3])
                {
                    okay = true;
                    continue;
                }
                else
                {
                    okay = false;
                    break;
                }
            }

            if (okay)
            {
                count++;
            }
        }
        cout << "#" << test_case << " ";
        cout << count << endl;
    }
    return 0;
}
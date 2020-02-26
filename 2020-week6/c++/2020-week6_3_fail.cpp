// 시간초과...

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int n, k;
int ans;

void learn(vector<string> str)
{
    vector<bool> chk(26, false);

    for (int i = 0; i < k; i++)
    {
        chk[i] = true;
    }

    sort(chk.begin(), chk.end());
    do
    {
        // a, c, i, n, t 무조건 포함
        if (!chk['a' - 'a'] && !chk['c' - 'a'] && !chk['i' - 'a'] && !chk['n' - 'a'] && !chk['t' - 'a'])
        {
            continue;
        }

        int temp = 0;
        for (int i = 0; i < str.size(); i++)
        {
            bool learning = true;
            for (int j = 0; j < str[i].size(); j++)
            {
                if (!chk[str[i][j] - 'a'])
                {
                    learning = false;
                    break;
                }
            }

            if (learning)
            {
                temp++;
            }
        }
        ans = max(ans, temp);
    } while (next_permutation(chk.begin(), chk.end()));
}

int main(int argc, char **argv)
{

    cin >> n >> k;

    // anta, tica를 제외한 값을 배열 str에 삽입
    vector<string> str(n);
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;

        int len = s.size() - 8;
        str[i] = s.substr(4, len);
    }

    if (k < 5)
    {
        ans = 0;
    }
    else if (k == 26)
    {
        ans = n;
    }
    else
    {
        learn(str);
    }

    cout << ans << endl;

    return 0;
}
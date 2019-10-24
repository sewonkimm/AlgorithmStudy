#include <string>
#include <vector>

using namespace std;

int solution(string s)
{
    int answer = 1;
    vector<vector<int>> d(s.length(), vector<int>(s.length(), -1));

    // 길이가 1
    for (int i = 0; i < s.length(); i++)
    {
        d[i][i] = 1;
    }
    // 길이가 2
    for (int i = 0; i < s.length() - 1; i++)
    {
        if (s[i] == s[i + 1])
        {
            d[i][i + 1] = 1;
            answer = 2;
        }
        else
        {
            d[i][i + 1] = 0;
        }
    }
    // 길이가 3이상
    for (int k = 3; k <= s.length(); k++)
    {
        for (int i = 0; i <= s.length() - k; i++)
        {

            // 문자열의 끝 부분
            int j = i + k - 1;

            if (s[i] == s[j] && d[i + 1][j - 1] == 1)
            {
                d[i][j] = 1;
                if (answer < k)
                {
                    answer = k;
                }
            }
            else
                d[i][j] = 0;
        }
    }
    return answer;
}
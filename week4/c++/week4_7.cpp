#include <iostream>
#include <string>

using namespace std;

// ASCII code 'A' = 65
// 알파벳 갯수 26개
int alpha[26];

int main(void)
{
    string input;
    cin >> input;

    for (int i = 0; i < input.size(); i++)
    {
        input[i] = toupper(input[i]);

        int index = input[i] - 65;
        alpha[index] += 1;
    }

    // 최댓값 찾기
    int max = 0;
    char answer = '?';
    for (int i = 0; i < 26; i++)
    {
        if (max < alpha[i])
        {
            max = alpha[i];
            answer = i + 65;
        }
    }

    // 최댓값 중복 검사
    int count = 0;
    for (int i = 0; i < 26; i++)
    {
        if (max == alpha[i])
        {
            count++;
        }
    }

    if (count >= 2)
    {
        answer = '?';
    }
    cout << answer << endl;

    return 0;
}
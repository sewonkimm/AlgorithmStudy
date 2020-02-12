#include <iostream>
#include <string>

using namespace std;

int alpha[26];

int main(int argc, char **argv)
{

    // input
    string str;
    getline(cin, str);

    // alpha 배열 초기화
    fill_n(alpha, 26, -1);

    // a~z 까지 반복문
    for (char ch = 'a'; ch <= 'z'; ch++)
    {

        // str과 비교
        for (int i = 0; i < str.size(); i++)
        {
            if (str[i] == ch)
            {
                int index = ch - 'a';
                if (alpha[index] == -1)
                {
                    alpha[index] = i;
                }
            }
        }
    }

    for (int i = 0; i < 26; i++)
    {
        printf("%d ", alpha[i]);
    }

    return 0;
}
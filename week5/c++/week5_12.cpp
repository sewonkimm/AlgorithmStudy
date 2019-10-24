#include <iostream>
#include <string>

using namespace std;

int dialTime(char ch)
{

    int returnTime = 3;
    for (int i = 65; i <= 77; i += 3)
    {
        if (ch >= i && ch < i + 3)
        {
            return returnTime;
        }
        else
        {
            returnTime++;
        }
    }

    if (ch >= 80 && ch < 84)
    {
        return 8;
    }

    if (ch >= 84 && ch < 87)
    {
        return 9;
    }

    if (ch >= 87)
    {
        return 10;
    }
}

int main(void)
{
    string word;
    cin >> word;

    int sum = 0;
    for (int i = 0; i < word.size(); i++)
    {
        sum += dialTime(word[i]);
    }

    cout << sum;

    return 0;
}
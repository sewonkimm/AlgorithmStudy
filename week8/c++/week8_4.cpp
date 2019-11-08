#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(int argc, char **argv)
{
    string str;
    cin >> str;

    string temp;
    bool minus = false;
    int answer = 0;
    for (int i = 0; i <= str.size(); i++)
    {

        // +, - 일 때
        if (str[i] == '+' || str[i] == '-' || str[i] == '\0')
        {
            if (minus)
            {
                answer -= stoi(temp);
            }
            else
            {
                answer += stoi(temp);
            }
            temp = "";
        }

        if (str[i] == '-')
        {
            minus = true;
            continue;
        }

        // 숫자 일 때
        temp += str[i];
    }

    cout << answer << endl;

    return 0;
}
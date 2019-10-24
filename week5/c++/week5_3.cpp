#include <iostream>
#include <string>

using namespace std;

int main(void)
{

    int t;
    cin >> t;

    while (t--)
    {
        // 반복 횟수 입력
        int r;
        cin >> r;

        // 문자열 입력
        string text;
        cin >> text;

        for (int i = 0; i < text.size(); i++)
        {
            for (int j = 0; j < r; j++)
            {
                cout << text[i];
            }
        }
        cout << endl;
    }

    return 0;
}
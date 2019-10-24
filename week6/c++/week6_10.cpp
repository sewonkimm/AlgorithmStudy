#include <iostream>
#include <string>
using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        // 현재 시간
        string s[3];
        int index = 0;
        for (int i = 0; i < 8; i++)
        {
            char ch;
            cin >> ch;

            if (ch == ':')
            {
                index++;
            }
            else
            {
                s[index].push_back(ch);
            }
        }

        // 약속 시간
        index = 0;
        string e[3];
        for (int i = 0; i < 8; i++)
        {
            char ch;
            cin >> ch;

            if (ch == ':')
            {
                index++;
            }
            else
            {
                e[index].push_back(ch);
            }
        }

        // 시간 계산
        int sTime, eTime;
        sTime = eTime = 0;
        sTime = atoi(s[0].c_str()) * 60 * 60 + atoi(s[1].c_str()) * 60 + atoi(s[2].c_str());
        eTime = atoi(e[0].c_str()) * 60 * 60 + atoi(e[1].c_str()) * 60 + atoi(e[2].c_str());

        if (eTime < sTime)
        {
            eTime += 24 * 60 * 60;
        }

        int time = eTime - sTime;
        string hh, mm, ss;
        hh = to_string(time / (60 * 60));
        time %= (60 * 60);
        mm = to_string(time / 60);
        time %= 60;
        ss = to_string(time);

        if (hh.size() == 1)
        {
            hh.insert(0, 1, '0');
        }
        if (mm.size() == 1)
        {
            mm.insert(0, 1, '0');
        }
        if (ss.size() == 1)
        {
            ss.insert(0, 1, '0');
        }

        string answer;
        answer = hh + ':' + mm + ':' + ss;

        cout << "#" << test_case << " ";
        cout << answer << endl;
    }
    return 0;
}
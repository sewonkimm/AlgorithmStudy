#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool cmp(const string &a, const string &b)
{

    if (a.size() == b.size())
    {
        return (a < b);
    }
    return (a.size() < b.size());
}

int main()
{

    // input
    int n;
    cin >> n;

    vector<string> str(n);
    for (int i = 0; i < n; i++)
    {
        cin >> str[i];
    }

    // sort
    sort(str.begin(), str.end(), cmp);

    // 중복 삭제
    cout << str[0] << endl;
    string last = str[0];
    for (int i = 1; i < n; i++)
    {
        if (str[i] == last)
        {
            continue;
        }
        else
        {
            cout << str[i] << endl;
            last = str[i];
        }
    }
    return 0;
}
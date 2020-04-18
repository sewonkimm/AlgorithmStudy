#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

int main(int argc, char **argv)
{
    // input
    int n;
    cin >> n;

    map<string, int> ans;
    vector<string> str;
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        ans[s] = i;
    }
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        str.push_back(s);
    }

    int score = 0;
    int total = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            score += ans[str[i]] < ans[str[j]];
            total++;
        }
    }

    cout << score << "/" << total;

    return 0;
}
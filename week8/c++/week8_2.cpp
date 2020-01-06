#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const string &a, const string &b)
{
    return a + b > b + a ? true : false;
}

string solution(vector<int> numbers)
{

    vector<string> str;
    for (int i = 0; i < numbers.size(); i++)
    {
        str.push_back(to_string(numbers[i]));
    }
    sort(str.begin(), str.end(), cmp);

    string answer;
    for (int i = 0; i < str.size(); i++)
    {
        answer += str[i];
    }
    if (answer[0] == '0')
    {
        answer = '0';
    }
    return answer;
}
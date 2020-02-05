// https://bowbowbow.tistory.com/6
// 참고하여 풀었으나 kmp 함수 부분 구현하는 부분에서 잘 이해가 안가요ㅠㅠ

#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> getPi(string p)
{
    vector<int> pi(p.size(), 0);
    int j = 0;

    for (int i = 1; i < p.size(); i++)
    {
        while (j > 0 && p[i] != p[j])
        {
            j = pi[j - 1];
        }

        if (p[i] == p[j])
        {
            pi[i] = ++j;
        }
    }
    return pi;
}

vector<int> kmp(string t, string p)
{
    auto pi = getPi(p);

    vector<int> ans;
    int tSize = t.size();
    int pSize = p.size();
    int j = 0;

    for (int i = 0; i < tSize; i++)
    {

        while (j > 0 && t[i] != p[j])
        {
            j = pi[j - 1];
        }

        if (t[i] == p[j])
        {
            if (j == pSize - 1)
            {
                ans.push_back(i - pSize + 2);
                j = pi[j];
            }
            else
            {
                j++;
            }
        }
    }
    return ans;
}

int main(int argc, char **argv)
{

    string T, P;
    getline(cin, T);
    getline(cin, P);

    // T 중간에 P가 몇 번 나타나는지?
    auto ansArr = kmp(T, P);
    printf("%d\n", ansArr.size());

    // P가 나타나는 위치
    for (auto i : ansArr)
    {
        printf("%d\n", i);
    }

    return 0;
}
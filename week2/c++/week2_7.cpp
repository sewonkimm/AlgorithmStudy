#include <string>
#include <vector>
#include <queue>

using namespace std;

// 최소 거리 구하기
// BFS

int d[51];

// 한 글자만 다른지 확인
bool isDiff(string a, string b)
{
    int count = 0;
    for (int i = 0; i < a.length(); i++)
    {
        if (a[i] == b[i])
        {
            count++;
        }
    }

    if (a.size() - count != 1)
    {
        return false;
    }
    else
        return true;
}

int solution(string begin, string target, vector<string> words)
{
    int answer = 0;

    // words 안에 target이 없으면 프로그램 종료
    bool wordsCheck = false;
    for (int i = 0; i < words.size(); i++)
    {
        if (words[i] == target)
        {
            wordsCheck = true;
        }
    }
    if (!wordsCheck)
    {
        return 0;
    }

    // BFS
    queue<int> q;
    for (int i = 0; i < words.size(); i++)
    {
        if (isDiff(begin, words[i]))
        {
            q.push(i);
            d[i] = 1;
        }
    }

    while (!q.empty())
    {
        int now = q.front();
        q.pop();

        for (int i = 0; i < words.size(); i++)
        {
            if (isDiff(words[now], words[i]))
            {
                if (d[i] == 0)
                {
                    q.push(i);
                    d[i] = d[now] + 1;
                }
            }
        }
    }

    for (int i = 0; i < words.size(); i++)
    {
        if (words[i] == target)
        {
            answer = d[i];
            break;
        }
    }

    return answer;
}
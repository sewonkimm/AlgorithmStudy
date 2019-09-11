#include <string>
#include <vector>

using namespace std;

bool checkDup(vector<string> check, string word)
{
    for (int i = 0; i < check.size(); i++)
    {
        if (check[i] == word)
        {
            return true;
        }
    }

    return false;
}

bool checkAlpha(string last, string now)
{

    if (last == "")
    {
        return true;
    }

    if (last.back() != now.front())
        return false;
    else
        return true;
}

vector<int> solution(int n, vector<string> words)
{

    // 가장 먼저 탈락하는 사람의 번호, 몇 번째에 탈락하는지
    vector<int> answer;

    // 이미 사용한 단어 저장
    vector<string> check;

    int person = 1;
    int count = 1;
    int index = 0;
    string lastword = "";

    while (true)
    {

        // 게임 종료
        if (checkDup(check, words[index]) || !checkAlpha(lastword, words[index]))
        {
            answer.push_back(person);
            answer.push_back(count);
            break;
        }

        // 게임 진행
        check.push_back(words[index]);
        lastword = words[index];
        index++;
        person++;

        // 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작
        if (person == n + 1)
        {
            person = 1;
            count++;
        }

        // 탈락자가 생기지 않음
        if (index == words.size())
        {
            return {0, 0};
        }
    }

    return answer;
}
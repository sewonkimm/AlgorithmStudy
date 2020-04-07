#include <string>
#include <vector>
#include <stack>

using namespace std;

int answer = 0;
stack<int> basket;

void boom()
{
    int first = basket.top();
    basket.pop();
    int second = basket.top();

    if (first == second)
    {
        basket.pop();
        answer += 2;
    }
    else
    {
        basket.push(first);
    }
}

int solution(vector<vector<int>> board, vector<int> moves)
{

    for (int move : moves)
    {

        int doll = -1; // 현재 집은 인형

        // 옮기기
        for (int i = 0; i < board.size(); i++)
        {
            if (!board[i][move - 1])
            {
                continue;
            }
            else
            {
                doll = board[i][move - 1];
                board[i][move - 1] = 0;
                break;
            }
        }

        if (doll > 0)
        {
            basket.push(doll);

            // 중복 체크
            if (basket.size() > 1)
            {
                boom();
            }
        }
    }

    return answer;
}
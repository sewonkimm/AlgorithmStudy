#include <string>
#include <vector>

using namespace std;

int find(int start, string arr, vector<bool> visit, int count)
{

    visit[start] = true;

    // 전부 방문하면 종료
    bool end = true;
    for (int i = 0; i < visit.size(); i++)
    {
        if (visit[i] == false)
        {
            end = false;
        }
    }

    if (end)
    {
        return count;
    }

    // 현재 커서 위치 start
    // 왼쪽으로 이동 시 바꿔야 하는 알파벳까지의 거리 left
    // 오른쪽으로 이동 시 바꿔야 하는 알파벳까지의 거리 right
    int left = 0;
    int right = 0;

    int nextL = 0;
    int nextR = 0;
    do
    {

        left++;
        nextL = start - left;
        if (nextL < 0)
        {
            nextL = arr.size() + nextL;
        }
    } while (visit[nextL]);

    do
    {
        right++;
        nextR = (start + right) % arr.size();
    } while (visit[nextR]);

    // 왼쪽, 오른쪽 중 더 가까운 쪽으로 이동
    int next = 0;
    if (left >= right)
    {
        next = (start + right) % arr.size();

        count += right;
    }
    else
    {
        next = start - left;
        if (next < 0)
        {
            next = arr.size() + next;
        }

        count += left;
    }

    count = find(next, arr, visit, count);
    return count;
}

int solution(string name)
{

    int answer = 0;

    int len = name.size();
    vector<int> updown(len);
    vector<bool> visit(len, false);

    // up & down
    for (int i = 0; i < len; i++)
    {

        int up = name[i] - 'A';
        int down = 'Z' - name[i] + 1;

        updown[i] = (up < down) ? up : down;
        answer += updown[i];
    }

    // left & right
    for (int i = 0; i < len; i++)
    {
        if (name[i] == 'A')
        {
            visit[i] = true;
        }
    }

    answer += find(0, name, visit, 0);
    return answer;
}
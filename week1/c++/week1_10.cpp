#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights)
{
    int time = 1;
    vector<int> startTime(truck_weights.size(), 0);

    int count = 0;
    int index = 0;

    queue<int> q;
    q.push(index);
    startTime[index] = time;
    index++;

    while (count < truck_weights.size())
    {
        time++;
        int now = 0;

        // 트럭이 다리를 다 건넜는지 확인
        for (int i = 0; i < q.size(); i++)
        {
            if (bridge_length - (time - startTime[q.front()]) == 0)
            {
                q.pop();
                count++;
            }
        }

        // 다리가 버틸 수 있는 중량인지 확인
        if (index < truck_weights.size())
        {
            queue<int> temp = q;
            while (!temp.empty())
            {
                now += truck_weights[temp.front()];
                temp.pop();
            }

            // 새 트럭을 추가할 수 있는지 확인
            if (now + truck_weights[index] <= weight)
            {
                q.push(index);
                startTime[index] = time;
                index++;
            }
        }
    }
    return time;
}
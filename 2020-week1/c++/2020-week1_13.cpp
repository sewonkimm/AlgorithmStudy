#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main(int argc, char **argv)
{
    // V: 정점의 갯수
    // E: 간선의 갯수
    int V, E;
    scanf("%d %d", &V, &E);

    // K: 시작 정점 번호
    int K;
    scanf("%d", &K);

    vector<pair<int, int>> list[V + 1];
    for (int i = 0; i < E; i++)
    {
        int start, end, w;
        scanf("%d %d %d", &start, &end, &w);
        list[start].push_back(make_pair(end, w));
    }

    vector<int> dist(V + 1, 0);

    // 우선순위 큐 (heap) : weight, 시작점 정보가 들어있다.
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push(make_pair(0, K));
    while (!pq.empty())
    {
        int now = pq.top().second;
        int weight = pq.top().first;
        pq.pop();

        if (dist[now] != 0 && dist[now] < weight)
        {
            continue;
        }

        // 간선이 존재
        for (int i = 0; i < list[now].size(); i++)
        {
            int next = list[now][i].first;
            int nw = list[now][i].second;

            if (dist[next] == 0)
            {
                dist[next] = dist[now] + nw;
                pq.push(make_pair(dist[next], next));
            }
            else if (dist[next] > dist[now] + nw)
            {
                dist[next] = dist[now] + nw;
                pq.push(make_pair(dist[next], next));
            }
        }
    }

    for (int i = 1; i <= V; i++)
    {
        if (i == K)
        {
            printf("0\n");
            continue;
        }

        if (dist[i] == 0)
        {
            printf("INF\n");
        }
        else
        {
            printf("%d\n", dist[i]);
        }
    }

    return 0;
}
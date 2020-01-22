#include <iostream>
#include <vector>
#define INF 100000
using namespace std;

vector<vector<int>> floyd(vector<vector<int>> map, int V)
{

    // k=거쳐가는 노드
    for (int k = 1; k <= V; k++)
    {

        // i=출발노드
        for (int i = 1; i <= V; i++)
        {

            // j=도착노드
            for (int j = 1; j <= V; j++)
            {
                if (map[i][k] + map[k][j] < map[i][j])
                {
                    map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
    }
    return map;
}

int main(int argc, char **argv)
{
    int V, E;
    scanf("%d %d", &V, &E);

    vector<vector<int>> map(V + 1, vector<int>(V + 1, INF));

    for (int i = 0; i < E; i++)
    {
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);
        map[a][b] = c;
    }

    map = floyd(map, V);

    int ans = INF;
    for (int i = 0; i < V; i++)
    {
        if (map[i][i] < ans)
        {
            ans = map[i][i];
        }
    }

    if (ans == INF)
    {
        printf("-1\n");
    }
    else
    {
        printf("%d\n", ans);
    }
    return 0;
}
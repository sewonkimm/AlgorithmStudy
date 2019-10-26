#include <iostream>

using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {

        int N, B, E;
        cin >> N >> B >> E;

        int minTime = B - E;
        int maxTime = B + E;
        int answer = 0;
        for (int i = 0; i < N; i++)
        {
            int x;
            cin >> x;

            for (int k = minTime; k <= maxTime; k++)
            {
                if (k % x == 0)
                {
                    answer++;
                    break;
                }
            }
        }

        cout << "#" << test_case << " ";
        cout << answer << endl;
    }
    return 0;
}
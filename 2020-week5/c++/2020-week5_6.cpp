#include <iostream>

using namespace std;

int score[5][4];

int main(int argc, char **argv)
{

    // input
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            scanf("%d", &score[i][j]);
        }
    }

    int index = 0; // 우승자 번호
    int win = 0;   // 우승자 점수

    for (int i = 0; i < 5; i++)
    {
        int temp = 0;
        for (int j = 0; j < 4; j++)
        {
            temp += score[i][j];
        }

        if (temp > win)
        {
            index = i;
            win = temp;
        }
    }

    printf("%d %d\n", index + 1, win);

    return 0;
}
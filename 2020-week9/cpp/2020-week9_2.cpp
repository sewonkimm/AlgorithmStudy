#include <iostream>
#include <string>

using namespace std;

int main()
{

    int n;
    scanf("%d", &n);

    int count = 0;
    int num = 666;

    while (count < n)
    {
        string str = to_string(num);

        for (int i = 0; i <= str.length() - 1; i++)
        {
            bool isPass = true;

            for (int k = 0; k < 3; k++)
            {
                if (str[i + k] != '6')
                {
                    isPass = false;
                    break;
                }
            }

            if (isPass)
            {
                count++;
                break;
            }
        }
        num++;
    }
    printf("%d\n", num - 1);

    return 0;
}
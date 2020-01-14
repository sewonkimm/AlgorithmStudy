#include <iostream>
#include <stack>

using namespace std;

int main(int argc, char **argv)
{
    int k;
    cin >> k;

    stack<int> st;
    while (k--)
    {
        int x;
        cin >> x;

        if (x != 0)
        {
            st.push(x);
        }
        else if (x == 0)
        {
            st.pop();
        }
    }

    int sum = 0;
    while (!st.empty())
    {
        sum += st.top();
        st.pop();
    }

    cout << sum << endl;
    return 0;
}
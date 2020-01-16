#include <iostream>
#include <string>
#include <deque>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);

    deque<int> deq;

    int n;
    cin >> n;

    while (n--)
    {
        string cmd;
        cin >> cmd;

        if (cmd == "push_front")
        {
            int x;
            cin >> x;
            deq.push_front(x);
        }
        else if (cmd == "push_back")
        {
            int x;
            cin >> x;
            deq.push_back(x);
        }
        else if (cmd == "pop_front")
        {
            if (deq.empty())
            {
                cout << "-1\n";
            }
            else
            {
                cout << deq.front() << endl;
                deq.pop_front();
            }
        }
        else if (cmd == "pop_back")
        {
            if (deq.empty())
            {
                cout << "-1\n";
            }
            else
            {
                cout << deq.back() << endl;
                deq.pop_back();
            }
        }
        else if (cmd == "size")
        {
            cout << deq.size() << endl;
        }
        else if (cmd == "empty")
        {
            cout << deq.empty() << endl;
        }
        else if (cmd == "front")
        {
            if (deq.empty())
            {
                cout << "-1\n";
            }
            else
            {
                cout << deq.front() << endl;
            }
        }
        else if (cmd == "back")
        {
            if (deq.empty())
            {
                cout << "-1\n";
            }
            else
            {
                cout << deq.back() << endl;
            }
        }
    }
    return 0;
}
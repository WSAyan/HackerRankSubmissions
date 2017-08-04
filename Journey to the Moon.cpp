#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <vector>
#include <list>
#include <queue>
#include <set>
#include <map>
#include <string>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <functional>
#include <numeric>
#include <cstdlib>
#include <cmath>
#include <cstdio>
#include <fstream>
#include <ctime>
#include <cassert>

using namespace std;

long long par[100000] = {0};
long long countSets = 0;

void makeset(int n)
{
    par[n] = n;
}

long long find(long long r)
{
    if (par[r] == r)
    {
        return r;
    }
    else
        return par[r] = find(par[r]);
}

void set_union(long long a, long long b)
{
    long long u = find(a);
    long long v = find(b);

    if (u != v)
    {
        par[u] = v;
    }
}

int main()
{
    long long N, I;
    cin >> N >> I;
    long long result = 0;
    long long graph[N][N] = {0};
    for (long long i = 0; i < N; ++i)
    {
        makeset(i);
        graph[i][i] = 1;
        result++;
    }

    for (long long i = 0; i < I; ++i)
    {
        long long a, b;
        cin >> a >> b;

        if (graph[a][b] != 1 && graph[b][a] != 1)
        {
            result += 2;
            graph[a][b] = 1;
            graph[b][a] = 1;
            set_union(a, b);
        }
    }

    for (long long i = 0; i < N; i++)
    {
        long long badOne = find(i);
        if (i != badOne)
        {
            if (graph[i][badOne] != 1 && graph[badOne][i] != 1)
            {
                result += 2;
                graph[i][badOne] = 1;
                graph[badOne][i] = 1;
            }
        }
    }
    result = ((N * N) - result) / 2;
    cout << result << endl;
    return 0;
}

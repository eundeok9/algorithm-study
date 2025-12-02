#include <string>
#include <vector>

using namespace std;

bool checkSame(int x, int y, int size, const vector<vector<int>>& arr);
void dfs(int x, int y, int size, const vector<vector<int>>& arr);


int zeroCnt = 0;
int oneCnt = 0;

vector<int> solution(vector<vector<int>> arr) {
    dfs(0, 0, arr.size(), arr);
    return {zeroCnt, oneCnt};
}

bool checkSame(int x, int y, int size, const vector<vector<int>>& arr) {
    int val = arr[x][y];
    for(int i=x; i<x+size; i++) {
        for(int j=y; j<y+size; j++) {
            if(arr[i][j] != val) return false;
        }
    }
    
    return true;
}

void dfs(int x, int y, int size, const vector<vector<int>>& arr) {
    if(checkSame(x, y, size, arr)) {
        if(arr[x][y] == 0) zeroCnt++;
        else oneCnt++;
        return;
    }
    
    int half = size / 2;
    dfs(x, y, half, arr);
    dfs(x, y + half, half, arr);
    dfs(x + half, y, half, arr);
    dfs(x + half, y + half, half, arr);
}
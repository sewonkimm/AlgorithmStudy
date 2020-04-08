import java.util.Stack;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < moves.length; i++) {
			int currentIndex = moves[i] - 1;
			for (int j = 0; j < board.length; j++) {
				if (board[j][currentIndex] != 0) {
					if (!s.isEmpty() && board[j][currentIndex] == s.peek()) {
						s.pop();
						answer += 2;
					} else {
						s.push(board[j][currentIndex]);
					}
					board[j][currentIndex] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
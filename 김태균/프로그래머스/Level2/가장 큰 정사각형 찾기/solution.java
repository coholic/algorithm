class Solution
{
    public int solution(int [][]board)
    {
        int len = 0;
        if(board.length == 1 || board[0].length == 1){
            return 1;
        }
        
        for(int i =1;i<board.length;i++){
            for(int j =1;j<board[0].length;j++){
                if(board[i][j] !=0){
                    board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]) +1;
                    len = Math.max(board[i][j],len);
                }
            }
        }
        return len*len;
    }
}
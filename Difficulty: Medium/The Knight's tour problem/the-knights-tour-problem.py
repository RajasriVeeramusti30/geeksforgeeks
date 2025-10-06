class Solution:
    def knightTour(self, n):
        # All 8 possible moves of a knight
        MOVES = [(-2, 1), (-1, 2), (1, 2), (2, 1),
                 (2, -1), (1, -2), (-1, -2), (-2, -1)]
        
        board = [[-1] * n for _ in range(n)]
        total_steps = n * n

        def dfs(x, y, step):
            board[x][y] = step
            if step == total_steps - 1:
                return True  # Found a valid tour

            for dx, dy in MOVES:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == -1:
                    if dfs(nx, ny, step + 1):
                        return True

            # Backtrack
            board[x][y] = -1
            return False

        if dfs(0, 0, 0):
            return board
        else:
            return []

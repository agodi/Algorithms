def fibonacci(n, dp):
    if n in dp:
        return dp[n]
    if n <= 1:
        return 1
    else:
        x = fibonacci(n - 1, dp)
        y = fibonacci(n - 2, dp)
        dp[n] = x + y
        return dp[n]

dp = {}
print fibonacci(10, dp)

print dp
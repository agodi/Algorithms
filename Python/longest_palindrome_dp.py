def find_longest_palindrome(string, memo):
    if string in memo:
        return memo[string]
    elif is_palindrome(string):
        memo[string] = string
        return string
    left = find_longest_palindrome(string[:-1], memo)
    right = find_longest_palindrome(string[1:], memo)
    middle = find_longest_palindrome(string[1:-1], memo)
    if len(left) >= len(right) and len(left) >= len(middle):
        memo[string] = left
        return left
    elif len(right) >= len(left) and len(right) >= len(middle):
        memo[string] = right
        return right
    else:
        memo[string] = middle
        return middle


def is_palindrome(string):
    i = 0
    while i < (len(string) - 1 - i):
        if string[i] == string[len(string) - 1 - i]:
            i += 1
        else:
            return False
    return True


string = "asdlkfjsdlfusdbaab"
print(find_longest_palindrome(string, {}))
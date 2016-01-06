def find_longest_palindrome(string):
    if is_palindrome(string):
        return string
    left = find_longest_palindrome(string[:-1])
    right = find_longest_palindrome(string[1:])
    middle = find_longest_palindrome(string[1:-1])
    if len(left) >= len(right) and len(left) >= len(middle):
        return left
    elif len(right) >= len(left) and len(right) >= len(middle):
        return right
    else:
        return middle


def is_palindrome(string):
    i = 0
    while i < (len(string) - 1 - i):
        if string[i] == string[len(string) - 1 - i]:
            i += 1
        else:
            return False
    return True


string = "asdlkfjsdlfusdboob"
print(find_longest_palindrome(string))
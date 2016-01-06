def get_dp_matrix(matrix, m, n):
    aux = [[0 for x in range(n)] for x in range(m)]

    i = 0
    j = 0

    aux[i][j] = matrix[0][0]

    while i < m and j < n:

        for x in range(j + 1, n):
            aux[i][x] = aux[i][x - 1] + matrix[i][x]

        for y in range(i + 1, m):
            aux[y][j] = aux[y - 1][j] + matrix[y][j]

        if i == m - 1 or aux[i][j + 1] < aux[i + 1][j]:
            j = j + 1
        else:
            i = i + 1

    return aux


def find_shortest_path(matrix, m, n):

    dp_matrix = get_dp_matrix(matrix, m, n)

    i = m - 1
    j = n - 1

    path = [matrix[i][j]]

    while i != 0 or j != i:
        if i == 0 or dp_matrix[i][j - 1] < dp_matrix[i - 1][j]:
            j = j - 1
        else:
            i = i - 1
        path.append(matrix[i][j])

    path.reverse()
    return path

i = [
    [1, 2, 3, 4, 5, 1],
    [1, 2, 3, 4, 5, 1],
    [1, 2, 3, 4, 5, 1],
    [1, 2, 3, 4, 5, 1],
    [1, 2, 3, 4, 5, 1],
    [1, 2, 3, 4, 5, 1]
    ]
m = 6
n = 6

print((find_shortest_path(i, m, n)))
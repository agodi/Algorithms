
def print_clock_wise(matrix):
    size = len(matrix)
    offset = 0
    while offset <= size / 2:

        for i in range(offset, size - offset):
            print(matrix[offset][i])

        for i in range(offset + 1, size - offset):
            print(matrix[i][size - offset - 1])

        for i in range(size - offset - 2, offset - 1, -1):
            print(matrix[size - offset - 1][i])

        for i in range(size - offset - 2, offset, -1):
            print(matrix[i][offset])

        offset += 1

matrix = [
    [1, 2, 3, 4, 5],
    [6, 7, 8, 9, 10],
    [11,12,13,14,15],
    [16,17,18,19,20],
    [21,22,23,24,25]
    ]

print_clock_wise(matrix)
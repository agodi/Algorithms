def search(list, num, start, end):
    mid = (end + start) / 2
    if num == list[mid]:
        return mid
    elif mid == end:
        return -1
    elif num > list[mid]:
        return search(list, num, mid + 1, end)
    elif num < list[mid]:
        return search(list, num, start, mid - 1)


sorted_list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print search(sorted_list, 10, 0, len(sorted_list) - 1)
print search(sorted_list, 9, 0, len(sorted_list) - 1)
print search(sorted_list, 8, 0, len(sorted_list) - 1)
print search(sorted_list, 7, 0, len(sorted_list) - 1)
print search(sorted_list, 6, 0, len(sorted_list) - 1)
print search(sorted_list, 5, 0, len(sorted_list) - 1)
print search(sorted_list, 4, 0, len(sorted_list) - 1)
print search(sorted_list, 3, 0, len(sorted_list) - 1)
print search(sorted_list, 2, 0, len(sorted_list) - 1)
print search(sorted_list, 1, 0, len(sorted_list) - 1)
print search(sorted_list, 11, 0, len(sorted_list) - 1)

def permutations(data, string, tracker):
    if len(string) == len(data):
        print(string)
        return
    for i in range(len(data)):
        if i in tracker:
            continue
        tracker[i] = True
        permutations(data, string + str(data[i]), tracker)
        del tracker[i]

permutations(['A', 'B', 'C', 'D'], "", {})
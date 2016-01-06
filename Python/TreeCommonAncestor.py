def appendsums(lst):
    """
    Repeatedly append the sum of the current last three elements of lst to lst.
    """
    for i in range(25):
        aux = lst[-1] + lst[-2] + lst[-3]
        lst.append(aux)
    print(lst[20])

appendsums([0, 1, 2])
import random

def quicksort(integers):
    """Sorts a given array of integers using
        quicksort algorithm"""
    sort(integers, 0, len(integers))
    print "final array: ", integers
    
def sort(integers, start, stop):
    """Recursive function to split array in 
        two parts"""
    if start != stop:
        index = find_pivot_index(integers, start, stop)
        sort(integers, start, index)
        sort(integers, index+1, stop)

def find_pivot_index(integers, start, stop):
    """Function to pick a random element from the array
        and place it in the right position rearranging
        all smaller elements to it's left and all
        higher elements to it's right"""
    index = None
    pivot = random.randrange(start, stop)
    switch(integers, start, pivot)
    i = start + 1
    j = stop - 1
    while i <= j:
        while i < stop and integers[i] < integers[start]:
            i += 1
        while j > start and integers[j] >= integers[start]:
            j -= 1
        if i < j:
            switch(integers, i, j)
    index = i-1
    switch(integers, start, index)
    return index
    
def switch(integers, i, j):
    """Swaps two elements in the array"""
    if i == j:
        return
    aux = integers[i]
    integers[i] = integers[j]
    integers[j] = aux
    
integers = [1,8,7,6,5,4,3,2,1]
quicksort(integers)
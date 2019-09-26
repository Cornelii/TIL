from random import randrange, shuffle 


def quicksort(arr, start, end):
    # this portion of array has been sorted
    if start >= end:
        return

    # select random element to be pivot
    pivot_idx = randrange(start, end + 1)
    pivot_element = arr[pivot_idx]

    # swap random element with last element in sub-array
    arr[end], arr[pivot_idx] = arr[pivot_idx], arr[end]

    # tracks all elements which should be to left (lesser than) pivot
    less_than_pointer = start
  
    for i in range(start, end):
    # we found an element out of place
        if arr[i] < pivot_element:
            # swap element to the right-most portion of lesser elements
            arr[i], arr[less_than_pointer] = arr[less_than_pointer], arr[i]
            # tally that we have one more lesser element
            less_than_pointer += 1
    # move pivot element to the right-most portion of lesser elements
    arr[end], arr[less_than_pointer] = arr[less_than_pointer], arr[end]

    # Call quicksort on the "left" and "right" sub-arrs
    quicksort(arr, start, less_than_pointer-1)
    quicksort(arr, less_than_pointer+1, end)
  


unsorted_arr = [3,7,12,24,36,42]
shuffle(unsorted_arr)
print(unsorted_arr)
# use quicksort to sort the arr, then print it out!
quicksort(unsorted_arr,0,len(unsorted_arr)-1)
print(unsorted_arr)
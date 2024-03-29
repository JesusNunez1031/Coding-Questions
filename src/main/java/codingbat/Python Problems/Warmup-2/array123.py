# Given an array of ints, return True if the sequence of numbers 1, 2, 3 appears in the array somewhere.
#
#
# codingbat.warmup_2.array123([1, 1, 2, 3, 1]) → True
# codingbat.warmup_2.array123([1, 1, 2, 4, 1]) → False
# codingbat.warmup_2.array123([1, 1, 2, 1, 2, 3]) → True
def codingbat.warmup_2.array123(nums):
    setNum = set()
    for i in nums:
        if i == 1 or i == 2 or i == 3:
            setNum.add(i)
        return len(setNum) == 3
    return False

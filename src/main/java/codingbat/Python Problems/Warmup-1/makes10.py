# Given 2 ints, a and b, return True if one if them is 10 or if their sum is 10.
#
#
# codingbat.warmup_1.makes10(9, 10) → True
# codingbat.warmup_1.makes10(9, 9) → False
# codingbat.warmup_1.makes10(1, 9) → True
def codingbat.warmup_1.makes10(a, b):
    sum = a + b
    return a == 10 or b == 10 or sum == 10

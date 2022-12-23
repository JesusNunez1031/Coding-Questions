# Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n
# is over 21.
#
#
# codingbat.warmup_1.diff21(19) → 2
# codingbat.warmup_1.diff21(10) → 11
# codingbat.warmup_1.diff21(21) → 0

def codingbat.warmup_1.diff21(n):
    if n > 21:
        return abs(21 - n) * 2

    return 21 - n


print(codingbat.warmup_1.diff21(21))

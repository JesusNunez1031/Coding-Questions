# Given a string, we'll say that the front is the first 3 chars of the string. If the string length is less than 3,
# the front is whatever is there. Return a new string which is 3 copies of the front.
#
#
# codingbat.warmup_1.front3('Java') → 'JavJavJav'
# codingbat.warmup_1.front3('Chocolate') → 'ChoChoCho'
# codingbat.warmup_1.front3('abc') → 'abcabcabc'
def codingbat.warmup_1.front3(str):
    return str[:3] + str[:3] + str[:3]

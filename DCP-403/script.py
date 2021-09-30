from collections import Counter
import random

def rand5():
    return random.randint(1, 5)

def rand7():
    r = 5 * (rand5() - 1) + (rand5() - 1)
    #rejection Sampling
    if(r < 21): return (r % 7) + 1
    return rand7()

print(Counter(rand7() for  _ in range(100000)))

#when rand5 generates from 1 to 5
print(Counter( 5 * (x - 1) + (y - 1) for x in range(1, 6) for y in range(1, 6)))

#when rand5 generates from 0 to 4
print(Counter( 5 * (x) + (y) for x in range(5) for y in range(5)))

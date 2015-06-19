# Claire Jaja
# 11/1/2014
#
# Project Euler
# Problem 3
# Largest prime factor
#
# The prime factors of 13195 are 5, 7, 13, and 29.
# What is the largest prime factor of the number 6008514745143?

import math
from collections import defaultdict

def main():
    #num = 13195
    num = 600851475143
    primes = calc_primes(int(math.sqrt(num))+1)
    primes.sort()
    primes.reverse()
    largest_prime_factor = 0
    i = 0
    while not largest_prime_factor:
        if float(num) % primes[i] == 0:
            largest_prime_factor = primes[i]
        else:
            i += 1
    print(largest_prime_factor)

# calculate all primes up to x using sieve of Eratosthenes
def calc_primes(x):
    is_prime = defaultdict(lambda:True)
    for i in range(3,int(math.sqrt(x))+1,2):
        if is_prime[i]:
            for j in range(i,int(x/i)+1,2):
                is_prime[i*j] = False
    primes = [y for y in range(1,x+1) if y % 2 != 0 and is_prime[y]]
    primes.append(2)
    return primes

if __name__ == "__main__":
    main()

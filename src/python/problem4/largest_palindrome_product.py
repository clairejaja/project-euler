# Claire Jaja
# 11/1/2014
#
# Project Euler Problem 4
# Largest palindrome product
#
# A palindromic number reads the same both ways.
# The largest palindrome made from the product of two 2-digit numbers
# is 9009 = 91 x 99.
# Find the largest palindrome made from the product of two 3-digit numbers.

def main():
    largestProduct = 0
    for i in range(999,100,-1):
        for j in range(i,100,-1):
            product = i*j
            if str(product) == str(product)[::-1] and product > largestProduct:
                largestProduct = product
    print(largestProduct)

if __name__ == "__main__":
    main()

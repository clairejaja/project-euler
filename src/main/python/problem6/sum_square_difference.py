# Claire Jaja
# 11/4/2014
#
# Project Euler
# Problem 6
# Sum square difference
#
# The sum of the squares of the first ten natural numbers is:
# 1^2 + 2^2 + ... + 10^2 = 385
# The square of the sum of the first ten natural numbers is:
# (1 + 2 + ... + 10)^2 = 55^2 = 3025
# Hence the difference between the sum of the squares of the first ten natural
# numbers and the square of the sum is 3025 - 385 = 2640
# Find the difference between the sum of the squares of the first one hundred
# natural numbers and the square of the sum.

def main():
    num = 100
    my_sum = 0
    sum_of_square = 0
    for i in range(num+1):
        my_sum += i
        sum_of_square += i*i
    square_of_sum = my_sum * my_sum
    difference = square_of_sum - sum_of_square
    print(difference)

if __name__ == "__main__":
    main()

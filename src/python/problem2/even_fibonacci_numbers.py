# Claire Jaja
# 11/1/2014
#
# Project Euler
# Problem 2
# Even Fibonacci numbers
#
# Each new term in the Fibonacci sequence is generated by adding
# the previous two terms.
# By starting with 1 and 2, the first 10 terms will be:
# 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
# By considering the terms in the Fibonacci sequence
# whose values do not exceed four million,
# find the sum of the even-valued terms.

def main():
    max_value = 4000000
    # set up first three terms
    previous_previous_term = 1
    previous_term = 1
    current_term = 2

    my_sum = 0

    while current_term < max_value:
        if current_term % 2 == 0:
            my_sum += current_term
        previous_previous_term = previous_term
        previous_term = current_term
        current_term = previous_term + previous_previous_term

    print(my_sum)

if __name__ == "__main__":
    main()

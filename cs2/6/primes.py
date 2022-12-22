def generate_primes(end):
    primes = []
    for i in range(2, end):
        if is_prime(i):
            primes.append(i)
    return primes


def is_prime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True


if __name__ == '__main__':
    print(generate_primes(100))

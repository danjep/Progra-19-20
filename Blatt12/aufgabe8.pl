% a)
prime(1, N).
prime(N) :- A is N-1, prime(A, N).
prime(A, N) :- B is A-1, not(0 is N mod A), prime(B, N).

% b)
only_primes([]).
only_primes([A | B]) :- prime(A), only_primes(B).
% a)
prime(N) :- A is N-1, not_div(A, N).

not_div(1,N).
not_div(A,N) :- B is A-1, not(0 is N mod A), not_div(B,N).

% b)
only_primes([]).
only_primes([A | B]) :- prime(A), only_primes(B).
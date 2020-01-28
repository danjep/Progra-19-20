fib :: Int -> Int
fib 0 = 1
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

prime :: Int -> Bool
prime 0 = False
prime 1 = False
prime 2 = True
prime n = primeTest n (n-1)

primeTest :: Int -> Int -> Bool
primeTest n 1 = True
primeTest n x | rem n x == 0 = False
              | otherwise primeTest n (x-1)

powersOfTwo :: Int -> Int -> [Int]
powersOfTwo i0 i1 | i0 > i1 = []
                  | otherwise = (2^i0) : powersOfTwo i0+1 i1

intersection :: [Int] -> [Int] -> [Int]
intersection [] _ = []
intersection _ [] = []
intersection (x:xs) ys | (contains ys x) = x : intersection xs ys
                       | otherwise intersection xs ys

contains :: [Int] -> Int -> Bool
contains [] x = False
contains (x:xs) y | x == y = True
                  | otherwise contains xs y

selectKsmallest :: Int -> [Int] -> Int
            
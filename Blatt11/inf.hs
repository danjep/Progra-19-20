import Data.List

strings :: Int -> [String]
strings 0 = [""]
strings n = concat (map (\x -> map (\tail -> x:tail) tails) ['a'..'z'])
    where tails = strings (n-1)

divisors :: Int -> [Int]
divisors x = filter (\y -> rem x y == 0) [1..div x 2]

-- a)

palindromes :: [String]
palindromes = palindromesL 1

palindromesL :: Int -> [String]
palindromesL n = (map(\x -> x++(reverse x)) (strings n))++(palindromesL (n+1))

-- b)

perfects :: [Int]
perfects = filter isPerfect [2..]

isPerfect :: Int -> Bool
isPerfect x = x == sum (divisors x)

-- c)

semiPerfects :: [Int]
semiPerfects = filter isSemiPerfect [2..]

isSemiPerfect :: Int -> Bool
isSemiPerfect x = any (sumEquals x) (subsequences (divisors x))

sumEquals :: Int -> [Int] -> Bool
sumEquals _ [] = False
sumEquals n xs = n == sum xs

-- d)

fib :: [Int]


get :: n [Int] -> Int
get 1 (x:xs) = x
get n (x:xs) = get n-1 xs


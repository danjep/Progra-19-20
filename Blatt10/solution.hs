fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-2) + fib (n-1)

prime :: Int -> Bool
prime 0 = False
prime 1 = False
prime 2 = True
prime n = primeTest n (n-1)

primeTest :: Int -> Int -> Bool
primeTest n m | m == 1 = True
              | (rem n m == 0) = False
              | otherwise = primeTest n (m-1)

powersOfTwo :: Int -> Int -> [Int]
powersOfTwo n m | n > m = []
                | n <= m = (2^n) : powersOfTwo (n+1) m

intersection :: [Int] -> [Int] -> [Int]
intersection [] _ = []
intersection _ [] = []
intersection (x : xs) (ys) | contains ys x = x : intersection xs ys
                           | otherwise = intersection xs ys

contains :: [Int] -> Int -> Bool
contains [] _ = False
contains (x : xs) y | x == y = True
                    | otherwise = contains xs y

selectKsmallest :: Int -> [Int] -> Int
selectKsmallest _ [] = 0
selectKsmallest k (pivot:rest) =
  let
  split :: [Int] -> ([Int], [Int])
  split [] = ([], [])
  split (y:ys) = if y <= pivot then (y:left, right) else (left, y:right)
                 where (left, right) = split ys
  left, right :: [Int]
  (left, right) = split rest
  left_len :: Int
  left_len = length left
  in
   if (left_len) == (k-1) then pivot else
     if (left_len) > (k-1) then selectKsmallest k left else
       selectKsmallest (k-1-left_len) right

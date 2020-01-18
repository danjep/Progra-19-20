--a)
fibInit :: Int -> Int -> Int -> Int
fibInit a0 a1 n
            | n< 0 = 0
            | n==0 = a0
            | n==1 = a1
            | n==2 = (a0+a1)
            | otherwise = fibInit a1 (a0+a1) (n-1)


--b)
fibInitL :: Int -> Int -> Int -> [Int]
fibInitL a0 a1 n
            | n==(-1)   = []
            | n==0      = [a0] ++ fibInitL a0 a1 (-1)
            | otherwise = [a0] ++ fibInitL a1 (a0+a1) (n-1)


fibInit2 :: Int -> Int -> Int -> Int
fibInit2 a0 a1 n = help (fibInitL a0 a1 n) n


help :: [Int] -> Int -> Int
help [] a   = 0
help (x:xs) 0 = x
help (x:xs) a = help xs (a-1)


--c)
normalize :: [Int] -> [Int]
normalize xs = diff (mini xs, xs)


mini :: [Int] -> Int
mini [] = 0
mini (x:xs)     | x < mini xs = x
                | otherwise = mini xs


diff :: (Int, [Int]) -> [Int]
diff (0, xs)    = xs
diff (a, [])    = []
diff (a, x:xs)  = [(x-a)] ++ diff (a, xs)


--d)
sumMaxs :: [Int] -> Int
sumMaxs []       = 0
sumMaxs [x]      = x
sumMaxs (x : xs) = x + sumMaxt (x : xs)


sumMaxt :: [Int] -> Int
sumMaxt []  = 0
sumMaxt [x] = 0
sumMaxt (x : y : xs) 
            | x<y       = y + sumMaxt (y : xs)
            | otherwise = sumMaxt (x : xs)


--e)
sumNonMins :: [Int] -> Int
sumNonMins []   = 0
sumNonMins [x]  = 0
sumNonMins (x : y : xs) 
                | x<y       = y + sumNonMins (x : xs)
                | otherwise = sumNonMins (y : xs) 


--f)
primeTwins :: Int -> (Int, Int)
primeTwins x
        | prime (x+1) = primeTwint (x+1)
        | otherwise = primeTwins (x+1)

primeTwint :: Int -> (Int, Int)
primeTwint x
        | prime (x+2) = (x, (x+2))
        | otherwise = primeTwins (x+1)


prime :: Int -> Bool
prime 0 = False
prime 1 = False
prime 2 = True
prime n = primeTest n (n-1)

primeTest :: Int -> Int -> Bool
primeTest n m | m == 1 = True
              | (rem n m == 0) = False
              | otherwise = primeTest n (m-1)


--g)
multiples :: [Int] -> Int -> Int -> [Int]
multiples [] a b = []
multiples (xs) a b 
            | a >= b = []
            | otherwise = (multiplet (xs) a) ++ (multiples (xs) (a+1) b)

--HIER STECKT NOCH EIN FEHLER DRIN
multiplet :: [Int] -> Int -> [Int]
mutliplet [] a = []
multiplet (x:xs) a
            | rem a x == 0 = [a] ++ multiplet xs a
            | otherwise = multiplet xs a

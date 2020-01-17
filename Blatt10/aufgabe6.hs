--a)
{-
fibInit :: Int -> Int -> Int -> Int
fibInit a0 a1 0 = a0
fibInit a0 a1 1 = a1
fibInit a0 a1 2 = (a0 + a1)
fibInit a0 a1 n = fibInit a1 (a0+a1) (n-1)
-}


fibInit :: Int -> Int -> Int -> Int
fibInit a0 a1 n
            | n< 0 = 0
            | n==0 = a0
            | n==1 = a1
            | n==2 = (a0+a1)
            | otherwise = fibInit a1 (a0+a1) (n-1)


{-noch nicht fertig

fibInitL :: Int -> Int -> Int -> [Int]
fibInitL a0 a1 n
            | n=(-1)    = []
            | n=0       = (a0 : fibInitL a0 a1 -1)
            | otherwise = (a0 : fibInitL a1 (a0+a1) (n-1))


fibInit2 :: Int -> Int -> Int -> Int
fibInit2 a0 a1 n 
            | n=0 = (x: fibInitL a0 a1 n)

-}

--c)


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

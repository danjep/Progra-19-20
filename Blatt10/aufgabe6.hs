fibInit :: Int -> Int -> Int -> Int
fibInit _ _ 0 = 0
fibInit a0 a1 n = (a0+a1) + fibInit a1 (a0+a1) n-1

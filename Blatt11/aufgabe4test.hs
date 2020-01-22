f :: [Int] -> Int -> [Bool] -> [Int]
f xs y [] = []
f (x:xs) y (z:zs) = if z then ((x + y) : f xs y zs) else (x : f xs y zs)
-- KORREKT


g :: a -> [a] -> [a]
g x y = g (head y) y
g x y = (\x -> x) y
--  gibt ne warnung



h :: [Int] -> Int -> [Bool] -> [Bool] -> Bool
h w x [] z = if w == [] then head z else h w x [] z
h w x (y:ys) z = if w == [x] then y else (x+1 > x)
-- KORREKT


data X a b = A a | B Int | F (a -> b -> Bool)

i :: X Int Int -> Int -> Int -> Bool
i (F f) x y = f x y
i (A x) y z = if (x == z) then h y else h 0
  where
    h n = i (B n) y x
-- KORREKT

j :: Bool -> Bool -> [Bool]
j x y | x > y = []
      | y == x = [x] ++ [y]
      | otherwise = y : (x <= y) : j x x
-- KORREKT
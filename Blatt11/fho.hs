data List a = Nil | Cons a (List a) deriving Show

list :: List Int
list = Cons (-3) (Cons 14 (Cons (-6) (Cons 7 (Cons 1 Nil))))

blist :: List Int
blist = Cons 1 (Cons 1 (Cons 0 (Cons 0 Nil)))

-- a)

filterList :: (a -> Bool) -> List a -> List a
filterList f (Nil) = Nil
filterList f (Cons v n) | f v       = Cons v (filterList f n)
                        | otherwise = filterList f n

-- b)

divisibleBy :: Int -> List Int -> List Int
divisibleBy d xs = filterList (\x -> rem x d == 0) xs

-- c)

plus :: Int -> Int -> Int
plus a b = a + b

foldList :: (a -> b -> b) -> b -> List a -> b
foldList f i (Nil) = i
foldList f i (Cons v n) = f v (foldList f i n)

-- d)

listMaximum :: List Int -> Int
listMaximum xs = foldList maxComp minBound xs

maxComp :: Int -> Int -> Int
maxComp a b | a > b     = a
            | otherwise = b

-- e)

mapList :: (a -> b) -> List a -> List b
mapList f xs = foldList (\y ys -> Cons(f y) ys) Nil xs

-- f)

zipLists :: (a -> b -> c) -> List a -> List b -> List c
zipLists _ (Nil) _ = Nil
zipLists _ _ (Nil) = Nil
zipLists f (Cons v1 n1) (Cons v2 n2) = Cons (f v1 v2) (zipLists f n1 n2)

-- g)

skalarprodukt :: List Int -> List Int -> Int
skalarprodukt xs ys = foldList (\x y -> x+y) 0 (zipLists (\x y -> x*y) xs ys)
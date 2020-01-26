data List a = Nil | Cons a ( List a ) deriving Show


list :: List Int
list = Cons ( -3) ( Cons 14 ( Cons ( -6) ( Cons 7 ( Cons 1 Nil ))))


blist :: List Int
blist = Cons 1 ( Cons 1 ( Cons 0 ( Cons 0 Nil )))


--a)
filterList :: (a -> Bool) -> List a -> List a
filterList f Nil = Nil
filterList f (Cons a b) | (f a) == False = filterList f b
                        | (f a) == True = Cons a (filterList f b)



--b)
divisibleBy :: Int -> List Int -> List Int
divisibleBY x Nil = Nil
divisibleBy x (Cons a b) = filterList (\a -> (rem a x) == 0) (Cons a b)


--c)
foldList :: (a -> b -> b) -> b -> List a -> b
foldList f x Nil = x
foldList f x (Cons a b) = (f a) (foldList f x b)

plus :: Int -> Int -> Int
plus x y = x + y


--d)
listMaximum :: List Int -> Int
listMaximum Nil = minBound
listMaximum (Cons a b) = foldList (\x y -> if x > y then x else y) minBound (Cons a b)


--e)
mapList :: (a -> b) -> List a -> List b
mapList f xs = foldList (\y ys -> Cons(f y) ys) Nil xs


--f)
zipLists :: (a -> b -> c) -> List a -> List b -> List c
zipLists f Nil a = Nil
zipLists f a Nil = Nil
zipLists f (Cons a b) (Cons c d) = Cons (f a c) (zipLists f b d) 


--g)
skalarprodukt :: List Int -> List Int -> Int
skalarprodukt Nil a = 0
skalarprodukt a Nil = 0
skalarprodukt (Cons a b) (Cons c d) = foldList (\x y -> x + y) 0 (zipLists (\x y -> x * y) (Cons a b) (Cons c d))


import Text.Show.Functions
--a)
data BinTree a b =  Blatt b | Node a (BinTree a b) (BinTree a b) deriving Show

--b) 
example :: BinTree (Int -> Bool) Char
example = 
    Node (\x -> x>4)
        (Node (\x -> (x*x==x))
            (Blatt 'g')
            (Node (\x -> x==0)
                (Blatt 'u')
                (Blatt 'l')
            )
        )
        (Node (\x -> x >= 7)
            (Blatt 'f')
            (Blatt 'i')
        )


--c)
countInnerNodes :: BinTree a b -> Int
countInnerNodes (Blatt b) = 0
countInnerNodes (Node _ c d) = 1 + (countInnerNodes c) + (countInnerNodes d)


--d)
decodeInt :: BinTree (Int -> Bool) b -> Int -> b
decodeInt (Blatt b) x = b
decodeInt (Node a c d) x    | a x == False = decodeInt c x
                            | a x == True = decodeInt d x
                            

--e)
decode :: BinTree (Int -> Bool) b -> [Int] -> [b]
decode _ [] = []
decode (Node a c d) (x:xs) = (map (decodeInt (Node a c d) x) xs) ++ decode (Node a c d) xs  -- ALTERNATIV: (decodeInt (Node a c d) x) : (decode (Node a c d) xs)


--f)
mapTree :: f (b -> c) -> BinTree a b -> BinTree a c

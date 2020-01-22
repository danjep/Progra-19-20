import Text.Show.Functions
--a)
data BinTree a b =  Blatt b | Node a (BinTree a b) (BinTree a b) deriving Show

--b) 
example :: BinTree (Int -> Bool) Char
example = 
    Node (\x -> x>4)
        (Node (\x -> x*x==0)
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
countInnerNodes (Node _ (c) (d)) = 1 + (countInnerNodes c) + (countInnerNodes d)


--d)
decodeInt
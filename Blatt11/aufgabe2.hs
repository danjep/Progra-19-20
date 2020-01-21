import Text.Show.Functions
--a)
data BinTree a b =  Blatt b | Node a (BinTree a b) (BinTree a b) deriving Show

--b) nicht korrekt
example :: BinTree (Int -> Bool) Char
example = 
    Node (x -> (x > 4))
        (Node (x -> ((x*x) == 0))
            (Blatt 'g')
            (Node (x -> x == 0)
                (Blatt 'u')
                (Blatt 'l')
            )
        )
        (Node (x -> x >= 7)
            (Blatt 'f')
            (Blatt 'i')
        )


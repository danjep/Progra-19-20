import Text.Show.Functions

-- a)

data BinTree a b = Node a (BinTree a b) (BinTree a b) | Leaf b deriving Show

-- b)

example :: BinTree (Int -> Bool) Char
example = Node (\x -> x > 4) (Node (\x -> x * x == x) (Leaf 'g') (Node (\x -> x == 0) (Leaf 'u') (Leaf 'l'))) (Node (\x -> x >= 7) (Leaf 'f') (Leaf 'i'))

-- c)

countInnerNodes :: BinTree a b -> Int
countInnerNodes (Leaf i) = 0
countInnerNodes (Node x c1 c2) = 1 + countInnerNodes c1 + countInnerNodes c2

-- d)

decodeInt :: (BinTree (Int -> Bool) b) -> Int -> b
decodeInt (Leaf i) _ = i
decodeInt (Node x c1 c2) n | x n        = decodeInt c2 n
                           | otherwise  = decodeInt c1 n

-- e)

decode :: (BinTree (Int -> Bool) b) -> [Int] -> [b]
decode bt xs = map (decodeInt bt) xs

-- f)

mapTree :: (b -> c) -> BinTree a b -> BinTree a c
mapTree f (Leaf i) = Leaf (f i)
mapTree f (Node x c1 c2) = Node x (mapTree f c1) (mapTree f c2)

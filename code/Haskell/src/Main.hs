type Set e = e -> Bool

empty :: Set e
empty = \e -> False

single :: (Ord e) => e -> Set e
single v = \e -> v == e

union :: Set e -> Set e -> Set e
union s1 s2 = \e -> (s1 e || s2 e)

inter :: Set e -> Set e -> Set e
inter s1 s2 = \e -> (s1 e && s2 e)

enum :: (Ord e) => [e] -> Set e
enum l = foldr (union . single) empty l
--enum v = \e -> any (== e) v

range :: (Ord e) => e -> e -> Set e
range x y = \e -> e >= x && e <= y

fibonacci :: [Int]
fibonacci = zipWith (+) (1:fibonacci) (0:1:fibonacci)
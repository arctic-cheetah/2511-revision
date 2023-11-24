# Q1)What are the compound nodes and the leaf nodes in this problem?
The composite(compound) nodes are the boolean operators and the leaf nodes are the boolean variables/values

# Q2)  Will you use keep the BooleanNode as an abstract class or use an interface to represent the composite type?
Boolean values never evalute anything and are leaf nodes, where as boolean operators operate on values and can connect to a leaf or compound node. Because of these distinctions, type safety is required and an interface should be used

# Q3)  In our factory, what are the different types of objects we need to create? What are the different fields they will have?

Node factory will need to product BooleanOperators and BooleanVariables.

BooleanOperators contain fields about the operator name,
left and right node

Boolean Variables contain fields about the boolean variable

# Core/Choice Exercise: The Art of Randomness
## Q1)How would you write tests for Game with the default constructor that prove the battle function works as expected?
It's given that random.nextDouble() is a uniform distribution.
As the limit of ROUNDS -> infinity, the probability of the player winning approaches 0.5, we must set the ROUNDS to be a very large number otherwise if the ROUNDS are small the data will be skewed and will produce a less desired tolerance 

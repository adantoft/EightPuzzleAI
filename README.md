# EightPuzzleAI
An Implementation of the Eight Puzzle and an AI to solve it.

Eight Puzzle is a simple tile/board game where there is a 9x9 board. On this board are 8 tiles numbered 1 through 8 and a blank space that can be used to move tiles to. When starting the game, the tiles are in random order. The idea is to order the numbers 1 through 8 in a clockwise spiral. For each move, there is a cost however. To move a piece, the cost of moving that piece is equal to it's number value. E.g. moving a 8 costs 8 and moving a 1 costs 1.

This project implements different search algorithms to solve the puzzle with the lowest cost. Methods used:

 - Breadth-first search
 - Depth-first search
 - Iterative depth-first search
 - Uniform cost search
 - Best-first search
 - A Star
 
The AI algorithm works by building a tree of possible moves (there are many!) until it finds the winning move set. Once the winning set it found, it traverses back up the tree to provide the sequence of moves.

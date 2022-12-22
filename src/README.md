# Tema 1 AA

Made by Maruntis Andrei, 323CA

## Archive structure

The files in this archive represent the following:

- `in/` - folder that contains the input files for tests
- `out/` - folder that contains the correct output files for tests
- `12.pdf` - documentation
- `Makefile` - makefile with rules:
  - `build` - compiles all java sources
  - `run-best` - runs best algorithm on the file `test.in`
  - `run-p*` - runs the corresponding algorithms on the file `test.in`; `* = 1, 2, 3`
  - `run-*-all` - runs all test and regenerates the output folder; `* = best, p1, p2, p3`
  - `tests` - generates a new set of tests
  - `clean` - cleansup folder (`.class` files)
- `*.java` - source files for the algorithms
  - `Test.java` - tests a single input file `test.in`
  - `Main.java` - tests a single output file `test.out`
  - `ShortestPathAlgorithm.java` - base class that inherits the algorithms
  - `Dijkstra.java`, `BellmanFord.java`, `FloydWarshall.java` - implementations of the algorithms
  - `RWOperations.java` - helper functions to read/write data
  - `TestGenerator.java`, `TestParams.java`, `type.java` - classes used by the test generator
- `README.md` - this file

## Evaluation details

I believe that `in/test30.in` is the most difficult graph, being a graph with 1000 nodes and density D=0.8 (800k edges). Therefore, I believe this test is most suitable for a competition.

Each run rule in the Makefile has the following algorithm associated:

- `run-best` - Floyd-Warshall
- `run-p1` - Dijkstra
- `run-p2` - Bellman-Ford
- `run-p3` - Floyd-Warshall

***Very important***: You need at least version 17 of the java compiler and jdk package to run this code, because of the enhanced switch in file `RWOperations.java`.

## Other notes

I have not used any code taken from the internet, I have only used the pseudocode presented in the documentation which has the corresponding references to the pages.
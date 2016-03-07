Name: Kassandra Smith (16180) & Aftab Hadimohd (16180)

EID: KSS2474 & AH35368

GROUP: #33

Main method: A4Driver.java

Analysis & Design: A4AnalysisDesign.pdf

Testing Explanation: A4AnalysisDesign.pdf

Link to github repo: https://github.com/kassandrasmith/422C-Assignment-4

Some notes:

- Within the main function there are two labelled blocks of code. If you wish to use a text file as input for the program, simply comment out the first block and uncomment the second, and set the variables within your IDE.

- We have chosen not to print a word twice in the case that the start and end word are the same. In this case, the word is only printed once since that is technically a word ladder between the two with no duplicated words.

- We changed the name from the given "Assign4Driver.java" to "A4Driver.java" in accordance with the assignment description 

- We realized that the depth first search we started off with was not as nice of a solution as the breadth first search (i.e. the ladder was too long). We included the dfs anyways, and it is possible to use dfs if you change line 55 of WordLadderSolver from .bfs to .dfs (NOT recommended)

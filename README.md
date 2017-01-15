<h2>Assignment 1 for CSCI 2110 (Computer Science 3 / Data Structures).</h2>

<p>This assignment is broken into 3 parts. The sailor coconut problem, a basic airport ticket program, and a calendar printer</p>

<h3>The Sailor Coconut Problem</h3>

<p>This program is about the sailor coconut problem described well here: https://qedinsight.wordpress.com/2011/05/13/the-coconut-problem/. Except in this program it is generalized to be any number of sailors, and it checks if an amount of coconuts is valid for that number of sailors, as well as checking for the minimum amount of coconuts is a valid solution.</p>

Sample output (work in progress):
<pre>
Minimum coconuts required for the given amount 
of sailors (using equation) (-1 means no solution). 
Overflows long data type after 15 sailors.
0 sailors requre at-least 1 coconuts.
1 sailors requre at-least -1 coconuts.
2 sailors requre at-least 7 coconuts.
3 sailors requre at-least 79 coconuts.
4 sailors requre at-least 1021 coconuts.
5 sailors requre at-least 15621 coconuts.
6 sailors requre at-least 279931 coconuts.
7 sailors requre at-least 5764795 coconuts.
8 sailors requre at-least 134217721 coconuts.
9 sailors requre at-least 3486784393 coconuts.
10 sailors requre at-least 99999999991 coconuts.
11 sailors requre at-least 3138428376711 coconuts.
12 sailors requre at-least 106993205379061 coconuts.
13 sailors requre at-least 3937376385699277 coconuts.
14 sailors requre at-least 155568095557812211 coconuts.
15 sailors requre at-least 6568408355712890866 coconuts.

Minimum coconuts required for the given amount of sailors 
(using equation (returning double))(-1 means no solution). 
Overflows double datatype after 142 sailors (says it needs infinity for above this amount).
130 sailors requre at-least 8.444601346842961E276 coconuts.
131 sailors requre at-least 3.0186379424408025E279 coconuts.
132 sailors requre at-least 1.0872585971054743E282 coconuts.
133 sailors requre at-least 3.94566209404562E284 coconuts.
134 sailors requre at-least 1.4426061498089571E287 coconuts.
135 sailors requre at-least 5.3136447444563465E289 coconuts.
136 sailors requre at-least 1.971652831166526E292 coconuts.
137 sailors requre at-least 7.369504147092458E294 coconuts.
138 sailors requre at-least 2.774552901440993E297 coconuts.
139 sailors requre at-least 1.0521363751462146E300 coconuts.
140 sailors requre at-least 4.018398755326557E302 coconuts.
141 sailors requre at-least 1.5456601034317698E305 coconuts.
142 sailors requre at-least 5.987330706257361E307 coconuts.
143 sailors requre at-least Infinity coconuts.

Minimum coconuts required for the given amount of sailors 
(using recursive method repeatedly) (-1 means no solution). 
Overflows int datatype after 8 sailors.
0 sailors requre at-least 1 coconuts.
1 sailors requre at-least -1 coconuts.
2 sailors requre at-least 7 coconuts.
3 sailors requre at-least 79 coconuts.
4 sailors requre at-least 1021 coconuts.
5 sailors requre at-least 15621 coconuts.
6 sailors requre at-least 279931 coconuts.
7 sailors requre at-least 5764795 coconuts.
8 sailors requre at-least 134217721 coconuts.

Some sample values below:
FAILURE!!! 2 sailors and 6 coconuts is not valid!
SUCCESS!!! 2 sailors and 7 coconuts is valid!
FAILURE!!! 2 sailors and 8 coconuts is not valid!
FAILURE!!! 2 sailors and 9 coconuts is not valid!
FAILURE!!! 2 sailors and 14 coconuts is not valid!
SUCCESS!!! 2 sailors and 15 coconuts is valid!
FAILURE!!! 2 sailors and 16 coconuts is not valid!
FAILURE!!! 2 sailors and 17 coconuts is not valid!
FAILURE!!! 2 sailors and 22 coconuts is not valid!
SUCCESS!!! 2 sailors and 23 coconuts is valid!</pre>

<h3>The Airport Ticket System</h3>

<p>WIP</p>
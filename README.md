<h2>Assignment 1 for CSCI 2110 (Computer Science 3 / Data Structures).</h2>

<p>This assignment is broken into 3 parts. The sailor coconut problem, a basic airport ticket program, and a calendar printer.</p>

<h3>The Sailor Coconut Problem</h3>

<p>This program is about the sailor coconut problem described well here: https://qedinsight.wordpress.com/2011/05/13/the-coconut-problem/. Except in this program it is generalized to be any number of sailors, and it checks if an amount of coconuts is valid for that number of sailors, as well as checking for the minimum amount of coconuts that is a valid solution.</p>

Sample output:
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

<p>This program has nothing special in it, it just has basic functionality and does nothing exciting.</p>

Sample output:
<pre>
The following is a ticket:
Ryan, Flight 128, Washington to Lisbon, 02/02/2017 08:00 AM, $589.77

This is the info of that passenger:
Ryan, 123 Fake Street, #328653, 6 points

Oops, that is the wrong passenger, better change that:
Bob, Flight 128, Washington to Lisbon, 02/02/2017 08:00 AM, $589.77

Oh wait, the flight is supposed to be PM not AM:
Bob, Flight 128, Washington to Lisbon, 02/02/2017 08:00 AM, $589.77

The following is the info on the passenger who bought this ticket:
Bob, 321 Real Street, #23435, 6 points

This is the information on the other customer:
Ryan, 123 Fake Street, #328653, 0 points

This advanced system automatically dealt with the points 
appropriately when the passenger on the ticket changed

I just realized that the passengers name is Schlog, not Bob, now to change it:
Schlog, 321 Real Street, #23435, 6 points

Wow, that is totally the wrong flight, here is the proper one:
Flight 643, Athens to Cape Town, 01/20/2017 03:00 AM

And the ticket again:
Schlog, Flight 643, Athens to Cape Town, 01/20/2017 03:00 AM, $589.77

It turns out that Ryan guy actually wants to 
go to Lisbon, so we will give him a new ticket for that 
old flight (at a discount). Here is that new ticket for Ryan:
Ryan, Flight 128, Washington to Lisbon, 02/02/2017 08:00 AM, $204.69

Here you see Ryan's point updated too:
Ryan, 123 Fake Street, #328653, 0 points

Lets bump Ryan's flight up to be on April 1.
Ryan, Flight 128, Washington to Lisbon, 02/02/2017 08:00 AM, $204.69

Nothing changed because it was an invalid format.
The Regex caught it. Lets make it proper now:
Ryan, Flight 128, Washington to Lisbon, 04/01/2017 05:00 PM, $204.69

Out of curiosity, lets see what a default flight looks like:
Flight -1, Unknown to Unknown, 01/01/2017 00:00 AM
Noice</pre>

<h3>The Calendar</h3>

<p>This program prints out a text based calendar, with the desired dimensions (of months) and short or long month names.</p>

Sample output:
<pre>
Calendar for 2017
      January                February                March                  April           
 S  M  T  W  T  F  S    S  M  T  W  T  F  S    S  M  T  W  T  F  S    S  M  T  W  T  F  S   
 1  2  3  4  5  6  7             1  2  3  4             1  2  3  4                      1   
 8  9 10 11 12 13 14    5  6  7  8  9 10 11    5  6  7  8  9 10 11    2  3  4  5  6  7  8   
15 16 17 18 19 20 21   12 13 14 15 16 17 18   12 13 14 15 16 17 18    9 10 11 12 13 14 15   
22 23 24 25 26 27 28   19 20 21 22 23 24 25   19 20 21 22 23 24 25   16 17 18 19 20 21 22   
29 30 31               26 27 28               26 27 28 29 30 31      23 24 25 26 27 28 29   
                                                                     30                     
        May                    June                   July                  August          
 S  M  T  W  T  F  S    S  M  T  W  T  F  S    S  M  T  W  T  F  S    S  M  T  W  T  F  S   
    1  2  3  4  5  6                1  2  3                      1          1  2  3  4  5   
 7  8  9 10 11 12 13    4  5  6  7  8  9 10    2  3  4  5  6  7  8    6  7  8  9 10 11 12   
14 15 16 17 18 19 20   11 12 13 14 15 16 17    9 10 11 12 13 14 15   13 14 15 16 17 18 19   
21 22 23 24 25 26 27   18 19 20 21 22 23 24   16 17 18 19 20 21 22   20 21 22 23 24 25 26   
28 29 30 31            25 26 27 28 29 30      23 24 25 26 27 28 29   27 28 29 30 31         
                                              30 31                                         
     September               October                November               December         
 S  M  T  W  T  F  S    S  M  T  W  T  F  S    S  M  T  W  T  F  S    S  M  T  W  T  F  S   
                1  2    1  2  3  4  5  6  7             1  2  3  4                   1  2   
 3  4  5  6  7  8  9    8  9 10 11 12 13 14    5  6  7  8  9 10 11    3  4  5  6  7  8  9   
10 11 12 13 14 15 16   15 16 17 18 19 20 21   12 13 14 15 16 17 18   10 11 12 13 14 15 16   
17 18 19 20 21 22 23   22 23 24 25 26 27 28   19 20 21 22 23 24 25   17 18 19 20 21 22 23   
24 25 26 27 28 29 30   29 30 31               26 27 28 29 30         24 25 26 27 28 29 30   
                                                                     31  </pre>
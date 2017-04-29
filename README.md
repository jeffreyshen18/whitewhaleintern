# Intern challenge for White Whale

**Code Challenge: Gibberish Algorithm**
---------------------------------------

Challenge Overview
------------------

We are exticed taht you are intsereted in joiinng Wihte Wahle for the smumer.  Weoclme to yuor fsrit prommarging chanellge.  Yuor chnellage is to courtsnct a prrgoam taht tekas an Enilgsh txet snirtg as iupnt and rerutns rebadale giirebbsh lkie tihs.  It dseno’t mtaetr in waht oerdr the ltteres in a wrod are, but an iproamtnt tihng is taht the frsit and lsat ltteer be in the rghit pclae. The rset can be a taotl mses and you can sitll raed it whotuit a pboerlm.  Tihs is bcuseae the huamn mnid deos not raed ervey lteter by istlef, but the wrod as a wlohe.

**The Basics:**

  - You may use *almost any* programming language... it's your choice.  See the supported options [here](http://ideone.com/).
  - Your program should leave the first and last letter of each word in place and scramble the rest.
  - Your program should not scamble punctuation (.,-'...etc.), numbers, or upper-case abbreviations.
  - See the [/text_files] folder for sample text files.

**Input/Output:**

  - Name your program as follows: `gibgen.xx` (where xx is variable based on the language you choose)
  - Your program should be able to read text input from a string passed into STDIN
      - `gibgen.xx "This is a String"`
      - `cat mystringfile.txt | gibgen.xx`
  - Your program should output to the console.

_Note: This challenge is based on a popular word gibberish meme. You can improve the readability by looking at a [researcher's take](http://www.mrc-cbu.cam.ac.uk/people/matt.davis/cmabridge/) on the truths/myths of this meme, but this is not required._

What to do
----------
1. [Download](http://git-scm.com/downloads) & install Git on your machine

2. <a href="https://github.com/trentgillham/whitewhaleintern#fork-destination-box" class="btn grouped" data-method="POST" rel="nofollow" title="Fork">Fork</a> this project - Go [here](https://github.com/trentgillham/whitewhaleintern) and click the "Fork" button (located on the upper-right side of the screen)

2. Clone your new fork'd repository to your local machine - `git clone https://github.com/trentgillham/whitewhaleintern.git`
3. Complete the code challenge and fill out the Quick Start & Questions in the the README (see below)
4. `git add` and `git commit` your local repository as you go
4. Push your code and README back to Github occasionally - `git push origin master`
5. Email [gillham@whitewhaleanalytics.com](mailto:gillham@whitewhaleanalytics.com) with the Commit URL to your fork'd repository that you want reviewed. It should include at least 2 files: (1) your updated README with Coding Questions answered, and (2) your program (gibgen.xx)
   - Copy and paste the URL into the email along with your name... it should look something like this:
       - https://github.com/YOUR_USERNAME_HERE/whitewhaleintern.git

_Note: If you have any questions, email [gillham@whitewhaleanalytics.com](mailto:gillham@whitewhaleanalytics.com)._

Judging Criteria
----------------

Your responses to the **Coding Questions** at the bottom of this README are the *Most Important* part of this challenge. A working, fully fault-tolerant program that we just can't break, albeit awesome, is the least important.  Why is that?  Remember, we don't expect you to be expert programmers (just yet)... We want to see how you think through a problem.  


For completion by applicant
===========================

Quick Start
-----------

* After compiling gibgen.java by inputting "javac gibgen.java", executing the program by inputting "java gibgen" will prompt the user the enter a text-string input. After the user enters a text-string input, the program will return the scrambled text-string output
* Java was used to solve this problem

Coding Questions
----------------

Question 1: "How did you approach the problem?" (500 words or less)

To solve this problem, I used the Fisher-Yates algorithm to scramble the specified letters in each word when needed. The initial string input was converted to an array of chars by splitting the string into elements around matches of an empty space. As a result, some elements in the array would contain punctuations, numbers and upper-case abbreviations. A series of if-else statements were executed next to check if the Fisher-Yates algorithm was required to scramble the appropriate letters for each element in the array. If the element was a four-character word with no punctuations, the middle characters would simply be swapped and printed. If the string was a number or if it was smaller than 4 characters, it would not be scrambled and the element would be converted to a string and printed. However, if the element was greater than 4 characters, the Fisher-Yates algorithm would be implemented.

Before implementing the Fisher-Yates algorithm, integer values were calculated to calibrate the algorithm so that for each element, it would leave the first and last letter of each word in place, while scrambling the rest of the characters and leaving punctuations, numbers, and upper-case abbreviations unmodified. If the element did not contain punctuations at the beginning or end of the element, the default value of frontOffSet would be set to 1 and the default value of backOffSet would be set to 2.  

The Fisher-Yates algorithm was adopted in a way such that the first index was set to the second last letter of the word, and the index would increment down to the third letter of the word. Depending on the offset integer values, the starting and ending index of each element would vary. A random index is generated from a range between the current index to the second letter of the word, and then the character of that random index is swapped with the character of the current index. As a result, the algorithm would continuously generate a random index for which the current index can be exchanged for while keeping the first and last letters in place. However, there was a likelihood that a word could be left unscrambled due to randomness so the algorithm was embedded within a while-loop. The loop will exit once the string returned after the shuffle algorithm differed from the original input string or if the word was an upper-case abbreviation. Once the loop exited, the scrambled string would be printed to output and the program would continue reading from the array until the last element.

Question 2: "What was the most difficult aspect of the solution?" (500 words or less)

The most difficult aspect about this solution was figuring out how to scramble the correct letters when elements of the char array contained punctuations, numbers and upper-case abbreviations.  To tackle this problem, I created two instance variables that would be adjusted based on the number of punctuations before and after the word. These two instance variables (frontOffSet and BackOffSet) were then implemented into the Fisher-Yates algorithm to correctly calibrate the range of indices that would be scrambled to ensure that the first and last letters of the word remained in the same place. To ensure that numbers, punctuations, and upper-case abbreviations were also left in place, I embedded an if-statement in the algorithm such that a swap would only occur if the characters were lower-case.

Another challenging aspect about the solution was figuring out how to check each element to ensure that it was properly scrambled. Due to the random nature of the algorithm, some words were swapped in a way such that the outcome produced was identical to the input. Initially, I implemented a while-loop in the algorithm that would exit after confirming that the output string was different from the input string. However, I noticed that the program would loop infinitely after it encountered a number or an upper-case abbreviation. To solve this issue, I implemented an if-else statement before the algorithm that would print the original unscrambled input if the element was detected to be a number. If the element was an upper-case abbreviation, the algorithm would not swap any of its characters, thus it initially caused an infinite loop since the input was the same as the output. Adding a conditional in the while-loop that checked if the element was an upper-case abbreviation solved this problem.

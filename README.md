# Anagram Finder
A simple command line utility for finding anagrams in a specified file

## Software required to run this
* Java 17

## Building and Running the tests
```
./gradlew clean build
```

## Running the program
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams

## My approach

Considering that we may not have the memory available to immediately process 
the entire input file, I utilised the BufferReader to split the file into 
groups based on the character length of each word. 
The groups are then processed one by one, with the characters of each string 
being sorted and anagrams added to the output string.

## Big O analysis
Where n = total number of words 
      k = num of chars in word

Space complexity = O(n * k) as we only store each word once times the number 
of chars in the word.
Time complexity = O(n * k log k) as we process n words and sort them by 
length k

## Improvements for the future
- Improved sorting algorithm to allow consideration for duplicates, if a 
duplicate is detected we shouldn't waste time sorting chars again. Could 
also add support for unordered file input with a more complex algorithm.
- Further testing including consideration for case sensitivity and invalid 
string inputs in files
- Output resulting anagrams to one or many files, depending on the intention 
of the script


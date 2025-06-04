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

I chose to break the task into separate stages. Considering that we may 
not have the memory available to immediately process the entire input file,
I added an inputFileProcessor to split the file into multiple files based 
on the character length of each word. These files are temporary and deleted 
after anagram finding has complete.
The grouped files are then processed one by one, with the characters of each 
string being sorted and matches added to the output string.

## Big O analysis
Where n = total number of words 
      k = num of chars in word

Space complexity = O(n) as we only store each word once. While new strings 
and files are created they are not kept.
Time complexity = O(n * k log k) as we process n words and sort them by 
length k

## Improvements for the future
- Avoid creation of temporary files and store temp groupings in memory
- Improved sorting algorithm to allow consideration for duplicates, if a 
duplicate is detected we shouldn't waste time sorting chars again
- Further testing including consideration for case sensitivity and invalid 
string inputs in files
- Output resulting anagrams to one or many files, depending on the intention 
of the script
- Additionally, if I had more time I would have made use of Spring's dependency 
injection functionality rather than declaring new instances


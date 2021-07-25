// https://leetcode.com/problems/word-frequency

# Read from the file words.txt and output the word frequency list to stdout.


perl -0777 -lape's/\s+/\n/g' words.txt | sort | uniq -c | sort -nr | awk '{print $2, $1}'

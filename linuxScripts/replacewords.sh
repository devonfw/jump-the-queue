#!/bin/bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 3 ]; then
  echo "Usage: $0 <file> <word_to_replace> <replacement_word>"
  exit 1
fi

# Assign command line arguments to variables
file="$1"
word_to_replace="$2"
replacement_word="$3"

# Check if the file exists
if [ ! -e "$file" ]; then
  echo "Error: File $file does not exist."
  exit 1
fi

# Perform the replacement and create a backup of the original file
sed -i.bak "s/\b$word_to_replace\b/$replacement_word/g" "$file"

echo "Replacement complete. Original file backed up as $file.bak"

#!/bin/bash

echo "Logged-in users and their information:"

# Loop through each logged-in user
who | while read -r line; do
  # Extract username from the 'who' command output
  username=$(echo "$line" | awk '{print $1}')

  # Use 'finger' to get the user information
  finger_output=$(finger "$username" 2>/dev/null)

  # Check if the 'finger' command was successful
  if [ $? -eq 0 ]; then
    # Extract real name and last login information
    real_name=$(echo "$finger_output" | awk -F 'Name: ' 'NF>1{print $2}' | awk '{print $1, $2, $3}')
    last_login_info=$(echo "$finger_output" | awk -F 'On since ' 'NF>1{print $2}' | awk '{print $1, $2, $3, $4}')

    # Display the information
    echo "Username: $username"
    echo "Real Name: $real_name"
    echo "Last Login: $last_login_info"
    echo "-------------------------"
  fi
done

exit 0


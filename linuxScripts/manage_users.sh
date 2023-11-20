#!/bin/bash

# Get a list of all users on the system
all_users=$(cut -d: -f1 /etc/passwd)

# Sort the users alphabetically
sorted_users=$(echo "$all_users" | sort)

# Get the first 5 users alphabetically
first_five_users=$(echo "$sorted_users" | head -n 5)

# Get the last logged-in user
last_logged_in=$(who | awk '{print $1}' | tail -n 1)

# Remove the last logged-in user from the list
users_to_display=$(echo "$first_five_users" | grep -v "$last_logged_in")

# Print the users
echo "First 5 users alphabetically (excluding the last logged-in user):"
echo "$users_to_display"

# Print the removed user and the date they last logged in
last_login_info=$(finger "$last_logged_in" 2>/dev/null | awk -F 'On since ' 'NF>1{print $2}' | awk '{print $1, $2, $3, $4}')
echo "Removed user: $last_logged_in"
echo "Last login: $last_login_info"

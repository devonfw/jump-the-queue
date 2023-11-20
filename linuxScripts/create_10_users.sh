#!/bin/bash

# Function to generate a random real-sounding name
generate_real_name() {
    first_names=("John" "Alice" "Bob" "Emily" "Charlie" "Olivia" "Daniel" "Sophia" "Ethan" "Emma")
    last_names=("Smith" "Johnson" "Williams" "Jones" "Brown" "Davis" "Miller" "Wilson" "Moore" "Taylor")

    # Randomly select a first and last name
    first_name=${first_names[$((RANDOM % ${#first_names[@]}))]}
    last_name=${last_names[$((RANDOM % ${#last_names[@]}))]}

    echo "$first_name $last_name"
}

# Create 10 users
for i in {1..10}; do
    # Generate a random real-sounding name
    full_name=$(generate_real_name)

    # Create the user and set the password
    username="user$i"
    useradd -m -c "$full_name" $username
    echo "$username:password$i" | chpasswd

    # Display information about the created user
    echo "User $username created: $full_name"
done

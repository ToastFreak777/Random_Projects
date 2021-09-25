secretWord = "spongebob"
guess = ""
counter = 0

copy = []

# making a copy of the secret word and filling in all but two postions of the string with "_"
for i in secretWord:
    if i == secretWord[0]:
        copy.append(i)
    elif i == secretWord[2]:
        copy.append(i)
    else:
        copy.append("_")

# main loop
while guess != secretWord:
    if counter == 1:
        print("Hint: " + copy[0])
    elif counter == 2:
        print("Hint: ")
        print(copy)
    elif counter == 3:
        print("You lose")
        break

    guess = input("Enter guess: ")

    counter += 1

if guess == secretWord:
    print("You win!")

def translator(phrase):
    translated = ""

    for letter in phrase:
        if letter.lower() in "aeiou":
            if letter.isupper():
                translated = translated + "G"
            else:
                translated = translated + "g"

        else:  # I have just experienced my first indentation error [this might become a problem...I though it was the code not the indentation]
            translated = translated + letter

    return translated


print(translator(input("Enter a phrase: ")))

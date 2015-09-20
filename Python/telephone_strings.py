class Numbers:

    TWO = ("A", "B", "C")
    THREE = ("D", "E", "F")
    FOUR = ("G", "H", "I")
    FIVE = ("J", "K", "L")
    SIX = ("M", "N", "O")
    SEVEN = ("P", "Q", "R", "S")
    EIGHT = ("T", "U", "V")
    NINE = ("W", "X", "Y", "Z")

    @staticmethod
    def get_letters(digit):
        if digit == "2":
            return Numbers.TWO
        elif digit == "3":
            return Numbers.THREE
        elif digit == "4":
            return Numbers.FOUR
        elif digit == "5":
            return Numbers.FIVE
        elif digit == "6":
            return Numbers.SIX
        elif digit == "7":
            return Numbers.SEVEN
        elif digit == "8":
            return Numbers.EIGHT
        elif digit == "9":
            return Numbers.NINE


def convert(number, string, index):
    if index == len(number):
        print string
        return
    elif number[index] == "1" or number[index] == "0":
        convert(number, string + number[index], index + 1)
    else:
        letters_tuple = Numbers.get_letters(number[index])
        for i in range(len(letters_tuple)):
            convert(number, string + letters_tuple[i], index + 1)


convert("231", "", 0)

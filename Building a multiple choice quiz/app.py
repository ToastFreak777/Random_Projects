from Questions import Questions
from math import *

questionPromts = [
    "What's 2 + 2?\n a) 2\n b) 4\n c) 6\n\n",
    "What's 2 ^ 4?\n a) 8\n b) 4\n c) 16\n\n",
    "What's sqr(100) * 2^3?\n a) 40\n b) 80\n c) 64\n\n",
]

questions = [
    Questions(questionPromts[0], "b"),
    Questions(questionPromts[1], "c"),
    Questions(questionPromts[2], "b"),
]


def runTest(questions):
    score = 0
    grade = 0

    for testQuestions in questions:
        answer = input(testQuestions.prompt)
        if answer == testQuestions.answer:
            score += 1
            if grade < 60:
                grade += 33.33
                grade = floor(grade)
            else:
                grade += 33.33
                grade = ceil(grade)

    if score == 1:
        print(
            "You failed the quiz you got a "
            + str(grade)
            + " out of 100. "
            + str(score)
            + "/"
            + str(len(questions))
        )
    elif score == 2:
        print(
            "You failed the quiz you got a "
            + str(grade)
            + " out of 100. "
            + str(score)
            + "/"
            + str(len(questions))
        )
    else:
        print(
            "You pass! You got a "
            + str(grade)
            + " out of 100. "
            + str(score)
            + "/"
            + str(len(questions))
        )


runTest(questions)

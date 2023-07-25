import math
def addizione (number1,number2):
    return number1+number2
def sottrazione (number1,number2):
    return number1-number2
def divisione (number1,number2):
    return number1/number2
def moltiplicazione (number1,number2):
    return number1*number2
def radice (number1,number2):
    return math.sqrt(number1)
def potenza (number1,number2):
    return number1**number2
def percentuale (number1,number2):
    return number1/100*number2


x= input("che tipo di calcolo vuoi fare? ").capitalize()
number1 =float(input("scrivi il primo numero: "))
if x == "Addizione":
    print("la tua addizione è: "+str(addizione(number1,number2)))
elif x == "Sottrazione":
    print("la tua sottrazione è: "+str(addizione(number1,number2)))
elif x == "Divisione":
    print("la tua divisione è: "+str(addizione(number1,number2)))
elif x == "Moltiplicazione":
    print("la tua moltiplicazione  è: "+str(addizione(number1,number2)))
elif x == "Radice":
    print("la tua radice è: "+str(addizione(number1,number2)))
if x == "Potenza":
    print("la tua potenza è: "+str(addizione(number1,number2)))
if x == "Percentuale":
    print("la tua percentuale è: "+str(addizione(number1,number2)))
else:
    print("non valido")
spesa=[]#creiamo la lista spesa
"""input("inserisci cosa mettere nella lista della spesa:"spesa.append())
print(spesa)"""
while True:
    scelta= int(input("Scrivi 1 per inserire un oggetto alla lista, altrimenti scrivi 0 per terminare:"))
    if scelta==1:
        aggiungiSpesa= input("inserisci coosa mettere nella lista della spesa:")
        spesa.append(aggiungiSpesa)
        print(spesa)
    elif scelta==0:
        print("la tua scelta è: " + str(spesa))
        break    
listaAcquisti= [] #creiamo la lista acquisti
while True:
    scelta2= int(input("premi 1 per confermare, premi 0 per terminare: "))
    if scelta2 ==1:
        acquisti= input("cosa vuoi acquistare: ")
        spesa.remove(acquisti)
        listaAcquisti.append(acquisti)
        print(spesa)
        print("hai comprato:  " +str(listaAcquisti))
    elif scelta2==0:
        print("programma concluso.")
        break 
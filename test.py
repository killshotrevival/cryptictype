import random



def str_gen():
    str = "!@#$%"
    for j in range(100):
        retstr = ""
        k=0
        while k<5:
            i = random.randint(0,4)
            if str[i] not in retstr:
                retstr = retstr+str[i]
                k=k+1
        print(retstr)

str_gen()

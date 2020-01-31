import random



#global variable/s
mainstr_length = 10

#function to genrate the main string
def mainstr():
    mainstr = ""
    stri = ['~', '!', '@', '#', '$', '%', '^', '&', '-', '_']
    k=0
    while k<5:
        i = random.randint(0, mainstr_length-1)
        if stri[i] not in mainstr:
            mainstr = mainstr+stri[i]
            k=k+1
    return mainstr 

#function to genrate the random string 
def str_gen(dic,stri):
    retstr = ""
    k=0
    flag = 0
    while k<5:
        i = random.randint(0,4)
        if stri[i] not in retstr:
            retstr = retstr+stri[i]
            k=k+1
    for data in dic.values():
        if data==retstr:
            flag = 1
            break
    if flag==0:
        if retstr == None:
            return(str_gen(dic,stri))
            
        else:
            return retstr    
    else:
        return(str_gen(dic,stri))

#method for checking if the alphabet is already taken
def alpha_avail(dic, c):
    flag=1
    for key in dic:
        if key==c:
            flag = 0
    return flag

#method will return the code for an alphabet
def ret_code(dic, c):
    for key in dic:
        if key==c:
            return dic[key]

#decryption method
def decryption(dic, stri):
    final_str=""
    for i in range(len(stri)//5):
        s = stri[i*5:(i*5)+5]
        for key, value in dic.items():
            if value==s:
                final_str = final_str+key
                break
    return final_str
    

if __name__=="__main__":
    dataset = {}
    enc_str = ""
    input_str = input()
    if input_str:

        #genrate the main string
        main_str = mainstr()
        print("Main String = " + main_str)

        #genarte the encryptic string and the dataset
        for i in input_str:
            ran_str = str_gen(dataset, main_str)
            if alpha_avail(dataset, i):
                    dataset[i] = ran_str
                    enc_str = enc_str+str(ran_str)

            else:
                a_code = ret_code(dataset, i)
                enc_str = enc_str+str(a_code)

        print("Encrptic string")
        print(enc_str)    

        print("Data Set Values")
        for key, values in dataset.items():
            print(key, end='=')
            print(values)
        
        print("Do you want to decryptic the string:-y/n")
        ans = input()
        if(ans=='y'):
            s = decryption(dataset, enc_str)
            print(s)

        elif(ans=='n'):
            print("Thank You")

        else:
            print("Not A valid Input Thank You")

                    
                    



        
# CSV (Comma Separated Value)

import csv
# csv write
with open("sspy1.csv",'w',encoding="utf-8") as csvfile:
    sspy1_writer = csv.writer(csvfile, delimiter=',')
    sspy1_writer.writerow(["Joshua","joshua@gmail.com","01095900982","sspy1","ME"])

s=[]
#csv read
with open("sspy1.csv",'r',encoding="utf-8") as csvfile:
    sspy1_reader=csv.reader(csvfile,delimiter=',')
    for line in sspy1_reader:
        s.append(line)
print(s)

#csv read2
with open("sspy1.csv",'r',encoding="utf-8") as csvfile:
    for line in csvfile:
        s.append(line)
print(s)


# csv append
with open("sspy1.csv",'a',encoding="utf-8") as csvfile:
    sspy1_writer = csv.writer(csvfile, delimiter=',')
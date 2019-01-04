import os
#zzu.li/file
os.chdir('./list/SSAFY/')
#os.chdir(r'c:\Users\student\chatbot\day1\list\SSAFY\')
current_path=os.getcwd()

file_list=os.listdir('.')

prefix='ssafy_'

for jmi in file_list:
    os.rename(jmi,jmi[6:])
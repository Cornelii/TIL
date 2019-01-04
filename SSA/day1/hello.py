import webbrowser as wb
'''
url="https://scholar.google.co.kr/scholar?hl=ko&as_sdt=0%2C5&q="
#wb.open(url)
#wb.open_new(url)
search_list=['GAN','SuperResol','RNN']
for key in search_list:
    wb.open_new(url+key)
'''
#1 Mission 1
# Webbrowser, "ssafy", 'samsung','sw','coding'

url='https://www.google.com/search?hl=ko&source=hp&ei=00QXXOnFM4qp8QWRw4KgBA&q='
search_list=['ssafy','samsung','sw','coding']
for key in search_list:
    wb.open_new(url+key)

# 
import requests
from requests import get
from IPython.display import display
from bs4 import BeautifulSoup as bs
import pandas as pd
import numpy as np
from time import sleep
from random import randint

row_data = [] #store rows info

pages = np.arange(1,9,1)

for page in pages:

    page = requests.get("https://www.worldathletics.org/records/all-time-toplists/sprints/100-metres/outdoor/men/u20?regionType=world&timing=electronic&windReading=regular&page=" + str(page) + "bestResultsOnly=false&firstDay=1896-04-06&lastDay=2021-07-08")
    # soup
    soup = bs(page.text, 'lxml')

    table_body = soup.find('table')

    for row in table_body.find_all('tr'):
        col = row.find_all('td')
        col = [ele.text.strip() for ele in col]
        row_data.append(col)
        
sleep(randint(2,5))

df = pd.DataFrame(row_data)
df.to_csv('Men_U20_History_All_Time_Results_100M.csv')

#display(df)
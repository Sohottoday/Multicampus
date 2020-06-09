import requests
from pprint import pprint

def mask(address, n=10):
    params = f'?address={address}'
    URL = 'https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByAddr/json'

    response = requests.get(URL+params)
    #print(response.content)
    #print(URL+params)
    stores = response.json().get('stores')[:n]
    #print(stores)

    #for store in stores:
        #pprint(store)
    #    print(store.get('name'))

    #plenty_store = []
    #for store in stores:
    #    if store.get('remain_stat') == 'plenty':
    #        plenty_store.append(store.get('name'))
    #print(plenty_store)

    for store in stores:
        if store.get('remain_stat') == 'plenty':
            color = 'green'
        elif store.get('remain_stat') == 'some':
            color = 'yellow'
        elif store.get('remain_stat') == 'few':
            color = 'red'
        else:
            color = 'gray'
        print(store.get('name'),' : ', color)

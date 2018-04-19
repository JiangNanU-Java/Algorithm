import requests
import json

headers = {
    'Cookie':'_ga=GA1.2.821256325.1523163002; _octo=GH1.1.1967472400.1523163002; logged_in=yes; dotcom_user=kevinten10; _gat=1',
    'User_Agent':'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36'
}

f = open('D:/weibo-xdy.txt','a+',encoding='utf-8')

def get_info(url,page):
    html = requests.get(url,headers=headers)
    json_data = json.loads(html.text)
    card_groups = json_data[0]['card_group']
    for card_group in card_groups:
        f.write(card_group['mblog']['text'].split(' ')[0]+'\n')

    next_cursor = json_data[0]['next_cursor']

    if page<50:
        next_url = 'https://m.weibo.cn/index/friends?format=cards&next_cursor='+str(next_cursor)+'&page=1'
        page = page + 1
        get_info(next_url,page)
    else:
        pass
        f.close()

if __name__ == '__main__':
    url = 'https://weibo.com/u/2726494681'
    get_info(url,1)

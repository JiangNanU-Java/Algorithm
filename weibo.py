import requests
import json
# 输入你的浏览器数据
headers = {
    'Cookie':'',
    'User_Agent':''
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

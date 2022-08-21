import pywifi
import time
from pywifi import const
import pymysql

# WiFi扫描模块
def wifi_scan():
    # 初始化wifi
    wifi = pywifi.PyWiFi()
    # 使用第一个无线网卡
    interface = wifi.interfaces()[0]
    # 开始扫描
    interface.scan()
    for i in range(3):
        time.sleep(1)
    # 扫描结果，scan_results()返回一个集，存放的是每个wifi对象
    bss = interface.scan_results()
    # 存放wifi名的集合
    wifi_set = set()
    for w in bss:
        # 解决乱码问题
        #wifi_signal =(w.signal,w.ssid.encode('raw_unicode_escape').decode('utf-8'))
        wifi_signal =w.signal
        wifi_set.add(wifi_signal)
    # 存入列表并按信号排序
    wifi_list = list(wifi_set)
    wifi_list.sort(reverse=True)

    # 格式化输出

    str1=''.join(str (wifi_list))
    str2=str1.replace('[','')
    str2 = str2.replace(']', '')

    print('\r{}'.format(str2))


    print('-' * 38)
    # 返回wifi列表
    return str2

def get_conn():
    conn=pymysql.connect(host='localhost',user='root',password='147896',db='fingerprint');
    return conn

def update(sql,args):
    conn=get_conn()
    cursor=conn.cursor()
    result=cursor.execute(sql,args)
    #print(result)
    conn.commit()  # 提交数据
    cursor.close()
    conn.close()


# 主函数
def main():
    id=0
    while True:
        sql = 'update paste set type=%s where num=%s;'
        args=(wifi_scan(),1)
        sql1='insert into prepare(id,type) values(%s,%s)'
        args1=(id,wifi_scan())
        update(sql,args)
        #id+=1
        time.sleep(1)



if __name__ == '__main__':
    main()
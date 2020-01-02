# 配置本地yum源
参考：  
1. [CentOS 挂载并配置本地ISO软件源](https://blog.csdn.net/pwb1994001/article/details/80730581)

### 1. 下载ISO  
下载对应自己Centos版本的everything.iso文件，[https://www.centos.org/download/mirrors/](https://www.centos.org/download/mirrors/)  
好像改成了只保存最新版本的iso文件，需要在网络上再找
这里用的是centos7-1511，[传送门](http://ftp.iij.ad.jp/pub/linux/centos-vault/7.2.1511/isos/x86_64/)
### 2.挂载ISO文件
`mount /root/CentOS-7-x86_64-Everything-1511.iso /media/CentOS/`  
注：这里本来使用的是`/media/centos/`，但后面出了一个错，虽然经过后来的总结，不是这个的原因，但为了避免麻烦，尽量中规中矩的来
### 3.查看挂载状态
```
[root@cdh01 yum.repos.d]# df -h
Filesystem               Size  Used Avail Use% Mounted on
/dev/mapper/centos-root   50G   20G   31G  40% /
devtmpfs                 7.8G     0  7.8G   0% /dev
tmpfs                    7.8G     0  7.8G   0% /dev/shm
tmpfs                    7.8G  8.6M  7.8G   1% /run
tmpfs                    7.8G     0  7.8G   0% /sys/fs/cgroup
/dev/loop0               4.1G  4.1G     0 100% /dvd
/dev/mapper/centos-home  442G  2.7G  439G   1% /home
/dev/sda1                497M  125M  373M  25% /boot
tmpfs                    1.6G     0  1.6G   0% /run/user/0
/dev/loop1               7.3G  7.3G     0 100% /media/centos
/dev/loop2               7.3G  7.3G     0 100% /media/CentOS
```
### 4.重新挂载系统分区(没做)
`mount -a`
### 5.修改yum配置文件
+ `cd /etc/yum.repos.d`
+ 做备份，把原来的.repo文件做备份  
没做
+ 修改media中的配置 
修改baseurl对应的地址，前面用的CentOS，所以就不用改了 
```
[c7-media]
name=CentOS-$releasever - Media
baseurl=file:///media/CentOS/
        file:///media/cdrom/
        file:///media/cdrecorder/
        file:///dvd
gpgcheck=1
enabled=0
gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7
```

### 6.清除缓存
```
yum clean all
yum list
```
注：这里可能出现几个问题
1. `yum clean all`  
`Repository 'c7-media': Error parsing config: Error parsing "baseurl = 'file:........`  
这个原因我没有找到，解决办法是把`CentOS-Base.repo`中的之前修改过的baseurl修改了回去，就好了
2. `yum list`or`yum update`  
`failure: repodata/repomd.xml from : [Errno 256] No more mirr....`  
这个是在配置IOS的yum源之前，安装了其它地方的rpm文件，刚好这个rpm不属于ISO自带的，比如这次错误是配置了CDH的yum源，这时，把cdh的yum源配置文件`cloudera-manager.repo`干掉就好

### 7.测试
`yum install vim` or `yum install XXX`
### 8.开机自动挂载ISO镜像文件
不知道写的对不对
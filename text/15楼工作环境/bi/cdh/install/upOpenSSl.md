# 升级OpenSSL(centos7、离线)

参考：
1.[简单几步升级CentOS的OpenSSL](https://jszbug.com/a-few-simple-upgrade-centos-openssl.html)

### 1.下载openssl  
```
cd oneinstack/src
wget https://www.openssl.org/source/openssl-1.0.2k.tar.gz
tar -zvxf openssl-1.0.2k.tar.gz
cd openssl-1.0.2k
```
### 2.编译openssl  
```
./config or ./config shared zlib
make
make install
```  
这里make有可能报错  
```
making all in crypto...
make[1]: Entering directory `/soft/resources/ntp/openssl-1.0.2k/crypto'
gcc -I. -I.. -I../include  -fPIC -DOPENSSL_PIC -DZLIB -DOPENSSL_THREADS -D_REENTRANT -DDSO_DLFCN -DHAVE_DLFCN_H -m64 -DL_ENDIAN -O3 -Wall -DOPENSSL_IA32_SSE2 -DOPENSSL_BN_ASM_MONT -DOPENSSL_BN_ASM_MONT5 -DOPENSSL_BN_ASM_GF2m -DRC4_ASM -DSHA1_ASM -DSHA256_ASM -DSHA512_ASM -DMD5_ASM -DAES_ASM -DVPAES_ASM -DBSAES_ASM -DWHIRLPOOL_ASM -DGHASH_ASM -DECP_NISTZ256_ASM   -c -o cryptlib.o cryptlib.c
make[1]: gcc: Command not found
make[1]: *** [cryptlib.o] Error 127
make[1]: Leaving directory `/soft/resources/ntp/openssl-1.0.2k/crypto'
make: *** [build_crypto] Error 1
```
这是因为没有装编译器gcc,[下载](https://centos.pkgs.org/7/centos-x86_64/gcc-4.8.5-36.el7.x86_64.rpm.html)一个  
安装 ` rpm -ivh gcc-4.8.5-36.el7.x86_64.rpm`
```
error: Failed dependencies:
        cpp = 4.8.5-36.el7 is needed by gcc-4.8.5-36.el7.x86_64
        glibc-devel >= 2.2.90-12 is needed by gcc-4.8.5-36.el7.x86_64
        libgcc >= 4.8.5-36.el7 is needed by gcc-4.8.5-36.el7.x86_64
        libgomp = 4.8.5-36.el7 is needed by gcc-4.8.5-36.el7.x86_64
        libmpc.so.3()(64bit) is needed by gcc-4.8.5-36.el7.x86_64
        libmpfr.so.4()(64bit) is needed by gcc-4.8.5-36.el7.x86_64
```

#### 注意注意
离线安装gcc，各种依赖包无休无止，决定在有网的电脑上，把openssl编译，然后上传到不能联网的机器上，编译后的[文件](../../../../cdh/soft/ntp/make/)  
or  
[更改yum地址](./yum.md)
### 3.修改版本
```
mv /usr/include/openssl /usr/include/openssl.bak
ln -s /usr/local/ssl/bin/openssl /usr/bin/openssl
ln -s /usr/local/ssl/include/openssl /usr/include/openssl
echo “/usr/local/ssl/lib” >> /etc/ld.so.conf
````
`/usr/include/openssl`，可能没有，不影响结果
### 4.查看版本
`openssl version -v`

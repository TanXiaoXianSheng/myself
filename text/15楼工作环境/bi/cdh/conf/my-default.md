# centos 7 mysql配置文件（全）
```
[client]  
port = 3306  
socket = /usr/local/mysql-5.7.27/mysql.sock  

[mysql]  
no-auto-rehash  
default-character-set=utf8  

[mysqld]  
socket = /usr/local/mysql-5.7.27/mysql.sock  
basedir = /usr/local/mysql-5.7.27  
max_allowed_packet = 64M  
datadir = /data/mysql-5.7.27  
explicit_defaults_for_timestamp = true  
skip-ssl  
secure-file-priv = NULL  
lower_case_table_names = 1  
back_log = 300  
max_connections = 3000  
max_connect_errors = 100  
table_open_cache = 4096  
external-locking = FALSE  
max_allowed_packet = 64M  
sort_buffer_size = 32M  
join_buffer_size = 32M  
thread_cache_size = 16  
query_cache_size = 128M  
query_cache_limit = 4M  
thread_stack = 512K  
transaction_isolation = REPEATABLE-READ  
tmp_table_size = 128M  
max_heap_table_size = 128M  

character-set-server=utf8  

long_query_time = 6  
slow_query_log_file = /data/log/mysql-5.7.27/slow.log  

[mysqld_safe]  
open-files-limit = 8192  
log-error=/data/log/mysql-5.7.27/mysql.err  

sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES  
```
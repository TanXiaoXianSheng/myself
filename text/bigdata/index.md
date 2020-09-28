# BigData

### 环境
|            | namenodemaster(11) | yarnserver(12) | slave001(13) | slave002(14) | slave003(15)            |
| :----------: | :----------------: | :--------: | :---------------: | :----------: | :----------: |
| namenode | 1(active) |  1(standy)  |          |||
| datanode |               |     |      1       |1|1|
| JournalNode |               |     |      1       |1|1|
|  |               |     |           |||
| ResourceManager |               |  1  |  |||
| NodeManger |  |  | 1 |1|1|
|  |  |  |  |||
| zookeeper |  |  | 1 |1|1|
|  |  |  |  |||
| hiveDB/metadata |  |  | 1 |||
| mysql | 1 |  |  |||
| hive client |  | 1 |  |||


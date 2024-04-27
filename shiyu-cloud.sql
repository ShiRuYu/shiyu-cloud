-- --------------------------------------------------------
-- 主机:                           192.168.31.204
-- 服务器版本:                        8.2.0 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 shiyu_nacos 的数据库结构
CREATE DATABASE IF NOT EXISTS `shiyu_nacos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shiyu_nacos`;

-- 导出  表 shiyu_nacos.config_info 结构
CREATE TABLE IF NOT EXISTS `config_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL,
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) COLLATE utf8mb3_bin DEFAULT NULL,
  `c_use` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL,
  `effect` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL,
  `type` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL,
  `c_schema` text COLLATE utf8mb3_bin,
  `encrypted_data_key` text COLLATE utf8mb3_bin COMMENT '密钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4139 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info';

-- 正在导出表  shiyu_nacos.config_info 的数据：~19 rows (大约)
INSERT INTO `config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`, `encrypted_data_key`) VALUES
	(2, 'application-dev.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  #避免nacos取网卡出错\n  cloud:\n    inetutils:\n      preferred-networks: 192.168.1\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    type: com.zaxxer.hikari.HikariDataSource\n    hikari:\n      minimum-idle: 0\n      maximum-pool-size: 20\n      idle-timeout: 25000\n      auto-commit: true\n      connection-test-query: SELECT 1\n  data:\n    redis:\n      host: 192.168.1.46\n      # password: null\n  jackson:\n    date-format: yyyy-MM-dd HH:mm:ss\n    time-zone: GMT+8\n\nspringdoc:\n  api-docs:\n    path: /v3/api-docs/default\n  # 默认是false，需要设置为true\n  default-flat-param-object: true\n      \n#mybatis的相关配置\nmybatis:\n  #mapper配置文件\n  mapper-locations: classpath:mapper/*Mapper.xml\n  type-aliases-package: com.mall4j.cloud.**.model\n  #开启驼峰命名\n  configuration:\n    map-underscore-to-camel-case: true\n\nseata:\n  enableAutoDataSourceProxy: false\n  config:\n    type: nacos\n    nacos:\n      namespace: 4b70485d-72dd-44df-a76a-7a3f578a3001\n      dataId: "seataServer.properties"\n      server-addr: ${spring.cloud.nacos.discovery.server-addr}\n      password: ${spring.cloud.nacos.discovery.password}\n      username: ${spring.cloud.nacos.discovery.username}\n  registry:\n    type: nacos\n    nacos:\n      server-addr: ${spring.cloud.nacos.discovery.server-addr}\n      password: ${spring.cloud.nacos.discovery.password}\n      username: ${spring.cloud.nacos.discovery.username}\n      namespace: ${seata.config.nacos.namespace}\n\n\nbiz:\n  oss:\n    # resources-url是带有bucket的\n    resources-url: http://192.168.1.46:9000/mall4cloud\n    # 文件上传类型 0.阿里云 1.minio\n    type: 1\n    endpoint: http://192.168.1.46:9000\n    bucket: mall4cloud\n    access-key-id: admin\n    access-key-secret: admin123456\n\n\nlogging:\n  level:\n    root: info\n    com:\n      mall4cloud:\n        shop: debug\n# 分页合理化，当查询到页码大于最后一页的时候，返回最后一页的数据，防止vue在最后一页删除时，数据不对的问题\npagehelper:\n  reasonable: true\n\nfeign:\n  client:\n    config:\n      default:\n        connectTimeout: 5000\n        readTimeout: 5000\n        loggerLevel: basic\n  inside:\n    key: mall4cloud-feign-inside-key\n    secret: mall4cloud-feign-inside-secret\n    # ip白名单，如果有需要的话，用小写逗号分割\n    ips: \n\nmall4cloud:\n  job:\n    accessToken:\n    admin:\n      addresses: http://192.168.1.46:8999\n\nrocketmq:\n  name-server: 192.168.1.46:9876', 'c6f2562c2786298a6e13d74eaf2b6c7d', '2020-09-07 05:54:23', '2023-09-07 17:09:45', 'nacos', '192.168.1.4', '', '', '', '', '', 'yaml', '', ''),
	(8, 'mall4cloud-auth.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_auth}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}', 'd99e29908f968c8addb8f647d98b30b6', '2020-09-07 06:05:57', '2023-09-07 17:10:22', 'nacos', '192.168.1.4', '', '', '', '', '', 'yaml', '', ''),
	(13, 'mall4cloud-multishop.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_multishop}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}', 'e6e62d5a4d40101dc899cc37aecf7306', '2020-09-07 06:38:01', '2021-07-31 11:21:45', 'nacos', '192.168.1.11', '', '', '', '', '', 'yaml', '', ''),
	(16, 'mall4cloud-leaf.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_leaf}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}', 'f416d9ca7750b8cf5b78154e008233e8', '2020-09-07 06:44:22', '2021-07-31 11:21:55', 'nacos', '192.168.1.11', '', '', '', '', '', 'yaml', '', ''),
	(18, 'mall4cloud-rbac.yml', 'DEFAULT_GROUP', 'spring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_rbac}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}\n', 'd33047562436e609a37c493ad337ca85', '2020-09-07 06:47:49', '2021-07-31 11:22:04', 'nacos', '192.168.1.11', '', '', '', '', '', 'yaml', '', ''),
	(31, 'mall4cloud-biz.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_biz}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}', '31606d955a15474a826dd7decd3a231e', '2020-09-10 07:26:09', '2023-09-07 16:11:51', 'nacos', '192.168.1.4', '', '', '', '', '', 'yaml', '', ''),
	(72, 'mall4cloud-product.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_product}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}', '2d7d7afa8b27e6044377a4a3d584885a', '2020-11-11 09:35:20', '2021-07-31 11:22:45', 'nacos', '192.168.1.11', '', '', '', '', '', 'yaml', '', ''),
	(73, 'mall4cloud-search.yml', 'DEFAULT_GROUP', 'elastic:\n  # elastic的地址\n  address: 192.168.1.46\n  port: 9200', '0e8ea5c03a559a26407a21e0efcc6a97', '2020-11-12 06:57:25', '2021-04-02 15:13:25', NULL, '', '', '', '', '', '', 'yaml', '', ''),
	(84, 'mall4cloud-gateway.yml', 'DEFAULT_GROUP', 'spring:\n  codec:\n    max-in-memory-size: 2MB\n  cloud:\n    gateway:\n      globalcors:\n        cors-configurations:\n          \'[/**]\':\n            allow-credentials: true\n            allowed-headers: "*"\n            # 半个月内都允许\n            max-age: 1296000\n            # 测试环境，全部允许\n            allowedOriginPatterns: "*"\n            # allowedOrigins:\n              # - "http://localhost:9527"\n              # - "http://localhost:9527"\n              # - "http://localhost:9528"\n              # - "http://localhost:9529"\n              # - "http://:9527"\n            allowedMethods:\n              - GET\n              - POST\n              - PUT\n              - OPTIONS\n              - DELETE\n      discovery:\n        locator:\n          # 开启服务注册和发现\n          enabled: true\n          # 不手动写路由的话，swagger整合不了...\n      routes:\n        - id: mall4cloud-rbac\n          uri: lb://mall4cloud-rbac\n          predicates:\n            - Path=/mall4cloud_rbac/**\n          filters:\n            - RewritePath=/mall4cloud_rbac(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-auth\n          uri: lb://mall4cloud-auth\n          predicates:\n            - Path=/mall4cloud_auth/**\n          filters:\n            - RewritePath=/mall4cloud_auth(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-multishop\n          uri: lb://mall4cloud-multishop\n          predicates:\n            - Path=/mall4cloud_multishop/**\n          filters:\n            - RewritePath=/mall4cloud_multishop(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-biz\n          uri: lb://mall4cloud-biz\n          predicates:\n            - Path=/mall4cloud_biz/**\n          filters:\n            - RewritePath=/mall4cloud_biz(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-product\n          uri: lb://mall4cloud-product\n          predicates:\n            - Path=/mall4cloud_product/**\n          filters:\n            - RewritePath=/mall4cloud_product(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-user\n          uri: lb://mall4cloud-user\n          predicates:\n            - Path=/mall4cloud_user/**\n          filters:\n            - RewritePath=/mall4cloud_user(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-order\n          uri: lb://mall4cloud-order\n          predicates:\n            - Path=/mall4cloud_order/**\n          filters:\n            - RewritePath=/mall4cloud_order(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-platform\n          uri: lb://mall4cloud-platform\n          predicates:\n            - Path=/mall4cloud_platform/**\n          filters:\n            - RewritePath=/mall4cloud_platform(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-search\n          uri: lb://mall4cloud-search\n          predicates:\n            - Path=/mall4cloud_search/**\n          filters:\n            - RewritePath=/mall4cloud_search(?<segment>/?.*), $\\{segment}\n        - id: mall4cloud-payment\n          uri: lb://mall4cloud-payment\n          predicates:\n            - Path=/mall4cloud_payment/**\n          filters:\n            - RewritePath=/mall4cloud_payment(?<segment>/?.*), $\\{segment}\nknife4j:\n  gateway:\n    enabled: true\n    strategy: discover\n    discover:\n      version: openapi3\n      enabled: true', 'b5a073c7365fb614aea0382646b2a508', '2020-11-19 06:49:26', '2023-09-07 13:53:38', 'nacos', '192.168.1.4', '', '', '', '', '', 'yaml', '', ''),
	(3727, 'mall4cloud-order.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_order}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}', 'c33dca13b41bb90b2477f9ea7228ff48', '2020-12-04 05:45:13', '2021-04-02 12:53:44', NULL, '', '', '', '', '', '', 'yaml', '', ''),
	(3736, 'mall4cloud-user.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_user}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}', 'a2c60ea7887ebb8a0f6f5f5005048b4b', '2020-12-04 05:51:25', '2021-04-02 12:54:49', NULL, '', '', '', '', '', '', 'yaml', '', ''),
	(3759, 'mall4cloud-platform.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_platform}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}', '274a64e67ef4fab65de1e7b70e0a9ff7', '2020-12-21 07:38:16', '2021-04-02 12:55:59', NULL, '', '', '', '', '', '', 'yaml', '', ''),
	(3812, 'mall4cloud-payment.yml', 'DEFAULT_GROUP', '# 数据源\nspring:\n  datasource:\n    url: jdbc:mysql://${MYSQL_HOST:192.168.1.46}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:mall4cloud_payment}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true&useAffectedRows=true\n    username: ${MYSQL_USERNAME:root}\n    password: ${MYSQL_PASSWORD:root}\napplication:\n  domainUrl: http://47.112.182.96:8126/mall4cloud_payment', '2f4b89c096ab0cef9359c98b91ade543', '2021-02-03 03:19:16', '2021-04-02 12:56:14', NULL, '', '', '', '', '', '', 'yaml', '', ''),
	(4125, 'seataServer.properties', 'SEATA_GROUP', '#For details about configuration items, see https://seata.io/zh-cn/docs/user/configurations.html\n#Transport configuration, for client and server\ntransport.type=TCP\ntransport.server=NIO\ntransport.heartbeat=true\ntransport.enableTmClientBatchSendRequest=false\ntransport.enableRmClientBatchSendRequest=true\ntransport.enableTcServerBatchSendResponse=false\ntransport.rpcRmRequestTimeout=30000\ntransport.rpcTmRequestTimeout=30000\ntransport.rpcTcRequestTimeout=30000\ntransport.threadFactory.bossThreadPrefix=NettyBoss\ntransport.threadFactory.workerThreadPrefix=NettyServerNIOWorker\ntransport.threadFactory.serverExecutorThreadPrefix=NettyServerBizHandler\ntransport.threadFactory.shareBossWorker=false\ntransport.threadFactory.clientSelectorThreadPrefix=NettyClientSelector\ntransport.threadFactory.clientSelectorThreadSize=1\ntransport.threadFactory.clientWorkerThreadPrefix=NettyClientWorkerThread\ntransport.threadFactory.bossThreadSize=1\ntransport.threadFactory.workerThreadSize=default\ntransport.shutdown.wait=3\ntransport.serialization=seata\ntransport.compressor=none\n\n#Transaction routing rules configuration, only for the client\nservice.vgroupMapping.default_tx_group=default\n#If you use a registry, you can ignore it\nservice.default.grouplist=192.168.1.46:8091\nservice.enableDegrade=false\nservice.disableGlobalTransaction=false\n\n#Transaction rule configuration, only for the client\nclient.rm.asyncCommitBufferLimit=10000\nclient.rm.lock.retryInterval=10\nclient.rm.lock.retryTimes=30\nclient.rm.lock.retryPolicyBranchRollbackOnConflict=true\nclient.rm.reportRetryCount=5\nclient.rm.tableMetaCheckEnable=true\nclient.rm.tableMetaCheckerInterval=60000\nclient.rm.sqlParserType=druid\nclient.rm.reportSuccessEnable=false\nclient.rm.sagaBranchRegisterEnable=false\nclient.rm.sagaJsonParser=fastjson\nclient.rm.tccActionInterceptorOrder=-2147482648\nclient.tm.commitRetryCount=5\nclient.tm.rollbackRetryCount=5\nclient.tm.defaultGlobalTransactionTimeout=60000\nclient.tm.degradeCheck=false\nclient.tm.degradeCheckAllowTimes=10\nclient.tm.degradeCheckPeriod=2000\nclient.tm.interceptorOrder=-2147482648\nclient.undo.dataValidation=true\nclient.undo.logSerialization=jackson\nclient.undo.onlyCareUpdateColumns=true\nserver.undo.logSaveDays=7\nserver.undo.logDeletePeriod=86400000\nclient.undo.logTable=undo_log\nclient.undo.compress.enable=true\nclient.undo.compress.type=zip\nclient.undo.compress.threshold=64k\n#For TCC transaction mode\ntcc.fence.logTableName=tcc_fence_log\ntcc.fence.cleanPeriod=1h\n\n#Log rule configuration, for client and server\nlog.exceptionRate=100\n\n#Transaction storage configuration, only for the server. The file, DB, and redis configuration values are optional.\nstore.mode=DB\nstore.lock.mode=DB\nstore.session.mode=DB\n#Used for password encryption\nstore.publicKey=\n\n#If `store.mode,store.lock.mode,store.session.mode` are not equal to `file`, you can remove the configuration block.\nstore.file.dir=file_store/data\nstore.file.maxBranchSessionSize=16384\nstore.file.maxGlobalSessionSize=512\nstore.file.fileWriteBufferCacheSize=16384\nstore.file.flushDiskMode=async\nstore.file.sessionReloadReadSize=100\n\n#These configurations are required if the `store mode` is `db`. If `store.mode,store.lock.mode,store.session.mode` are not equal to `db`, you can remove the configuration block.\nstore.db.datasource=druid\nstore.db.dbType=mysql\nstore.db.driverClassName=com.mysql.jdbc.Driver\nstore.db.url=jdbc:mysql://192.168.1.46:3306/mall4cloud_seata?useUnicode=true&rewriteBatchedStatements=true\nstore.db.user=root\nstore.db.password=root\nstore.db.minConn=5\nstore.db.maxConn=30\nstore.db.globalTable=global_table\nstore.db.branchTable=branch_table\nstore.db.distributedLockTable=distributed_lock\nstore.db.queryLimit=100\nstore.db.lockTable=lock_table\nstore.db.maxWait=5000\n\n#These configurations are required if the `store mode` is `redis`. If `store.mode,store.lock.mode,store.session.mode` are not equal to `redis`, you can remove the configuration block.\nstore.redis.mode=single\nstore.redis.single.host=192.168.1.10\nstore.redis.single.port=6379\nstore.redis.sentinel.masterName=\nstore.redis.sentinel.sentinelHosts=\nstore.redis.maxConn=10\nstore.redis.minConn=1\nstore.redis.maxTotal=100\nstore.redis.database=0\nstore.redis.password=\nstore.redis.queryLimit=100\n\n#Transaction rule configuration, only for the server\nserver.recovery.committingRetryPeriod=1000\nserver.recovery.asynCommittingRetryPeriod=1000\nserver.recovery.rollbackingRetryPeriod=1000\nserver.recovery.timeoutRetryPeriod=1000\nserver.maxCommitRetryTimeout=-1\nserver.maxRollbackRetryTimeout=-1\nserver.rollbackRetryTimeoutUnlockEnable=false\nserver.distributedLockExpireTime=10000\nserver.xaerNotaRetryTimeout=60000\nserver.session.branchAsyncQueueSize=5000\nserver.session.enableBranchAsyncRemove=false\nserver.enableParallelRequestHandle=false\n\n#Metrics configuration, only for the server\nmetrics.enabled=false\nmetrics.registryType=compact\nmetrics.exporterList=prometheus\nmetrics.exporterPrometheusPort=9898', '6066dbd91fa1b9a3bdf2a205280675f7', '2023-03-15 11:53:03', '2023-09-07 11:48:33', 'nacos', '192.168.1.4', '', '4b70485d-72dd-44df-a76a-7a3f578a3001', '', '', '', 'text', '', ''),
	(4130, 'shiyu-user.yml', 'shiyu-dev', 'mybatis:\n  mapper-locations: classpath:mapper/*.xml\n  #目的是为了省略resultType里的代码量\n  type-aliases-package: com.shiyu.cloud.user.bean\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', 'ef48d26d7bfe011208ca23206f9a355a', '2024-04-27 00:26:03', '2024-04-27 02:13:38', NULL, '192.168.31.155', '', '2af63c6f-6106-4140-8606-94ce92fee960', '', '', '', 'yaml', '', ''),
	(4134, 'mysql.yml', 'shiyu-dev', 'spring:\n  datasource:\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\n    username: root\n    password: root\n', '933b4bbc3ee1c58b604a46b91205baa2', '2024-04-27 01:11:56', '2024-04-27 02:13:26', NULL, '192.168.31.155', '', '2af63c6f-6106-4140-8606-94ce92fee960', '', '', '', 'yaml', '', ''),
	(4135, 'shiyu-gateway.yml', 'shiyu-dev', 'spring:\n  codec:\n    max-in-memory-size: 2MB\n  cloud:\n    gateway:\n      globalcors:\n        cors-configurations:\n          \'[/**]\':\n            allow-credentials: true\n            allowed-headers: "*"\n            # 半个月内都允许\n            max-age: 1296000\n            # 测试环境，全部允许\n            allowedOriginPatterns: "*"\n            # allowedOrigins:\n              # - "http://localhost:9527"\n              # - "http://localhost:9527"\n              # - "http://localhost:9528"\n              # - "http://localhost:9529"\n              # - "http://:9527"\n            allowedMethods:\n              - GET\n              - POST\n              - PUT\n              - OPTIONS\n              - DELETE\n      discovery:\n        locator:\n          # 开启服务注册和发现\n          enabled: true\n          # 不手动写路由的话，swagger整合不了...\n      routes:\n        - id: shiyu-user\n          uri: lb://shiyu-user\n          predicates:\n            - Path=/shiyu-user/**\n\nknife4j:\n  gateway:\n    enabled: true\n    strategy: discover\n    discover:\n      version: openapi3\n      enabled: true', '7f148af9e67597acf6c005ec7ed662ad', '2024-04-27 02:09:47', '2024-04-27 02:44:17', NULL, '192.168.31.155', '', '2af63c6f-6106-4140-8606-94ce92fee960', '', '', '', 'yaml', '', ''),
	(4136, 'shiyu-order.yml', 'shiyu-dev', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.order.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '81d03474222aa2a41a806ff31f1befe6', '2024-04-27 02:14:07', '2024-04-27 02:14:07', NULL, '192.168.31.155', '', '2af63c6f-6106-4140-8606-94ce92fee960', NULL, NULL, NULL, 'yaml', NULL, ''),
	(4137, 'shiyu-product', 'shiyu-dev', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.product.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '97619a7c3f958827cda161e864cf1604', '2024-04-27 02:15:02', '2024-04-27 02:15:02', NULL, '192.168.31.155', '', '2af63c6f-6106-4140-8606-94ce92fee960', NULL, NULL, NULL, 'yaml', NULL, ''),
	(4138, 'rocketmq.yml', 'shiyu-dev', 'rocketmq:\r\n  name-server: 192.168.31.204:9876', 'e8825f3e8e098165ae04fb6204f55cd5', '2024-04-27 05:29:40', '2024-04-27 05:29:40', NULL, '192.168.31.155', '', '2af63c6f-6106-4140-8606-94ce92fee960', NULL, NULL, NULL, 'yaml', NULL, '');

-- 导出  表 shiyu_nacos.config_info_aggr 结构
CREATE TABLE IF NOT EXISTS `config_info_aggr` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'datum_id',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='增加租户字段';

-- 正在导出表  shiyu_nacos.config_info_aggr 的数据：~0 rows (大约)

-- 导出  表 shiyu_nacos.config_info_beta 结构
CREATE TABLE IF NOT EXISTS `config_info_beta` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text COLLATE utf8mb3_bin COMMENT '密钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info_beta';

-- 正在导出表  shiyu_nacos.config_info_beta 的数据：~0 rows (大约)

-- 导出  表 shiyu_nacos.config_info_tag 结构
CREATE TABLE IF NOT EXISTS `config_info_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info_tag';

-- 正在导出表  shiyu_nacos.config_info_tag 的数据：~0 rows (大约)

-- 导出  表 shiyu_nacos.config_tags_relation 结构
CREATE TABLE IF NOT EXISTS `config_tags_relation` (
  `id` bigint NOT NULL COMMENT 'id',
  `tag_name` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`),
  UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_tag_relation';

-- 正在导出表  shiyu_nacos.config_tags_relation 的数据：~0 rows (大约)

-- 导出  表 shiyu_nacos.group_capacity 结构
CREATE TABLE IF NOT EXISTS `group_capacity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='集群、各Group容量信息表';

-- 正在导出表  shiyu_nacos.group_capacity 的数据：~0 rows (大约)

-- 导出  表 shiyu_nacos.his_config_info 结构
CREATE TABLE IF NOT EXISTS `his_config_info` (
  `id` bigint unsigned NOT NULL,
  `nid` bigint unsigned NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL,
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL,
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text COLLATE utf8mb3_bin,
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL,
  `op_type` char(10) COLLATE utf8mb3_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text COLLATE utf8mb3_bin COMMENT '密钥',
  PRIMARY KEY (`nid`),
  KEY `idx_gmt_create` (`gmt_create`),
  KEY `idx_gmt_modified` (`gmt_modified`),
  KEY `idx_did` (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='多租户改造';

-- 正在导出表  shiyu_nacos.his_config_info 的数据：~31 rows (大约)
INSERT INTO `his_config_info` (`id`, `nid`, `data_id`, `group_id`, `app_name`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `op_type`, `tenant_id`, `encrypted_data_key`) VALUES
	(0, 1, 'application-dev.yml', 'shiyu-dev', '', 'server:\r\n  port: 8081\r\nspring:\r\n  application:\r\n    name: shiyu-user\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root\r\n\r\nmybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.user.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '685310f1e6a04e63166e933eb3d86ac5', '2024-04-27 07:22:34', '2024-04-26 23:22:35', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4126, 2, 'application-dev.yml', 'shiyu-dev', '', 'server:\r\n  port: 8081\r\nspring:\r\n  application:\r\n    name: shiyu-user\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root\r\n\r\nmybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.user.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '685310f1e6a04e63166e933eb3d86ac5', '2024-04-27 07:34:02', '2024-04-26 23:34:03', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 3, 'shiyu-user', 'shiyu-dev', '', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.user.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '35a14b755f8aa99ba6b4c2fd7cfe6686', '2024-04-27 07:35:02', '2024-04-26 23:35:02', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4127, 4, 'shiyu-user', 'shiyu-dev', '', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.user.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '35a14b755f8aa99ba6b4c2fd7cfe6686', '2024-04-27 07:35:33', '2024-04-26 23:35:34', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4126, 5, 'application-dev.yml', 'shiyu-dev', '', 'spring:\n  datasource:\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\n    username: root\n    password: root\n', '933b4bbc3ee1c58b604a46b91205baa2', '2024-04-27 07:46:47', '2024-04-26 23:46:47', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 6, 'shiyu-data-source', 'shiyu-dev', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 07:47:34', '2024-04-26 23:47:35', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4126, 7, 'application-dev.yml', 'shiyu-dev', '', 'spring:\n', '4503ce911602f662dd294c7b04378867', '2024-04-27 07:50:28', '2024-04-26 23:50:29', NULL, '192.168.31.155', 'D', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 8, 'shiyu-user.yml', 'DEFAULT_GROUP', '', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.user.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '35a14b755f8aa99ba6b4c2fd7cfe6686', '2024-04-27 08:25:08', '2024-04-27 00:25:09', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4129, 9, 'shiyu-user.yml', 'DEFAULT_GROUP', '', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.user.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '35a14b755f8aa99ba6b4c2fd7cfe6686', '2024-04-27 08:25:34', '2024-04-27 00:25:34', NULL, '192.168.31.155', 'D', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 10, 'shiyu-user.yml', 'shiyu-dev', '', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.user.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '35a14b755f8aa99ba6b4c2fd7cfe6686', '2024-04-27 08:26:02', '2024-04-27 00:26:03', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 11, 'shiyu-data-source.yml', 'shiyu-dev', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 08:26:35', '2024-04-27 00:26:35', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4127, 12, 'shiyu-user', 'shiyu-dev', '', 'mybatis:\n  mapper-locations: classpath:mapper/*.xml\n  #目的是为了省略resultType里的代码量\n  type-aliases-package: com.shiyu.cloud.user.bean\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', 'ef48d26d7bfe011208ca23206f9a355a', '2024-04-27 08:26:57', '2024-04-27 00:26:57', NULL, '192.168.31.155', 'D', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4128, 13, 'shiyu-data-source', 'shiyu-dev', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 08:27:02', '2024-04-27 00:27:02', NULL, '192.168.31.155', 'D', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4131, 14, 'shiyu-data-source.yml', 'shiyu-dev', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 08:34:20', '2024-04-27 00:34:21', NULL, '192.168.31.155', 'D', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 15, 'application-mysql.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 08:34:38', '2024-04-27 00:34:39', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4132, 16, 'application-mysql.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 08:42:43', '2024-04-27 00:42:43', NULL, '192.168.31.155', 'D', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 17, 'application-mysql.yml', 'shiyu-dev', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 08:43:01', '2024-04-27 00:43:01', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4130, 18, 'shiyu-user.yml', 'shiyu-dev', '', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.user.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '35a14b755f8aa99ba6b4c2fd7cfe6686', '2024-04-27 08:46:55', '2024-04-27 00:46:55', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4133, 19, 'application-mysql.yml', 'shiyu-dev', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 08:47:09', '2024-04-27 00:47:10', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4133, 20, 'application-mysql.yml', 'shiyu-dev', '', 'aaa: mysql\nspring:\n  datasource:\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\n    username: root\n    password: root', 'fdd2a520e9044219e27d4ccb8c63fde7', '2024-04-27 08:47:15', '2024-04-27 00:47:15', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 21, 'mysql.yml', 'shiyu-dev', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 09:11:55', '2024-04-27 01:11:56', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4133, 22, 'application-mysql.yml', 'shiyu-dev', '', 'aaa: mysql\nspring:\n  datasource:\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\n    username: root\n    password: root', 'fdd2a520e9044219e27d4ccb8c63fde7', '2024-04-27 09:12:22', '2024-04-27 01:12:22', NULL, '192.168.31.155', 'D', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 23, 'shiyu-gateway.yml', 'shiyu-dev', '', 'spring:\r\n  codec:\r\n    max-in-memory-size: 2MB\r\n  cloud:\r\n    gateway:\r\n      globalcors:\r\n        cors-configurations:\r\n          \'[/**]\':\r\n            allow-credentials: true\r\n            allowed-headers: "*"\r\n            # 半个月内都允许\r\n            max-age: 1296000\r\n            # 测试环境，全部允许\r\n            allowedOriginPatterns: "*"\r\n            # allowedOrigins:\r\n              # - "http://localhost:9527"\r\n              # - "http://localhost:9527"\r\n              # - "http://localhost:9528"\r\n              # - "http://localhost:9529"\r\n              # - "http://:9527"\r\n            allowedMethods:\r\n              - GET\r\n              - POST\r\n              - PUT\r\n              - OPTIONS\r\n              - DELETE\r\n      discovery:\r\n        locator:\r\n          # 开启服务注册和发现\r\n          enabled: true\r\n          # 不手动写路由的话，swagger整合不了...\r\n      routes:\r\n        - id: mall4cloud-rbac\r\n          uri: lb://mall4cloud-rbac\r\n          predicates:\r\n            - Path=/mall4cloud_rbac/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_rbac(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-auth\r\n          uri: lb://mall4cloud-auth\r\n          predicates:\r\n            - Path=/mall4cloud_auth/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_auth(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-multishop\r\n          uri: lb://mall4cloud-multishop\r\n          predicates:\r\n            - Path=/mall4cloud_multishop/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_multishop(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-biz\r\n          uri: lb://mall4cloud-biz\r\n          predicates:\r\n            - Path=/mall4cloud_biz/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_biz(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-product\r\n          uri: lb://mall4cloud-product\r\n          predicates:\r\n            - Path=/mall4cloud_product/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_product(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-user\r\n          uri: lb://mall4cloud-user\r\n          predicates:\r\n            - Path=/mall4cloud_user/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_user(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-order\r\n          uri: lb://mall4cloud-order\r\n          predicates:\r\n            - Path=/mall4cloud_order/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_order(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-platform\r\n          uri: lb://mall4cloud-platform\r\n          predicates:\r\n            - Path=/mall4cloud_platform/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_platform(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-search\r\n          uri: lb://mall4cloud-search\r\n          predicates:\r\n            - Path=/mall4cloud_search/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_search(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-payment\r\n          uri: lb://mall4cloud-payment\r\n          predicates:\r\n            - Path=/mall4cloud_payment/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_payment(?<segment>/?.*), $\\{segment}\r\nknife4j:\r\n  gateway:\r\n    enabled: true\r\n    strategy: discover\r\n    discover:\r\n      version: openapi3\r\n      enabled: true', '33bc56e697f4ba03e315fa211e55e51d', '2024-04-27 10:09:47', '2024-04-27 02:09:47', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4130, 24, 'shiyu-user.yml', 'shiyu-dev', '', 'aaa: user\nmybatis:\n  mapper-locations: classpath:mapper/*.xml\n  #目的是为了省略resultType里的代码量\n  type-aliases-package: com.shiyu.cloud.user.bean\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '2e49878752942e21ea1b4945001ec9bf', '2024-04-27 10:12:53', '2024-04-27 02:12:53', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4134, 25, 'mysql.yml', 'shiyu-dev', '', 'spring:\r\n  datasource:\r\n    #  MySQL5用的驱动url是com.mysql.jdbc.Driver，MySQL6以后用的是com.mysql.cj.jdbc.Driver\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://192.168.31.204:3306/shiyu\r\n    username: root\r\n    password: root', '621e52ba088b14a72561febc32671fe3', '2024-04-27 10:13:26', '2024-04-27 02:13:26', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4130, 26, 'shiyu-user.yml', 'shiyu-dev', '', 'user', 'ee11cbb19052e40b07aac0ca060c23ee', '2024-04-27 10:13:38', '2024-04-27 02:13:38', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 27, 'shiyu-order.yml', 'shiyu-dev', '', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.order.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '81d03474222aa2a41a806ff31f1befe6', '2024-04-27 10:14:07', '2024-04-27 02:14:07', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 28, 'shiyu-product', 'shiyu-dev', '', 'mybatis:\r\n  mapper-locations: classpath:mapper/*.xml\r\n  #目的是为了省略resultType里的代码量\r\n  type-aliases-package: com.shiyu.cloud.product.bean\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl', '97619a7c3f958827cda161e864cf1604', '2024-04-27 10:15:02', '2024-04-27 02:15:02', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4135, 29, 'shiyu-gateway.yml', 'shiyu-dev', '', 'spring:\r\n  codec:\r\n    max-in-memory-size: 2MB\r\n  cloud:\r\n    gateway:\r\n      globalcors:\r\n        cors-configurations:\r\n          \'[/**]\':\r\n            allow-credentials: true\r\n            allowed-headers: "*"\r\n            # 半个月内都允许\r\n            max-age: 1296000\r\n            # 测试环境，全部允许\r\n            allowedOriginPatterns: "*"\r\n            # allowedOrigins:\r\n              # - "http://localhost:9527"\r\n              # - "http://localhost:9527"\r\n              # - "http://localhost:9528"\r\n              # - "http://localhost:9529"\r\n              # - "http://:9527"\r\n            allowedMethods:\r\n              - GET\r\n              - POST\r\n              - PUT\r\n              - OPTIONS\r\n              - DELETE\r\n      discovery:\r\n        locator:\r\n          # 开启服务注册和发现\r\n          enabled: true\r\n          # 不手动写路由的话，swagger整合不了...\r\n      routes:\r\n        - id: mall4cloud-rbac\r\n          uri: lb://mall4cloud-rbac\r\n          predicates:\r\n            - Path=/mall4cloud_rbac/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_rbac(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-auth\r\n          uri: lb://mall4cloud-auth\r\n          predicates:\r\n            - Path=/mall4cloud_auth/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_auth(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-multishop\r\n          uri: lb://mall4cloud-multishop\r\n          predicates:\r\n            - Path=/mall4cloud_multishop/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_multishop(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-biz\r\n          uri: lb://mall4cloud-biz\r\n          predicates:\r\n            - Path=/mall4cloud_biz/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_biz(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-product\r\n          uri: lb://mall4cloud-product\r\n          predicates:\r\n            - Path=/mall4cloud_product/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_product(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-user\r\n          uri: lb://mall4cloud-user\r\n          predicates:\r\n            - Path=/mall4cloud_user/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_user(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-order\r\n          uri: lb://mall4cloud-order\r\n          predicates:\r\n            - Path=/mall4cloud_order/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_order(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-platform\r\n          uri: lb://mall4cloud-platform\r\n          predicates:\r\n            - Path=/mall4cloud_platform/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_platform(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-search\r\n          uri: lb://mall4cloud-search\r\n          predicates:\r\n            - Path=/mall4cloud_search/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_search(?<segment>/?.*), $\\{segment}\r\n        - id: mall4cloud-payment\r\n          uri: lb://mall4cloud-payment\r\n          predicates:\r\n            - Path=/mall4cloud_payment/**\r\n          filters:\r\n            - RewritePath=/mall4cloud_payment(?<segment>/?.*), $\\{segment}\r\nknife4j:\r\n  gateway:\r\n    enabled: true\r\n    strategy: discover\r\n    discover:\r\n      version: openapi3\r\n      enabled: true', '33bc56e697f4ba03e315fa211e55e51d', '2024-04-27 10:26:19', '2024-04-27 02:26:20', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4135, 30, 'shiyu-gateway.yml', 'shiyu-dev', '', 'spring:\n  codec:\n    max-in-memory-size: 2MB\n  cloud:\n    gateway:\n      globalcors:\n        cors-configurations:\n          \'[/**]\':\n            allow-credentials: true\n            allowed-headers: "*"\n            # 半个月内都允许\n            max-age: 1296000\n            # 测试环境，全部允许\n            allowedOriginPatterns: "*"\n            # allowedOrigins:\n              # - "http://localhost:9527"\n              # - "http://localhost:9527"\n              # - "http://localhost:9528"\n              # - "http://localhost:9529"\n              # - "http://:9527"\n            allowedMethods:\n              - GET\n              - POST\n              - PUT\n              - OPTIONS\n              - DELETE\n      discovery:\n        locator:\n          # 开启服务注册和发现\n          enabled: true\n          # 不手动写路由的话，swagger整合不了...\n      routes:\n        - id: shiyu-user\n          uri: lb://shiyu-user\n          predicates:\n            - Path=/shiyu-user/**\n          filters:\n            - RewritePath=/shiyu-user(?<segment>/?.*), $\\{segment}\n\nknife4j:\n  gateway:\n    enabled: true\n    strategy: discover\n    discover:\n      version: openapi3\n      enabled: true', 'b3ed9c462adcf7a58a3fedc1258d3bcc', '2024-04-27 10:36:34', '2024-04-27 02:36:35', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(4135, 31, 'shiyu-gateway.yml', 'shiyu-dev', '', 'spring:\n  codec:\n    max-in-memory-size: 2MB\n  cloud:\n    gateway:\n      globalcors:\n        cors-configurations:\n          \'[/**]\':\n            allow-credentials: true\n            allowed-headers: "*"\n            # 半个月内都允许\n            max-age: 1296000\n            # 测试环境，全部允许\n            allowedOriginPatterns: "*"\n            # allowedOrigins:\n              # - "http://localhost:9527"\n              # - "http://localhost:9527"\n              # - "http://localhost:9528"\n              # - "http://localhost:9529"\n              # - "http://:9527"\n            allowedMethods:\n              - GET\n              - POST\n              - PUT\n              - OPTIONS\n              - DELETE\n      discovery:\n        locator:\n          # 开启服务注册和发现\n          enabled: true\n          # 不手动写路由的话，swagger整合不了...\n      routes:\n        - id: shiyu-user\n          uri: lb://shiyu-user\n          predicates:\n            - Path=/shiyu-user/**\n\n\nknife4j:\n  gateway:\n    enabled: true\n    strategy: discover\n    discover:\n      version: openapi3\n      enabled: true', '743894002cdbbe055a91886eb1d7713f', '2024-04-27 10:44:17', '2024-04-27 02:44:17', NULL, '192.168.31.155', 'U', '2af63c6f-6106-4140-8606-94ce92fee960', ''),
	(0, 32, 'rocketmq.yml', 'shiyu-dev', '', 'rocketmq:\r\n  name-server: 192.168.31.204:9876', 'e8825f3e8e098165ae04fb6204f55cd5', '2024-04-27 13:29:40', '2024-04-27 05:29:40', NULL, '192.168.31.155', 'I', '2af63c6f-6106-4140-8606-94ce92fee960', '');

-- 导出  表 shiyu_nacos.permissions 结构
CREATE TABLE IF NOT EXISTS `permissions` (
  `role` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `resource` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `action` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE KEY `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在导出表  shiyu_nacos.permissions 的数据：~0 rows (大约)

-- 导出  表 shiyu_nacos.roles 结构
CREATE TABLE IF NOT EXISTS `roles` (
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE KEY `idx_user_role` (`username`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在导出表  shiyu_nacos.roles 的数据：~0 rows (大约)
INSERT INTO `roles` (`username`, `role`) VALUES
	('nacos', 'ROLE_ADMIN');

-- 导出  表 shiyu_nacos.tenant_capacity 结构
CREATE TABLE IF NOT EXISTS `tenant_capacity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
  `max_aggr_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='租户容量信息表';

-- 正在导出表  shiyu_nacos.tenant_capacity 的数据：~0 rows (大约)

-- 导出  表 shiyu_nacos.tenant_info 结构
CREATE TABLE IF NOT EXISTS `tenant_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='tenant_info';

-- 正在导出表  shiyu_nacos.tenant_info 的数据：~1 rows (大约)
INSERT INTO `tenant_info` (`id`, `kp`, `tenant_id`, `tenant_name`, `tenant_desc`, `create_source`, `gmt_create`, `gmt_modified`) VALUES
	(1, '1', '2af63c6f-6106-4140-8606-94ce92fee960', 'shiyu', 'shiyu-cloud', 'nacos', 1714173663172, 1714173663172);

-- 导出  表 shiyu_nacos.users 结构
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(500) COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在导出表  shiyu_nacos.users 的数据：~0 rows (大约)
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
	('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

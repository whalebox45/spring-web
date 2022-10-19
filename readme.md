# 使用環境
Java: openjdk-18-jre + Maven

Spring Boot 2.7.3 + Thymeleaf

SQLite3

# 模板
Clean Blog: https://startbootstrap.com/theme/clean-blog

# 文章資料表綱要
```
CREATE TABLE "blogpost" (
	"id"	INTEGER,
	"title"	TEXT,
	"context"	TEXT,
	"create_date"	DATETIME NOT NULL,
	"route_tag"	varchar(255),
	PRIMARY KEY("id" AUTOINCREMENT)
)
```

# 打包
```
./mvnw clean package
```

# 部署

最後將 jar 檔掛上服務，並且透過 nginx 設定反向代理。

whale_spring.service
```
[Unit]
Description=Whale Spring Boot
After=network.target
StartLimitIntervalSec=0
[Service]
Type=simple
Restart=always
RestartSec=1
User=user
ExecStart=/usr/bin/java -jar /path/to/whale_spring-0.3.jar
[Install]
WantedBy=multi-user.target
```

nginx_conf
```
limit_req_zone $binary_remote_addr zone=one:10m rate=10r/s;

server {
  client_body_timeout 6s;
  client_header_timeout 6s;

  listen 80;
  server_name _; 

  location / {

    limit_req zone=one;
    proxy_pass http://localhost:8080;
    proxy_set_header Host $http_host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header X-Forwarded-Proto $http_x_forwarded_proto;
  }
}
```

# financial

## cloud9 setup:

### docker
1. sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
2. sudo chmod +x /usr/local/bin/docker-compose

### instance iptables
1. sudo iptables -L
2. sudo iptables -A INPUT -p tcp --dport YOUR_PORT_NUMBER -j ACCEPT

### Gradle
1. wget https://services.gradle.org/distributions/gradle-8.5-bin.zip
2. unzip gradle-8.5-bin.zip -d /opt/gradle
3. vi ~/.bashrc 
4. export GRADLE_HOME=/opt/gradle/gradle-8.5
5. export PATH=$PATH:$GRADLE_HOME/bin
6. save .bashrc
7. source ~/.bashrc (or .bash_profile)

### Angular:
npm install -g @angular/cli

### git:
git remote set-url origin https://username:your-token@github.com/username/financial.git

## Stack
* Angular:17.0.0
* Springboot:3.2.1
* MongoDb:4.2.12
* Gradle:8.5
* 
## Repositories
* mavenCentral
* google

## Dependencies

### Root
* checkstyle
* com.puppycrawl.tools:checkstyle:10.10.0
* com.diffplug.spotless
* com.diffplug.spotless:spotless-plugin-gradle:6.23.3

### Backend
* Java:17
* org.springframework.boot:3.2.1
* io.spring.dependency-management:1.1.4
* org.springframework.boot:spring-boot-starter-web
* org.springframework.boot:spring-boot-starter-data-mongodb
* org.projectlombok:lombok
* org.springframework.boot:spring-boot-starter-test

### Frontend
* Angular:17.0.0

## To Run
1. ```cd development-env```
2. ```docker-compose up -d```
3. ```cd ..```
4. ```./gradlew bootRun```
5. ```cd ledger-frontend```
6. ```npm start```
# financial

cloud9 setup:
docker
1. sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
2. sudo chmod +x /usr/local/bin/docker-compose

instance iptables
1. sudo iptables -L
2. sudo iptables -A INPUT -p tcp --dport YOUR_PORT_NUMBER -j ACCEPT

Gradle
1. wget https://services.gradle.org/distributions/gradle-<version>-bin.zip
2. unzip gradle-<version>-bin.zip -d /opt/gradle
3. vi ~/.bashrc 
4. export GRADLE_HOME=/opt/gradle
5. export PATH=$PATH:$GRADLE_HOME/bin
6. save .bashrc
7. source ~/.bashrc (or .bash_profile)

Angular:
npm install -g @angular/cli

git:
git remote set-url origin https://username:your-token@github.com/username/repository.git

Frontend:
to run - ng serve --host 0.0.0.0 --port 4200
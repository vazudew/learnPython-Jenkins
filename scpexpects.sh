#! /usr/bin/expect -f
set timeout 6000

set USER_S "jenkins"
set HOST_S "3.125.118.211"

spawn scp -r /var/lib/jenkins/workspace/webapp/calap/  $USER_S@$HOST_S:/home/jenkins/.
expect "password: "
send "hell123\r"
expect "$ "
send "ls -Rla /home/jenkins/calap\r"
expect "$ "
send "whoami\r"
expect "$ "
send "exit\r"

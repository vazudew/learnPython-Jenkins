#! /usr/bin/expect -f
set timeout 6000

set USER_S "jenkins"
set HOST_S "3.125.118.211"

spawn ssh $USER_S@$HOST_S
expect "password: "
send "hell123\r"

expect "$ "
send "sudo rm -rf /home/jenkins/calap \r"
expect " password for jenkins:"
send "hell123\r"

expect "$ "
send "sudo pkill -f /var/www/html/calap/CalculatorFlask.py\r"

expect "$ "
send "whoami\r"

expect "$ "
send "ps -ef | grep Flask\r"

expect "$ "
send "exit\r"

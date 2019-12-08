#! /usr/bin/expect -f
set timeout 30000

set USER_S "jenkins"
set HOST_S "3.125.118.211"

spawn ssh $USER_S@$HOST_S
expect "password: "
send "hell123\r"

expect "$ "
send "sudo apachectl stop \r"
expect " password for jenkins:"
send "hell123\r"

expect "$ "
send "sudo pkill -f /var/www/html/calap/CalculatorFlask.py\r"


expect "$ "
send "sudo rm -rf /var/www/html/calap\r"

expect "$ "
send "sudo cp -rf /home/jenkins/calap /var/www/html/.\r"
sleep 5

expect "$ "
send "sudo apachectl restart \r"
sleep 5

expect "$ "
send "sudo nohup python /var/www/html/calap/CalculatorFlask.py & \r"
sleep 5

expect "$ "
send "\r exit \r"
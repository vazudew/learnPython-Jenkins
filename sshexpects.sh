#! /usr/bin/expect -f

set USER_S "jenkins"
set HOST_S "3.125.118.211"

spawn ssh $USER_S@$HOST_S
expect "password: "
send "hell123\r"
expect "$ "
send "ls -la\r"
expect "$ "
send "whoami\r"
expect "$ "
send "exit\r"

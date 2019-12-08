#! /usr/bin/expect -f

user      = "jenkins"
ipaddress = "3.125.118.211"

spawn ssh $user@$ipaddress
expect "password: "
send "hell123\r"
expect "$ "
send "ls -la\r"
expect "$ "
send "exit\r"

#!binbash

echo Stopping old app...
pkill -f employee-management  true

echo Starting new app...
nohup java -jar target.jar  app.log 2&1 &
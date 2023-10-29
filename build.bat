@echo off
cd %~dp0
call gradlew build
pause
rmdir /s /q docs
echo D | xcopy /E build\dist\js\productionExecutable docs
pause

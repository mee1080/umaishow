@echo off
cd %~dp0
call gradlew build
rmdir /s /q docs
echo D | xcopy build\distributions docs
pause

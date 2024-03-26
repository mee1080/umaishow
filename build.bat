@echo off
cd %~dp0
call gradlew html:build
pause
rmdir /s /q docs
echo D | xcopy /E html\build\dist\js\productionExecutable docs
pause

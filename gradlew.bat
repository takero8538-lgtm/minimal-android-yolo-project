@echo off
SETLOCAL

rem ------------------------------------------------------------------------------
rem Gradle startup script for Windows
rem ------------------------------------------------------------------------------

set DIRNAME=%~dp0
set APP_HOME=%DIRNAME%

if not defined JAVA_HOME (
  echo WARNING: JAVA_HOME is not set. Please set JAVA_HOME to a JDK root directory.
)

set CLASSPATH=%APP_HOME%gradle\wrapper\gradle-wrapper.jar

"%JAVA_HOME%\bin\java.exe" %GRADLE_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

ENDLOCAL

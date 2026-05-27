#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=""

APP_NAME="Gradle"
DIRNAME=$(dirname "$0")
SCRIPT="$DIRNAME/gradlew"

# Attempt to set APP_HOME
APP_HOME=$(cd "$DIRNAME" && pwd)

# Check if JAVA_HOME is set
if [ -z "$JAVA_HOME" ]; then
  echo "WARNING: JAVA_HOME is not set. Please set JAVA_HOME to a JDK root directory."
fi

exec "$JAVA_HOME/bin/java" $DEFAULT_JVM_OPTS -classpath "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"

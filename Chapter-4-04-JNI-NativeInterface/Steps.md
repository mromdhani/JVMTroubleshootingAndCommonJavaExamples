
javac -h . HelloJNI.java   // No need for javah command starting from Java 8


gcc -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o hello.dll HelloJNI.c

java HelloJNI   // Run from console
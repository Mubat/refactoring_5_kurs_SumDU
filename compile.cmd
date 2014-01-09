for /r %%a in (test*.java) do ( javac -d bin -classpath libs\junit-4.8.2.jar -sourcepath src "%%a" )
javac -d bin -cp libs\junit-4.8.2.jar -sourcepath src src\education\sumdu\Fifth\kurs\Shopping\Main.java
pause
set projectLocation=D:\EclipseFiles\Quickbase
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java -classpath org.testng.TestNG %projectLocation%\testng.xml
pause

# Total Performance: Technical Exercise

This is a maven project, be sure to build it to download packages

###Notes:
  * file1.json is located at ~/totalperformancetest/src/main/resources
  * Any other file shall be included in the same folder
  * Main class at ~/src/main/Exercises
  
###How to run
  * Execute ~/xml/Excercise1.xml and ~/xml/Excercise2.xml as testNG 
  * it's seted up for Windows, in case you are using Mac, delete .exe to chromedriver constant. ./src/main/java/com.totalperformance.test/helpers/Constants
###Interpretation Notes:
  * In case it finds import key, it adds a single definition dictionary - key: element name, value = dictionary with key: locator, value: CSS locator
  * In case it finds __FINDERS__ key, every name will be saved as key with empty value.
  * If already exists saves locator in case it's empty, if not it ignores the new value.
  * Code is over commented, it's to clarify as much as I can, since it's a test ;)
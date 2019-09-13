 - Make sure you have set the PATH variable to the bins for 'java', 'javac' and 'jar'. (Alternatively give the full path in the examples below)
 - My examples are on windows. If you have Linux or Mac please adapte the filepaths accordingly.
 - To run the tests there are two dependencies: junit-4.12 and hamcrest-core-1.3. You have to provide those dependencies. In my examples I copied the jars to the 'lib' folder. But you can also adapt the classpath to point where you have the dependencies-jars in the examples below.


To compile the program code:
  javac -g -d out\production\SwissReAssignment src\dev\flgl\swissre\*.java


Make a .jar file from the classes.
  jar cvfe SwissReAssignment.jar dev.flgl.swissre.Main -C out\production\SwissReAssignment\ .


To execute the program use from the 'SwissReAssignment' directory:
  java -jar SwissReAssignment.jar bobs_crypto.txt


To compile the test code: You need to give the correct location for the junit and hamcrest-core lib. For this example I copied the .jars to the 'lib' directory.
  javac -g -d out\test\SwissReAssignment -cp out\production\SwissReAssignment;lib\junit-4.12.jar;lib\hamcrest-core-1.3.jar tests\dev\flgl\swissre\*.java


To execute all unittests use:
  java -cp lib\junit-4.12.jar;lib\hamcrest-core-1.3.jar;out\test\SwissReAssignment;out\production\SwissReAssignment org.junit.runner.JUnitCore dev.flgl.swissre.AllTestsSuite


Notes to the implementation:
 - Java version used is Java 8, as requested.
 - Junit major version is 4 (not 5) since it is most widely used and still the default in spring boot.
 - Usually I would have used a build tool like maven or gradle but I sticked to the requirement not to use any libs stricly.
 - Formatting is the "google coding style".
 - Additionally to junit I had to add the lib hamcrest-core, since it is a junit dependency.
 - Testcoverage is about 82% lines.
 - If you use IntelliJ IDEA you can use the project files still with the archive.
 - Since the program is supposed to be simple I choose not build a deeper package structure, only one level.
 - A bad / not parsable bob_crypto file will stop the program.
 - But if the service call gives an error only that one line will not be processed and the program will be continued.
 - Especially since we only know after the service call if a currency symbol is an actual valid symbol.

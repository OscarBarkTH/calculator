# calculator
 
Simple Maven project demonstrating:
- Automatically performing JUnit 5 unit tests when building
- Using third party dependencies found at Maven Central Repository (``junit-jupiter-api`` and ``junit-jupiter-engine``)
- Packages the project as a JAR-file and installs it into the local repository

In order to package the project as a JAR-file and install it into your local repository:
1. In Eclipse, right-click the project and choose ``Run as`` > ``Maven Build``
2. When prompted to specify "Goals", enter ``install``
3. Click "Run"

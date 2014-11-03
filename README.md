
### Maven

http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html

The src directory contains all of the source material for building the project, its site and so on. It contains a subdirectory for each type: main for the main build artifact, test for the test code and resources and so on.


```
$ mvn clean install
```

Then run the test:

```
$ mvn clean test
```

To generate reports:

```
$ mvn site
```
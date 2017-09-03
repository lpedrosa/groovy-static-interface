This project shows how to call a static method on an interface in groovy. This seems to work just fine on Java 8, but when you run the example on Java 9 you get the following error:

```bash
$ JAVA_HOME=<path-to-jdk9> ./gradlew run
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.gradle.internal.reflect.JavaMethod (file:<my-home>/.gradle/wrapper/dists/gradle-3.4.1-bin/71zneekfcxxu7l9p7nr2sc65s/gradle-3.4.1/lib/gradle-base-services-3.4.1.jar) to method java.lang.ClassLoader.getPackages()
WARNING: Please consider reporting this to the maintainers of org.gradle.internal.reflect.JavaMethod
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
:compileJava UP-TO-DATE
:compileGroovy UP-TO-DATE
:processResources NO-SOURCE
:classes UP-TO-DATE
:run
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.codehaus.groovy.reflection.CachedClass (file:<my-home>/.gradle/caches/modules-2/files-2.1/org.codehaus.groovy/groovy-all/2.4.12/760afc568cbd94c09d78f801ce51aed1326710af/groovy-all-2.4.12.jar) to method java.lang.Object.finalize()
WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.reflection.CachedClass
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
Exception in thread "main" java.lang.IncompatibleClassChangeError: Method staticmethod.example.Greeter.createDefault()Lstaticmethod/example/Greeter; must be InterfaceMethodref constant
        at staticmethod.example.Greeter$createDefault.call(Unknown Source)
        at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:48)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:113)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:117)
        at staticmethod.example.tool.Runner.main(Runner.groovy:7)
```

I am not entirely sure if this is related to these bugfixes:

* https://issues.apache.org/jira/browse/GROOVY-7879
* https://issues.apache.org/jira/browse/GROOVY-8164

Or something has changed in the way Java 9 generates bytecode for static methods on interfaces.

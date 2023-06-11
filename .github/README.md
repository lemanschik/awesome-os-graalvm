## AwesomeOS GraalVM Support via Eclipse Vert.x
This Implements a AwesomeOS Infrastructure based on Vert.x running on GraalVM 
Allows you to use ECMAScript and so also the Stealify Language on your JVM Deployments
without additional code changes and Infrastructure Changes.

So it allows you to Create and ship Java compatible Polyglot Stealify Lang Projects.
As also use Nativ AwesomeOS bindings directly in JVM code. 

## Why and How?
There are a lot of ways to interop with jvm code but we needed the most performant with zero overhead.
As also reuse our fast call abilitys and our sandboxing this offers also a way to incremental
refactor your code to get less code that is more maintainable. 

This project is a rewrite of ES4X but out of ECMAScript view. It trys to Implement
the exact same features but written in ECMAScript so it offers a ECMAScript es4x
Interface to complement the Polyglot interop with GraalVM and the vert.x Ecosystem.

this is mainly usefull for Quaternion DB and Oracle DB Interop and Integration as also 
High trhoughput pipelines between both and function exchange. Mainly Allows you to 
even Install AwesomeOS on Oracle Database Clusters and this way turn them into hybrid
Quaternion DB Instances.

## Bonus
Automation and Integration with the Chromium Platform 
As the chromium platform supports the text based devtools protocol this allows you to
easy integrate and interop with existing browser installations like the Edge Browser used
on windows or any other chromium based browser. If you would want you could even add
support for other browser vendors.

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

# Historical ES4X

This is the EcmaScript (5.1+) language support for [Eclipse Vert.x](http://vertx.io)

[![CI](https://github.com/reactiverse/es4x/actions/workflows/java.yml/badge.svg?branch=develop)](https://github.com/reactiverse/es4x/actions/workflows/java.yml)
[![Join the chat at https://gitter.im/es4x/Lobby](https://badges.gitter.im/es4x/Lobby.svg)](https://gitter.im/es4x/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Security Status](https://snyk-widget.herokuapp.com/badge/mvn/io.reactiverse/es4x/badge.svg)](https://snyk.io/vuln/maven:io.reactiverse:es4x?utm_medium=referral&utm_source=badge&utm_campaign=snyk-widget)

## Why?

[![10 things I've learned making the fastest JS runtime in the world](https://img.youtube.com/vi/JUJ85k3aEg4/0.jpg)](https://www.youtube.com/watch?v=JUJ85k3aEg4)

JavaScript is fast, and this is the way to make it even faster 🚀🚀🚀

## Usage

Create a project:

```
# create a generic project
mkdir my-app
cd my-app
# init the project
npm init @es4x project
# add other dependencies...
npm install @vertx/unit --save-dev
npm install @vertx/core --save-prod
# will trigger the download
# of the java dependencies
npm install
```

Create your `index.js`:

```js
/// <reference types="es4x" />
// @ts-check

vertx
  .createHttpServer()
  .requestHandler(function (req) {
    req.response().end("Hello!");
  })
  .listen(8080);

console.log('Server listening at: http://localhost:8080/');
```

and your `index.test.js`:

```js
import { TestSuite } from '@vertx/unit';

const suite = TestSuite.create("the_test_suite");

suite.test("my_test_case", function (context) {
  var s = "value";
  context.assertEquals("value", s);
});

suite.run();
```


```bash
npm start
```

Profit!

## Documentation

For more documentation please see [docs](./docs).

time2lib-demo : Demos for the Time2 Library
===========================================

	Copyright 2011-2017 Hauser Olsson GmbH.
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
    	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

***

The Time2 Library is a Java library providing 
generic time series with configurable time domains. This package
provides a few demos.

Version 2
---------

Version 2.0.0 tracks changes in the Time2 Library t2 2.0.0
and is also more illustrative of basic concepts.

Distribution
------------

Starting with version 1.0.2, the distribution consists of a binary JAR with 
compiled classes, of a javadoc JAR and of a source JAR. For version x.y.z:

	t2-demo-x.y.z.jar
	t2-demo-x.y.z-javadoc.jar
	t2-demo-x.y.z-sources.jar

Building the software
---------------------

The recommended way is to use [git](http://git-scm.com) for accessing the
source and [maven](<http://maven.apache.org/>) for building. The procedure 
is easy, as maven takes care of locating and downloading dependencies:

	$ git clone https://github.com/jpvetterli/time2lib-demo.git
	$ cd time2lib-demo
	$ mvn install

This builds and installs the distribution JARs in your local maven
repository. They can also be found in the `target` directory.

When building the software by other means, the following dependencies must be
addressed:

- `batik-awt-util-<version>.jar` [Batik](http://xmlgraphics.apache.org/batik/)
- `batik-svggen-<version>.jar` [Batik](http://xmlgraphics.apache.org/batik/)
- `batik-util-<version>.jar` [Batik](http://xmlgraphics.apache.org/batik/)
- `jcommon-<version>.jar` [JCommon](http://www.jfree.org/jcommon/)
- `jfreechart-<version>.jar` [JFreeChart](http://www.jfree.org/jfreechart/) 
- `t2-<version>.jar` [Time2 Library](http://agent.ch/timeseries/t2/) 

Versions numbers can be found in the <q>POM</q> file included in the binary 
JAR:

	/META-INF/maven/ch.agent/t2-demo/pom.xml

Running the demos
-----------------

The following command executes the <q>default</q> demo:

	$ mvn -q exec:exec
	1896=Athens
	1900=Paris
	[... some output removed ...]
	1932=Los Angeles
	1936=Berlin

(Everything after the first line is the output of the command.)
The same can be done with:

	$ mvn -q -Ddemo.mainClass=ch.agent.t2.demo.Olympics exec:exec
	1896=Athens
	[... some output removed ...]

A demo requiring arguments is specified like this:

	$ mvn -q -Ddemo.mainClass=ch.agent.t2.demo.DateDays \
             -Ddemo.args="1291-08-01 2012-08-28" exec:exec
	[1291-08-01, 2012-08-28] = 263367 day(s)

The command computes the number of days between two dates.

Note: this was executed in a Unix shell, which supports line continuation
with a backslash. In case your shell or command window does not do this, 
write the command as one long line.

Browsing the source code
------------------------

The source is available on [GitHub](http://github.com/jpvetterli/time2lib-demo.git).

Finding more information
------------------------

More information on the Time2 Library is available at 
the [project web site](http://agent.ch/timeseries/t2/).

<small>Updated: 2017-10-06/jpv</small>

<link rel="stylesheet" type="text/css" href="README.css"/>


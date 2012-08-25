<link rel="stylesheet" type="text/css" href="README.css"/>
Demos for the Time2 Library
===========================

2012-08-25/jpv

	Copyright 2011-2012 Hauser Olsson GmbH.
	
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

Thanks for your interest in the Time2 Library demos. Here you will find tips
on how to:

- run the demos
- browse the source
- build the demos

Running the demos
-

To run the demos use the archive __t2-demo-1.0-jar-with-dependencies.jar__.
It is large because all required third party libraries are included.
There is a second archive, __t2-demo-1.0.jar__, containing only the demos.

The command line syntax assumes Linux, but things are kept simple
and no special knowledge is required, except some familiarity with Java. 
Of course, to run the demos, you need to have basic Java tools installed.

The simplest demo, Olympics, runs out of the box:

	$ java -jar t2-demo-1.0-jar-with-dependencies.jar
	1896=Athens
	1900=Paris
	1904=Saint-Louis
	1908=London
	1912=Stockholm
	1916=(missing)
	1920=Antwerp
	1924=Paris
	1928=Amsterdam
	1932=Los Angeles
	1936=Berlin

Another simple demo is DateDays (the command is all on one line):

	$ java -cp t2-demo-1.0-jar-with-dependencies.jar \
		ch.agent.t2.demo.DateDays 1291-08-01 2012-08-25
	[1291-08-01, 2012-08-25] = 263364 day(s)

There is a larger demo, StockCharts. As a prelimary step, extract the data
file FBI.csv from the archive:

	$ jar xf t2-demo-1.0-jar-with-dependencies.jar FBI.csv

To create a PNG and an SVG chart from this data, execute the next two commands 
(with all arguments on one big line):

	$ java -cp t2-demo-1.0-jar-with-dependencies.jar \
		ch.agent.t2.demo.StockChart data=FBI.csv out=FBI-1991Q1.png \
		date1=1991-01-01 date2=1991-03-31 title="Foo & Bar, Inc (unadjusted)"
	$ java -cp t2-demo-1.0-jar-with-dependencies.jar \
		ch.agent.t2.demo.StockChart data=FBI.csv out=FBI-1991Q1.svg \
		date1=1991-01-01 date2=1991-03-31 title="Foo & Bar, Inc (unadjusted)"

Inspect the output files with a viewer or your usual browser. If you use Firefox, 
you should be able to view the SVG file and to resize it without loss of quality.

Browsing the source code
-

The source is available on GitHub at <http://github.com/jpvetterli/time2lib-demo.git>.

Building the demos
-

The easiest way is to use maven (<http://maven.apache.org>). The process is easy, 
as maven takes care of locating and downloading dependencies:

	$ git clone https://github.com/jpvetterli/time2lib-demo.git
	$ cd time2lib-demo
	$ mvn package
	$ ls target/*.jar
	t2-demo-1.0.jar t2-demo-1.0-jar-with-dependencies.jar

More information on the Time2 Library is available at <http://agent.ch/timeseries/t2>.


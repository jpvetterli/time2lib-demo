/*
 *   Copyright 2011 Hauser Olsson GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Package: ch.agent.t2.demo
 * Type: DateDays
 * Version: 1.0.0
 */
package ch.agent.t2.demo;

import ch.agent.t2.time.Day;
import ch.agent.t2.time.TimeIndex;

/**
 * DateDays is a (very) little demo for the Time2 library.
 *
 * @author Jean-Paul Vetterli
 * @version 1.0.0
 */
public class DateDays {

	public static void usage(String message) {
		System.out.println(message);
		System.out.println();
		System.out.println("Usage:");
		System.out.println(
				"The program takes two parameters: either two dates or a date \n" + 
				"and a number of days. With two dates it prints the number \n" +
				"of days between the dates, like 1 for two subsequent dates. \n" + 
				"With a date and a number of days it adds the number to the date \n" +
				"and prints the result. \n" +
				"\n" +
				"Dates must be in the form \"yyyy-mm-dd\", like this: \"2005-12-31\".\n" +
				"\n" +
				"Hint: use the program to see when you will be (or were) 10000 days old. \n");
	}
	
	public static void main(String[] args) {
		try {
			
			if (args.length != 2) {
				usage("Error: exactly two arguments must be specified.");
				return;
			}
		
			TimeIndex day1 = null;
			try {
				day1 = new Day(args[0]);
			} catch (Exception e) {
				usage(String.format("Error: first argument \"%s\" not a valid date.", args[0]));
				return;
			}

			Long days = null;
			TimeIndex day2 = null;
			try {
				try {
					days = Long.valueOf(args[1]);
				} catch (NumberFormatException e) {
					day2 = new Day(args[1]);
				}
			} catch (Exception e) {
				usage(String.format("Error: second argument \"%s\" neither a valid number nor a valid date.", args[1]));
				return;
			}
			
			if (days == null)
				System.out.println(String.format("[%s, %s] = %d day(s)", day1, day2, day2.sub(day1)));
			else
				System.out.println(String.format("%s + %d day(s) = %s", day1, days, day1.add(days)));
			
		} catch (Exception e) {
			System.err.println("Oops...\n" + e.getMessage());
		}
	}

	
	
}

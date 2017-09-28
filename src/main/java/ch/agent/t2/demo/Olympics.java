/*
 *   Copyright 2011-2017 Hauser Olsson GmbH
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
 */
package ch.agent.t2.demo;

import ch.agent.t2.time.TimeDomain;
import ch.agent.t2.timeseries.Observation;
import ch.agent.t2.timeseries.RegularTimeSeries;
import ch.agent.t2.timeseries.TimeAddressable;

/**
 * Olympics is a (very) little demo for the Time2 library.
 *
 * @author Jean-Paul Vetterli
 */
public class Olympics {

	public static void main(String[] args) {
		try {
			TimeDomain year4 = new EveryFourYears();
			
			// define "missing value" for String (else, the default is null)
			String missingValue = "(missing)";
			TimeAddressable<String> olympics = new RegularTimeSeries<String>(String.class, year4, missingValue);
			olympics.put(year4.time("1896"), new String[] {"Athens", "Paris", "Saint-Louis", "London", "Stockholm"});
			olympics.put(year4.time("1920"), new String[] {"Antwerp", "Paris", "Amsterdam", "Los Angeles", "Berlin"});
			
			for (Observation<String> oly : olympics) {
				System.out.println(oly.toString());
			}
			
		} catch (Exception e) {
			System.err.println("Oops...\n" + e.getMessage());
		}
	}
}

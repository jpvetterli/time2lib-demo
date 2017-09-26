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
import ch.agent.t2.timeseries.TimeAddressable;
import ch.agent.t2.timeseries.TimeSeriesFactory;

/**
 * Olympics is a (very) little demo for the Time2 library.
 *
 * @author Jean-Paul Vetterli
 */
public class SummerWinterOlympics {

	public static void main(String[] args) {
		try {
			TimeDomain year4 = new EveryFourYears();
			TimeDomain year4s2 = new EveryFourYearsShiftedBy2();
			
			// define "missing value" for String (else, the default is null)
			String missingValue = "(missing)";
			TimeSeriesFactory.getInstance().define(String.class, missingValue);

			TimeAddressable<String> solympics = TimeSeriesFactory.make(year4, String.class);
			TimeAddressable<String> wolympics = TimeSeriesFactory.make(year4s2, String.class);
			solympics.put(year4.time("1996"), new String[] {"Atlanta", "Sydney", "Athens", "Beijing"});
			wolympics.put(year4s2.time("1998"), new String[] {"Nagano", "Salt Lake City", "Turin", "Vancouver"});
			
			for (Observation<String> oly : solympics) {
				System.out.println(oly.toString());
			}
			for (Observation<String> oly : wolympics) {
				System.out.println(oly.toString());
			}
			
		} catch (Exception e) {
			System.err.println("Oops...\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
}

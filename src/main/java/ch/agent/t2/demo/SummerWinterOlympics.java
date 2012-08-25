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
 * Type: SummerWinterOlympics
 * Version: 1.0.0
 */
package ch.agent.t2.demo;

import ch.agent.t2.time.Cycle;
import ch.agent.t2.time.Resolution;
import ch.agent.t2.time.TimeDomain;
import ch.agent.t2.time.TimeDomainDefinition;
import ch.agent.t2.time.TimeDomainManager;
import ch.agent.t2.timeseries.Observation;
import ch.agent.t2.timeseries.TimeAddressable;
import ch.agent.t2.timeseries.TimeSeriesFactory;

/**
 * Olympics is a (very) little demo for the Time2 library.
 *
 * @author Jean-Paul Vetterli
 * @version 1.0.0
 */
public class SummerWinterOlympics {

	public static void main(String[] args) {
		try {
			// define time domain "once every fourth year"
			TimeDomainDefinition year4def = new TimeDomainDefinition("year4", Resolution.YEAR, 0L, new Cycle(true, false, false, false));
			TimeDomain year4 = TimeDomainManager.getFactory().get(year4def, true);

			TimeDomainDefinition year4defShiftedBy2 = new TimeDomainDefinition("year4s2", Resolution.YEAR, 2L, new Cycle(false, false, true, false));
			TimeDomain year4s2 = TimeDomainManager.getFactory().get(year4defShiftedBy2, true);
			
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

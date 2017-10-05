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

import ch.agent.t2.time.Cycle;
import ch.agent.t2.time.ImmutableTimeDomainCatalog;
import ch.agent.t2.time.Resolution;
import ch.agent.t2.time.TimeDomain;
import ch.agent.t2.time.TimeDomainCatalog;
import ch.agent.t2.time.TimeDomainDefinition;
import ch.agent.t2.time.TimeFactory;
import ch.agent.t2.timeseries.Observation;
import ch.agent.t2.timeseries.RegularTimeSeries;
import ch.agent.t2.timeseries.TimeAddressable;

/**
 * SummerWinterOlympics is a (very) small demo for the Time2 library.
 * It shows how to use a time domain catalog.
 *
 * @author Jean-Paul Vetterli
 */
public class SummerWinterOlympics {

	public static void main(String[] args) {
		try {
			TimeDomainCatalog cat = new ImmutableTimeDomainCatalog(
					new EveryFourYears(), 
					new EveryFourYearsShiftedBy2()
			) {};
			SummerWinterOlympics app = new SummerWinterOlympics(cat);
			app.run();
		} catch (Exception e) {
			System.err.println("Oops...\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// once every 4th year starting in year 0000
	public static class EveryFourYears extends TimeFactory {
		public static final String LABEL = "year4";
		public EveryFourYears() {
			super(new TimeDomainDefinition(LABEL, Resolution.YEAR, 0L, new Cycle(true, false, false, false)));
		}
	}

	// once every 4th year starting in year 0002
	public static class EveryFourYearsShiftedBy2 extends TimeFactory {
		public static final String LABEL = "year4s2";
		public EveryFourYearsShiftedBy2() {
			super(new TimeDomainDefinition(LABEL, Resolution.YEAR, 0L, new Cycle(false, false, true, false)));
		}
	}
	
	private final TimeDomainCatalog tdCat;

	public SummerWinterOlympics(TimeDomainCatalog catalog) {
		super();
		this.tdCat = catalog;
	}
	
	public void run () throws Exception {
		
		TimeDomain year4 = tdCat.get(EveryFourYears.LABEL);
		TimeDomain year4s2 = tdCat.get(EveryFourYearsShiftedBy2.LABEL);
		
		TimeAddressable<String> solympics = new RegularTimeSeries<String>(String.class, year4);
		TimeAddressable<String> wolympics = new RegularTimeSeries<String>(String.class, year4s2);
		
		solympics.put(year4.time("1996"), new String[] {"Atlanta", "Sydney", "Athens", "Beijing"});
		wolympics.put(year4s2.time("1998"), new String[] {"Nagano", "Salt Lake City", "Turin", "Vancouver"});
		
		System.out.println("Some summer games:");
		for (Observation<String> oly : solympics) {
			System.out.println(oly.toString());
		}
		System.out.println("Some winter games:");
		for (Observation<String> oly : wolympics) {
			System.out.println(oly.toString());
		}
	}
	
	
	
}

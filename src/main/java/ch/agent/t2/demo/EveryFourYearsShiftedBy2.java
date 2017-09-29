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
import ch.agent.t2.time.Resolution;
import ch.agent.t2.time.TimeDomainDefinition;
import ch.agent.t2.time.TimeFactory;

/**
 * Once every four years, shifted by 2 years.
 *
 * @author Jean-Paul Vetterli
 */
public class EveryFourYearsShiftedBy2 extends TimeFactory {
	public EveryFourYearsShiftedBy2() {
		super(new TimeDomainDefinition("year4s2", Resolution.YEAR, 2L, new Cycle(false, false, true, false)));
	}
}

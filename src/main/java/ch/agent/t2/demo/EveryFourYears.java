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
 * Once every four years.
 *
 * @author Jean-Paul Vetterli
 */
public class EveryFourYears extends TimeFactory {
	public EveryFourYears() {
		super(new TimeDomainDefinition("year4", Resolution.YEAR, 0L, new Cycle(true, false, false, false)));
	}
}

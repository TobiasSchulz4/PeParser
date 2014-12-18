/*
 * Copyright 2012 dorkbox, llc
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
 */
package dorkbox.util.pe.types;

import dorkbox.util.OS;
import dorkbox.util.pe.headers.flags.SectionCharacteristics;

public class ULongSectionCharacteristics extends ByteDefinition<SectionCharacteristics[]> {

    private final int value;

    public ULongSectionCharacteristics(int value, String descriptiveName) {
        super(descriptiveName);
        this.value = value;
    }

    @Override
    public final SectionCharacteristics[] get() {
        return SectionCharacteristics.get(this.value);
    }

    @Override
    public void format(StringBuilder b) {
        SectionCharacteristics[] characteristics = get();

        b.append(getDescriptiveName()).append(": ").append(OS.LINE_SEPARATOR);

        if (characteristics.length > 0) {
            for (SectionCharacteristics c : characteristics) {
                b.append("\t * ").append(c.getDescription()).append(OS.LINE_SEPARATOR);
            }
        } else {
            b.append("\t * none").append(OS.LINE_SEPARATOR);
        }

        b.append(OS.LINE_SEPARATOR);
    }
}
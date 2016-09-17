/*
 * Copyright (c) 2016 Lucko (Luck) <luck@lucko.me>
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.luckperms.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.lucko.luckperms.core.LPConfiguration;

import java.util.Collections;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Contexts {
    public static Contexts fromConfig(LPConfiguration configuration) {
        return new Contexts(
                configuration.getServer(),
                null,
                Collections.emptyMap(),
                configuration.getIncludeGlobalPerms(),
                configuration.getIncludeGlobalWorldPerms(),
                true,
                configuration.getApplyGlobalGroups(),
                configuration.getApplyGlobalWorldGroups()
        );
    }

    public static Contexts allowAll() {
        return new Contexts(null, null, Collections.emptyMap(), true, true, true, true, true);
    }

    private final String server;
    private final String world;
    private final Map<String, String> extraContext;
    private final boolean includeGlobal;
    private final boolean includeGlobalWorld;
    private final boolean applyGroups;
    private final boolean applyGlobalGroups;
    private final boolean applyGlobalWorldGroups;

}

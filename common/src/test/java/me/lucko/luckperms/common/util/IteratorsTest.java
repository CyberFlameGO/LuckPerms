/*
 * This file is part of LuckPerms, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
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

package me.lucko.luckperms.common.util;

import com.google.common.collect.ImmutableList;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IteratorsTest {

    @Test
    public void testDivideEmpty() {
        assertEquals(ImmutableList.of(), Iterators.divideIterable(ImmutableList.of(), 2));
    }

    @Test
    public void testDivideSimple() {
        List<List<String>> expected = ImmutableList.of(
                ImmutableList.of("one", "two"),
                ImmutableList.of("three", "four"),
                ImmutableList.of("five")

        );
        List<List<String>> actual = Iterators.divideIterable(
                ImmutableList.of("one", "two", "three", "four", "five"),
                2
        );

        assertEquals(expected, actual);
    }

    @Test
    public void testDivideBoundary() {
        List<List<String>> expected = ImmutableList.of(
                ImmutableList.of("one", "two"),
                ImmutableList.of("three", "four")

        );
        List<List<String>> actual = Iterators.divideIterable(
                ImmutableList.of("one", "two", "three", "four"),
                2
        );

        assertEquals(expected, actual);
    }

}

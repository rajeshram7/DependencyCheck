/*
 * This file is part of dependency-check-core.
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
 * Copyright (c) 2013 Jeremy Long. All Rights Reserved.
 */
package org.owasp.dependencycheck.data.lucene;

import java.io.Reader;
import javax.annotation.concurrent.NotThreadSafe;
import org.apache.lucene.analysis.util.CharTokenizer;
import org.apache.lucene.util.Version;

/**
 * Tokenizes the input breaking it into tokens when non-alpha/numeric characters
 * are found.
 *
 * @author Jeremy Long
 */
@NotThreadSafe
public class AlphaNumericTokenizer extends CharTokenizer {

    /**
     * Constructs a new AlphaNumericTokenizer.
     *
     * @param matchVersion the lucene version
     * @param in the Reader
     */
    public AlphaNumericTokenizer(Version matchVersion, Reader in) {
        super(matchVersion, in);
    }

    /**
     * Constructs a new AlphaNumericTokenizer.
     *
     * @param matchVersion the lucene version
     * @param factory the AttributeFactory
     * @param in the Reader
     */
    public AlphaNumericTokenizer(Version matchVersion, AttributeFactory factory, Reader in) {
        super(matchVersion, factory, in);
    }

    /**
     * Determines if the char passed in is part of a token.
     *
     * @param c the char being analyzed
     * @return true if the char is a letter or digit, otherwise false
     */
    @Override
    protected boolean isTokenChar(int c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

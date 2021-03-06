/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.numberguess;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * <p>
 * Random number generator.
 * </p>
 *
 * <p>
 * Placing the random number generation, as well as the configuring the maximum number allows for a more loosely coupled
 * application. We can now change out the implementation of number generation without any effect on the client code. We also
 * produce a more intuitive design - both are identified by the fact they are numbers (int) and that they are qualified as the
 * maximum number or a random number.
 * </p>
 *
 * <p>
 * We use the application scope to store the random number generator so that we use the same seed.
 * </p>
 *
 * @author Pete Muir
 *
 */
@SuppressWarnings("serial")
@ApplicationScoped
public class Generator implements Serializable {

//    private java.util.Random random = new java.util.Random(System.currentTimeMillis());

    private int maxNumber = 100;

    int getRandom() {
    int n = (int)(Math.random() * 101);
    int numeroPari = n % 2 == 0 ? n : n + 1;
    return numeroPari;
    }

    @Produces
    @Random
    int next() {
        // a number between 1 and 100
        return getRandom();
    }

    @Produces
    @MaxNumber
    int getMaxNumber() {
        return maxNumber;
    }
}

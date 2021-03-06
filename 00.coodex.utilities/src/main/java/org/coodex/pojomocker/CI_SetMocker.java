/*
 * Copyright (c) 2017 coodex.org (jujus.shen@126.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * 
 */
package org.coodex.pojomocker;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author davidoff
 *
 */
public class CI_SetMocker extends CI_AbstractCollectionsMocker {

   /*
    * (non-Javadoc)
    * 
    * @see org.coodex.pojomock.refactoring.mockers.CI_AbstractCollectionsMocker#
    * createCollectionInstance(org.coodex.pojomock.refactoring.MockContext)
    */
   @SuppressWarnings("rawtypes")
   @Override
   protected Collection<?> createCollectionInstance(MockContext context) {
      return new HashSet();
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * org.coodex.pojomock.refactoring.AbstractClassInstanceMocker#access(java
    * .lang.Class)
    */
   @Override
   protected boolean access(Class<?> clz) {
      return clz == Set.class;
   }

}

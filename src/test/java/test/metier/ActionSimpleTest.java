/*
 * Copyright 2024 CamilleM.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.metier;

import gestion.metier.Jour;
import gestion.metier.ActionSimple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author CamilleM
 */
public class ActionSimpleTest {
    
   @Test
    public void testValeur() {
        // Arrange
        ActionSimple action = new ActionSimple("TestAction");
        Jour jourAvecCours = new Jour(2024, 2);
        Jour jourSansCours = new Jour(2024, 3);

        // Enregistrer un cours pour le jour avec cours
        action.enrgCours(jourAvecCours, 50.0f);

        // Act
        double valeurAvecCours = action.valeur(jourAvecCours);
        double valeurSansCours = action.valeur(jourSansCours);

        // Assert
        assertEquals(50.0, valeurAvecCours);
        assertEquals(0.0, valeurSansCours);
    }
}

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
package tp04.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author CamilleM
 */
public class ActionSimpleTest {
    
    @Test
    public void testValeur() {
         ActionSimple action = new ActionSimple("Action test");
        
        // Créer une instance de Jour avec l'année 2024 et le numéro de jour 2
        Jour jour = new Jour(2024, 2);

        // Act
        // Enregistrer un cours pour l'action à la date spécifiée (2024-2) avec une valeur de 1
        action.enrgCours(jour, 1);

        // Assert
        // Vérifier que la méthode valeur renvoie la valeur attendue, qui est 1
        float valeurAttendue = 1;
        assertEquals(valeurAttendue, action.valeur(jour));
    
}
}

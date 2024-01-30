/*
 * Copyright 2024 Hind NAOUI.
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
import gestion.metier.ActionSimple;
import java.util.Map;
import gestion.metier.ActionComposee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author Hind NAOUI
 */
public class ActionComposeeTest {
    private final ActionSimple bnp = new ActionSimple("BNP");
    private final ActionSimple axa = new ActionSimple("AXA");
    private final ActionSimple lcl = new ActionSimple("LCL");
    private final ActionComposee bqAss = new ActionComposee("Banque-Assurance");
    
    @Test
    public void testGetMapPanier(){
        //Enregistrement de la composition de l'action composée
        bqAss.enrgComposition(axa, 0.5f);
        bqAss.enrgComposition(bnp, 0.4f);
        bqAss.enrgComposition(lcl, 0.1f);
        
        // Récupération de la composition d'une action composée
        Map<ActionSimple, Float> composition = bqAss.getMapPanier();
        
        // Assertions pour vérifier que la composition contient les éléments attendus
        assertTrue(composition.containsKey(axa));
        assertEquals(0.5f, composition.get(axa), 0.001f); 
        assertTrue(composition.containsKey(bnp));
        assertEquals(0.4f, composition.get(bnp), 0.001f);
        assertTrue(composition.containsKey(lcl));
        assertEquals(0.1f, composition.get(lcl), 0.001f);
    }
}

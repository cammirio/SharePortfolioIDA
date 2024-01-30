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

import gestion.metier.ActionSimple;
import gestion.metier.Portefeuille;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import gestion.metier.Portefeuille.LignePortefeuille;


/**
 *
 * @author CamilleM
 */
public class PortefeuilleTest {
    HashMap<String, Integer> map = new HashMap<>();
    private ActionSimple act = new ActionSimple("Test");
    private Portefeuille p = new Portefeuille();
    
    @Test
    public void TestVendre() {
        p.acheter(act,20);
        p.vendre(act,10);
        assertEquals(p.getQte(act), 10);
        p.vendre(act, 10);
        assertNull(p.getAction(act));
        }
    
    @Test
    public void TestAcheter(){
        p.acheter(act, 10);
        int premiereQuantite = p.getQte(act);
        p.acheter(act, 10);
        
        assertEquals(p.getQte(act), 20);
        assertEquals(p.getQte(act), premiereQuantite+10);
    }
}

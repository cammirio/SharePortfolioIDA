/*
 * Copyright 2024 peachmois.
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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author peachmois
 */
public class JourTest {
    
    private Jour j = new Jour(2024, 2);
    private Jour j2 = new Jour(2024, 2);
    
    @Test
    public void testAnneeJour() 
    {
        
        assertEquals(2024, j.getAnnee());
        assertEquals(2, j.getNoJour());
    }
    
    @Test
    public void testEquals() 
    {
        // Créer deux objets Jour égaux

        Jour jourDifferent = new Jour(2023, 2);
        assertEquals(j,j);
        assertEquals(j,j2);
        assertFalse(j.equals(jourDifferent));
        assertFalse(j.equals("2024-02-01"));
        assertFalse(j.equals(null));
    }
    }

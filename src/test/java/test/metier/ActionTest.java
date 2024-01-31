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
import gestion.metier.Jour;
import gestion.metier.Action;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author CamilleM
 */
public class ActionTest {

    /**
     * Test of getLibelle method, of class Action.
     */
    @Test
    public void testGetLibelle() 
    {
    
        ActionSimple action1 = new ActionSimple("Action 1");
        assertEquals("Action 1", action1.getLibelle());
    }
        // TODO review the generated test code and remove the default call to fail.
       
     @Test
    public void testToString() 
    {
        ActionSimple action1 = new ActionSimple("Action 1");
        assertEquals("Action 1", action1.toString());
    }
    
    @Test
    public void testEquals() 
    {
     
        ActionSimple action1 = new ActionSimple("Test Action");
        ActionSimple action2 = new ActionSimple("Test Action");

        ActionSimple actionDifferent = new ActionSimple("AutreLibelle");
        assertTrue(action1.equals(action1));
        assertTrue(action1.equals(action2));
        assertFalse(action1.equals(actionDifferent));
      
    }
    
}

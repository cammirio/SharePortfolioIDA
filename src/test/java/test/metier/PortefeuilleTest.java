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
import gestion.metier.Jour;
import gestion.metier.ActionComposee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


/**
 *
 * @author CamilleM
 */
public class PortefeuilleTest {
  private final ActionSimple act = new ActionSimple("Test");
  private final Portefeuille p = new Portefeuille();
    
  @Test
  // Vérifier la méthode Vendre() renvoie bien dans le portefeuille
  public void TestVendre() {
    // Action
    p.acheter(act,20);
    p.vendre(act,10);
    // Assert
    assertEquals(10,p.getQte(act));
    // Action
    p.vendre(act, 10);
    // Assert
    assertNull(p.getAction(act));
    }
    
  @Test
  // Vérifier la méthode Vendre() renvoie bien dans le portefeuille
  public void TestAcheter(){
    // Action
    p.acheter(act, 10);
    int premiereQuantite = p.getQte(act);
    p.acheter(act, 10);   
    // Assert
    assertEquals(20,p.getQte(act));
    assertEquals(p.getQte(act), premiereQuantite+10);
    }
    
  @Test 
  // Vérifier s'il renvoie bien quand on achète des actions composées
  public void testAcheterActionComposee() {   
    // Arrange
    ActionComposee actionComposee = new ActionComposee("Action Composee Test");
    ActionSimple action1 = new ActionSimple("Action 1");
    ActionSimple action2 = new ActionSimple("Action 2");
    Jour jour = new Jour(2024, 2);
    Portefeuille portefeuille = new Portefeuille();
    
    // Action
    action1.enrgCours(jour, 30.0f); 
    action2.enrgCours(jour, 20.0f); 
    actionComposee.enrgComposition(action1, 0.5f); 
    actionComposee.enrgComposition(action2, 0.5f); 
    portefeuille.acheter(actionComposee, 5);
    
    // Assert
    assertEquals(5, portefeuille.getQte(actionComposee));
    float valeurAttendue = 5 * (0.5f * 30.0f + 0.5f * 20.0f);
    assertEquals(valeurAttendue, portefeuille.valeur(jour));
    }

  @Test
  // Vérifier s'il renvoie bien quand on vend des actions avec un prix dans une journée donnée
  public void testVendreActionAuPrixDuJour() {
    // Arrange
    ActionSimple action = new ActionSimple("Test Action");
    Jour jour = new Jour(2024, 2);
    float prixDuJour = 50; 
    Portefeuille portefeuille = new Portefeuille();
    
    // Action
    portefeuille.acheter(action, 10); 
    action.enrgCours(jour, prixDuJour); 
    portefeuille.vendre(action, 1); 
    assertEquals(9, portefeuille.getQte(action));
    float valeurAttendue = 9 * prixDuJour;
    
    // Assert
    assertEquals(valeurAttendue, portefeuille.valeur(jour));
    
    assertThrows(IllegalStateException.class, () -> portefeuille.vendre(action, 11));
    }
   @Test
    //  Vérifier que la méthode toString() renvoie bien le string pour Integer
    public void testIntegerToString() {
        // Arrange
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille.LignePortefeuille lignePortefeuille = new Portefeuille.LignePortefeuille(action, 10);
        // Action
        String result = lignePortefeuille.toString();
        // Assert
        assertEquals("10", result);}
    
    @Test
    // Vérifier que la méthode toString() renvoie bien le string pour MapLignes
    public void testToStringMapLignes() {
        // Arrange
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille portefeuille = new Portefeuille();
        // Action
        portefeuille.acheter(action, 10);
        
        String result = portefeuille.toString();
        // Assert
        assertEquals("{TestAction=10}", result);
    }
}

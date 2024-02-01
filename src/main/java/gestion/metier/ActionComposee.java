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

package gestion.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author perussel
 */
public class ActionComposee extends AbstractAction {
    // attribut lien
  Map<ActionSimple, Float> mapPanier;

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 41 * hash + Objects.hashCode(this.mapPanier);
    return hash;
    }
    

  
    /**
     * Permet d'initialiser une action composée à partir d'un libellé
     *
     * @return le hash code de l'action composée
     */
  public ActionComposee(String libelle) {
    super(libelle);
    this.mapPanier = new HashMap();
    }
    
    /**
     * Permet d'enregistrer les actions simples d'une action compossée avec un pourcentage de composition
     *
     * @return chaque action simple dans son action composée
     */
  public void enrgComposition(ActionSimple as, float pourcentage) {
    this.mapPanier.put(as, pourcentage);
    }
    
   
    /**
     * Permet de calculer la valeur totale de l'action composée avec le cours du jour
     *
     * @return la valeur de l'action composée
     */
  @Override
  public double valeur(Jour j) {
    double valeur;   
    valeur = 0;
    for(ActionSimple as : this.mapPanier.keySet()) {
      valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));

      } 
    return valeur;
    }
    

    /**
     * Permet de retourner la panier d'une action composée
     *
     * @return le panier d'actions composées
     */
  public Map<ActionSimple, Float> getMapPanier() {
    return this.mapPanier;

    }
    

     
    
    
}

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

/**
 *
 * @author perussel
 */
public class Portefeuille {
    
  Map<AbstractAction, LignePortefeuille> mapLignes;
    
  public static class LignePortefeuille {
        
    private AbstractAction action;
        
    private int qte;
        
    /**
     * Permet d'avoir la quantité d'une action
     *
     * @return la quantité d'une action
     */
    public int getQte() {
      return qte;
    }
        
    /**
     * Permet de modifier la quantité d'une action
     *
     * @return la valeur modifiée de la quantité d'une action
     */
    public void setQte(int qte) {
      this.qte = qte;
    }
        
    /**
     * Permet de récupérer une action
     *
     * @return l'action
     */
    public AbstractAction getAction() {
      return this.action;
    }
        
    /**
     * Permet d'instancier une action avec une quantité dans un portefeuille
     *
     * @return
     */
    public LignePortefeuille(AbstractAction action, int qte) {
      this.action = action;
      this.qte = qte;
    }

    /**
     * Permet de passer la quantité instanciée d'entier à string
     *
     * @return la valeur de la quantité en chaîne de cracatère
     */
    public String toString() {
      return Integer.toString(qte);
    }
}
    /**
     * Permet de stocker des lignes d'actions dans un portefeuille
     *
     * @return
     */
    public Portefeuille() {
      this.mapLignes = new HashMap();
    }
    
    /**
     * Permet d'acheter une action
     *
     * @return
     */
    public void acheter(AbstractAction a, int q) {
      if (this.mapLignes.containsKey(a) == false) {
        this.mapLignes.put(a, new LignePortefeuille(a, q));
      } else {
        this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    /**
     * Permet de vendre une action
     *
     * @return
     */
    public void vendre(AbstractAction a, int q) {
      if (this.mapLignes.containsKey(a) == true) {
          if (this.mapLignes.get(a).getQte() > q) {
              this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }else {
              throw new IllegalStateException();
            }
        }        
    }
    
    public String toString() {
      return this.mapLignes.toString();
    }
    
    public int getQte(AbstractAction a) {
      return this.mapLignes.get(a).getQte();
    }

    public LignePortefeuille getAction(AbstractAction a){
      return this.mapLignes.get(a);
    }
  
    /**
     * Permet de calculer la valeur totale du portfeuille
     *
     * @return la valeur totale
     */
    public double valeur(Jour j) {
      double total = 0;
      for (LignePortefeuille lp : this.mapLignes.values()) {
          total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
      return total;
    }
}

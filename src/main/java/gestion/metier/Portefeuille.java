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
    
    Map<Action, LignePortefeuille> mapLignes;
    
    public static class LignePortefeuille {
        
        private Action action;
        
        private int qte;
        
        public int getQte() 
        {
            return qte;
        }
        
        public void setQte(int qte) 
        {
            this.qte = qte;
        }
        
        public Action getAction() 
        {
            return this.action;
        }
        
        public LignePortefeuille(Action action, int qte) 
        {
            this.action = action;
            this.qte = qte;
        }

        public String toString() 
        {
            return Integer.toString(qte);
        }
    }
    
    public Portefeuille() 
    {
        this.mapLignes = new HashMap();
    }
    
    public void acheter(Action a, int q) 
    {
        if (this.mapLignes.containsKey(a) == false) 
        {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else 
        {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    public void vendre(Action a, int q) 
    {
        if (this.mapLignes.containsKey(a) == true) 
        {
            if (this.mapLignes.get(a).getQte() > q) 
            {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) 
            {
                this.mapLignes.remove(a);
            }else
            {
            throw new IllegalStateException();
            }
        }        
    }
    
    public String toString() 
    {
        return this.mapLignes.toString();
    }
    
    public int getQte(Action a) 
    {
            return this.mapLignes.get(a).getQte();
        }

    public LignePortefeuille getAction(Action a)
    {
        return this.mapLignes.get(a);
    }
  
    public double valeur(Jour j) 
    {
        double total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) 
        {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }
}

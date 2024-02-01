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

import java.util.Objects;

/**
 *
 * @author perussel
 */
public abstract class AbstractAction {
  private final String libelle;
  
  protected AbstractAction(String libelle) {
    this.libelle = libelle;
    }

    //Permet de récupérer la valeur du libellé
    //Retourne la valeur du libellé
  public String getLibelle() {
    return libelle;
    }

  public abstract double valeur(Jour j);
    

  
  //Permet de faire un code hashage
  //Retourne la valeur du hashCode
  @Override
   
  public int hashCode() {
    var hash = 3;
    hash = 53 * hash + Objects.hashCode(this.libelle);
    return hash;
    }

   //Comparaison de deux objets afin de savoir si ils sont égaux
   //Retourne la true si égal, false sinon
  @Override
     
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final AbstractAction other = (AbstractAction) obj;
    if (!Objects.equals(this.libelle, other.libelle)) {
      return false;

      }
    return true;
    }

    
    //Permet de mettre le libellé sous chaîne de caractère
    //Retourne la chaîne de caractère du libellé
  public String toString() {
    return this.getLibelle();

    }
}

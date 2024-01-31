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
package execution.exec;
import gestion.metier.ActionComposee;
import gestion.metier.ActionSimple;
import gestion.metier.Jour;
import gestion.metier.Portefeuille;
import java.util.Map;


public class Run 
{
  public static final int COURSJ1 = 200;
  public static final int COURSJ2 = 250;
  public static final int COURSJ11 = 100;
  public static final int COURSJ22 = 200;
  public static final int QTEAXA = 10;
  public static final int QTEBNP = 20;
  public static final int QTEBQASS = 5;
  public static final int QTE2BQASS = 15;
  public static final int QTEAXA2 = 5;
  public static final int QTEAXA3 = 5;
  public static final int QTEAXA4 = 5;
  public static final int QTEBNP2 = 50;
  public static final String PORTEFEUILLE = "Portefeuille : ";
  public static final int ANNEE = 2014;
  public static final int JOUR1 = 1;
  public static final int JOUR2 = 2;
  public static final float POURCENTAGE1 = 0.3F;
  public static final float POURCENTAGE2 = 0.7F;
  public static final float CONSTANTE = 100;
    
  public static void main(String[] args) 
    {
    ActionSimple bnp, axa;
    ActionComposee bqAss;
    Jour j1, j2;

    // init des objets metiers Jour
    j1 = new Jour(ANNEE, JOUR1);
    j2 = new Jour(ANNEE, JOUR2);

    // creation d'actions simples et composée
    bnp = new ActionSimple("BNP");
    axa = new ActionSimple("AXA");
    bqAss = new ActionComposee("Banque-Assurance");
            // enrg de la composition de l'action composée
    bqAss.enrgComposition(axa, POURCENTAGE1);
    bqAss.enrgComposition(bnp, POURCENTAGE2);
    // enrg. de 2 cours pour chaque action 
    axa.enrgCours(j1, COURSJ1);
    axa.enrgCours(j2, COURSJ2);
    bnp.enrgCours(j1, COURSJ11);
    bnp.enrgCours(j2, COURSJ22);
    // affichage des cours - comme 1 action simple et 1 action
    System.out.println("Action simple *bnp* à j1 : " + bnp.valeur(j1));
    System.out.println("Action *Banque-Assurance* à j2 : " + bqAss.valeur(j2));
    // Récupération de la composition d'une action composée
    Map<ActionSimple, Float> composition = bqAss.getMapPanier();

    // Affichage de la composition d'une action composée
    System.out.println("Composition de l'action composée : " + bqAss.getLibelle());
    for (Map.Entry<ActionSimple, Float> entry : composition.entrySet()) 
    {
    System.out.println(entry.getKey().getLibelle() + " : " + entry.getValue() * CONSTANTE + "%");
    }

    Portefeuille p;
    p = new Portefeuille();
    p.acheter(axa, QTEAXA);
    System.out.println(PORTEFEUILLE + p);
    p.acheter(bnp, QTEBNP);
    System.out.println(PORTEFEUILLE + p);
    p.acheter(bqAss, QTEBQASS);
    System.out.println(PORTEFEUILLE + p);
    p.acheter(bqAss, QTE2BQASS);
    System.out.println(PORTEFEUILLE + p);
    System.out.println("Portefeuille à j1 : " + p.valeur(j1));
    p.vendre(axa, QTEAXA2);
    System.out.println(PORTEFEUILLE + p);
    p.vendre(axa, QTEAXA3);
    System.out.println(PORTEFEUILLE + p);
    p.vendre(axa, QTEAXA4);
    System.out.println(PORTEFEUILLE + p);
    p.vendre(bnp, QTEBNP);
    System.out.println(PORTEFEUILLE + p);
    }
}

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


public class Run {
    public static final int coursj1 = 200;
    public static final int coursj2 = 250;
    public static final int coursj11 = 100;
    public static final int coursj22 = 200;
    public static final int qteAxa = 10;
    public static final int qteBnp = 20;
    public static final int qtebqAss = 5;
    
    public static void main(String[] args) {
        ActionSimple bnp, axa;
        ActionComposee bqAss;
        Jour j1, j2;

        // init des objets metiers Jour
        j1 = new Jour(2014, 1);
        j2 = new Jour(2014, 2);

        // creation d'actions simples et composée
        bnp = new ActionSimple("BNP");
        axa = new ActionSimple("AXA");
        bqAss = new ActionComposee("Banque-Assurance");
        // enrg de la composition de l'action composée
        bqAss.enrgComposition(axa, 0.3F);
        bqAss.enrgComposition(bnp, 0.7F);
        // enrg. de 2 cours pour chaque action 
        axa.enrgCours(j1, coursj1);
        axa.enrgCours(j2, coursj2);
        bnp.enrgCours(j1, coursj11);
        bnp.enrgCours(j2, coursj22);
        // affichage des cours - comme 1 action simple et 1 action
        System.out.println("Action simple *bnp* à j1 : " + bnp.valeur(j1));
        System.out.println("Action *Banque-Assurance* à j2 : " + bqAss.valeur(j2));
        // Récupération de la composition d'une action composée
        Map<ActionSimple, Float> composition = bqAss.getMapPanier();

        // Affichage de la composition d'une action composée
        System.out.println("Composition de l'action composée : " + bqAss.getLibelle());
        for (Map.Entry<ActionSimple, Float> entry : composition.entrySet()) {
        System.out.println(entry.getKey().getLibelle() + " : " + entry.getValue() * 100 + "%");
        }

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(axa, qteAxa);
        System.out.println("Portefeuille : " + p);
        p.acheter(bnp, qteBnp);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, qtebqAss);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, 15);
        System.out.println("Portefeuille : " + p);
        System.out.println("Portefeuille à j1 : " + p.valeur(j1));
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(bnp, 50);
        System.out.println("Portefeuille : " + p);
 
    }

}

/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2013 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package tp.exec;

import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Jour;
import tp04.metier.Portefeuille;
import java.util.Map;


public class Run {

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
        bqAss.enrgComposition(axa, 0.3f);
        bqAss.enrgComposition(bnp, 0.7f);
        // enrg. de 2 cours pour chaque action 
        axa.enrgCours(j1, 200);
        axa.enrgCours(j2, 250);
        bnp.enrgCours(j1, 100);
        bnp.enrgCours(j2, 200);
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
        p.acheter(axa, 10);
        System.out.println("Portefeuille : " + p);
        p.acheter(bnp, 20);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, 5);
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

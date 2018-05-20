package com.example.duret.iceandroid;

import java.util.Arrays;
import java.util.List;

/*
  Pour avoir une analyseur de requête performant on aurait pu utiliser un modèle word-to-vec
  qui aurait permis d'avoir des actions basées sur des mots similaires de manière automatique.

  L'analyseur de requêtes peut :
    - lancer des musiques (mots-clés : lancer/lance)
    - arrêter la musique en cours (mots-clés : arrêter/stop)
    - faire une recherche (mots-clés : chercher/cherche)

  Le résultat contiendra un tableau de String avec 2 cases
  (une pour l'action et une pour la cible s'il y en a une)
 */
public class RequestParser {

    private static List<String> actionsList = Arrays.asList(
            "lancer", "lance",
            "arrêter", "stop",
            "chercher", "cherche"
    );

    public static String[] parse(String request) {
        if (request.length() < 3 || !request.contains(" "))
            return null;

        String[] requestResults = null;

        try {
            requestResults = request.split(" ");
            String action = requestResults[0];
            String target = "";

            if (! actionsList.contains(action)) {
                throw new IllegalArgumentException("L'action '"+action+"' n'existe pas.");
            }

            for (int i=1; i < requestResults.length; i++) {
                target += requestResults[i];
                if (i != requestResults.length -1)
                    target += " ";
            }

            if (action.equals("lancer") || action.equals("lance")) {
                if (target.contains("la")) {
                    target = target.replace("la", "");
                }
                if (target.contains("musique")) {
                    target = target.replace("musique", "");
                }
            }
            while (target.contains("  ")) {
                target = target.replace("  ", " ");
            }
            while (target.charAt(0) == ' ') {
                target = target.substring(1, target.length());
            }

            System.out.print("action(" + action + ") / ");
            System.out.println("target(" + target + ")");

            requestResults = new String[] {action, target};
        }
        catch (Exception e) {
            System.out.println("Exception : "+e.getMessage());
            requestResults = new String[] {"Exception", e.getMessage()};
        }

        return requestResults;
    }
}

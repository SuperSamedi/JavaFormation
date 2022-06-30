package com.digitalcity.advanced.threads.randomsentence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class GenerateRandomSentence {

// Créez un ExecutorService de 3 Thread;
//
// Demander à l'ExecutorService de realiser 6x
// l'opération suivante: (Callable)
//
// générer un mot de 2 à 6 lettre minuscules aléatoires.
//
// (Attendre les résultats)
// Une fois les 6 mots générés formez une phrase avec ces mots
// et ecrivez la en console.
//
// Résultat possible:
// azda danoah zd acdc tterss op

    private final static Random rng = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        int numberOfWords = 6;
        String result;
        List<String> words = new ArrayList<>();
        List<Future<String>> actions = new ArrayList<>();


        // Launch threads
        for (int i = 0; i < numberOfWords; i++) {
            actions.add(executor.submit(GenerateRandomSentence::generateWord));
        }

        executor.shutdown();

        actions.forEach( f -> {
            try {
                words.add(f.get());
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        result = buildSentence(words);

        System.out.println("Random sentence :");
        System.out.println(result);
    }

    private static char randomLetter() {
        return (char) (rng.nextInt(97, 123));
    }

    private static String generateWord() {
        System.out.println(Thread.currentThread().getName() + " > starts generating a word.");

        int wordLength = rng.nextInt(2, 7);
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < wordLength; i++) {
            word.append(randomLetter());
        }

        System.out.println(Thread.currentThread().getName() + " > generated word = " + word);

        return word.toString();
    }

    private static String buildSentence(List<String> words){
        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            if (i == 0) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
            }

            sBuilder.append(word);

            if (i != words.size() - 1) {
                sBuilder.append(" ");
            } else {
                sBuilder.append(".");
            }
        }

        return sBuilder.toString();
    }
}

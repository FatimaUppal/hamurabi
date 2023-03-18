package hammurabi.src.main.java;

import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    private int population;
    private int immigrants;
    private int starvedPeople;
    private int grainsEatenByRats;
    private int bushelsInStorage;
    private int acresOwned;
    private int price;
    private int years;
    private int harvest;

    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public Hammurabi() {
        this.population = 100;
        this.immigrants = 5;
        this.starvedPeople = 0;
        this.grainsEatenByRats = 200;
        this.bushelsInStorage = 2800;
        this.acresOwned = 1000;
        this.price = random.nextInt(26 - 17 + 1) + 17;
        this.years = 1;
        this.harvest = random.nextInt(6 - 1 + 1) + 1;
    }

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }


    public void gameInitializer() {

        System.out.println("         _______  _______  _______           _______  _______  ______  _________\n" +
                "|\\     /|(  ___  )(       )(       )|\\     /|(  ____ )(  ___  )(  ___ \\ \\__   __/\n" +
                "| )   ( || (   ) || () () || () () || )   ( || (    )|| (   ) || (   ) )   ) (   \n" +
                "| (___) || (___) || || || || || || || |   | || (____)|| (___) || (__/ /    | |   \n" +
                "|  ___  ||  ___  || |(_)| || |(_)| || |   | ||     __)|  ___  ||  __ (     | |   \n" +
                "| (   ) || (   ) || |   | || |   | || |   | || (\\ (   | (   ) || (  \\ \\    | |   \n" +
                "| )   ( || )   ( || )   ( || )   ( || (___) || ) \\ \\__| )   ( || )___) )___) (___\n" +
                "|/     \\||/     \\||/     \\||/     \\|(_______)|/   \\__/|/     \\||/ \\___/ \\_______/\n" +
                "                                                                                 ");

        System.out.println("O great Harambe!\n" +
                "You are in year " + years + " of your ten year rule.\n" +
                "In the previous year " + starvedPeople + " people starved to death.\n" +
                "In the previous year " + immigrants + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "Harvesting was done at " + harvest + " bushels per acre.\n" +
                "Rats destroyed " + grainsEatenByRats + " bushels, leaving " + bushelsInStorage + " bushels in storage.\n" +
                "The city owns " + acresOwned + " acres of land.\n" +
                "Land is currently worth " + price + " bushels per acre.\n");
    }
    public void playGame(){
        this.population = 100;
        this.immigrants = 5;
        this.starvedPeople = 0;
        this.grainsEatenByRats = 200;
        this.bushelsInStorage = 2800;
        this.acresOwned = 1000;
        this.price = random.nextInt(26 - 17 + 1) + 17;
        this.years = 1;
        this.harvest = random.nextInt(6 - 1 + 1) + 1;


        while( years<= 10){
            gameInitializer();
            years++;

            while (true){

            }








        }
    }
















}

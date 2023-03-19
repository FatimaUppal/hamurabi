package hammurabi.src.main.java;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    private static Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    int population;
    int immigrants;
    int starvedPeople;
    int bushelsEatenByRats;
    int bushelsInStorage;
    int acresOwned;
    int price;
    int years;
    int harvest;
    int acresToFarm;
    int bushelToFeed;
    int bushelHarvested;
    int deathTotal;
    boolean plague;
    boolean uprising;
    int plagueDeath;


    public static void main(String[] args) {
        Hammurabi ham = new Hammurabi();
        ham.gameInitializer();
        ham.playGame();
        ham.finalSummary();
    }

    public void playGame() {

        do{
            askHowManyAcresToBuy();
            askHowManyAcresToSell(acresOwned);
            askHowMuchGrainToFeedPeople(this.bushelsInStorage);
            askHowManyAcresToPlant(this.acresOwned,this.population,this.bushelsInStorage);
            plague(this.population);
            starvation(this.population,this.bushelToFeed);
            if (uprising==true){
                break;
            }
            if (starvedPeople==0){
                immigrants(this.population,this.acresOwned,this.bushelsInStorage);
            }

            harvest(this.acresOwned,this.bushelHarvested);
            bushelsEatenByRats(bushelsInStorage);
            newCostOfLand();
            printSummary();
            resetValues();
            years+=1;
        }while (uprising==false && years <=10);
    }
    private void gameInitializer() {
        this.population = 100;
        this.immigrants = 5;
        this.starvedPeople = 0;
        this.bushelsEatenByRats = 200;
        this.bushelsInStorage = 2800;
        this.acresOwned = 1000;
        this.price = 19;
        this.years = 1;
        this.harvest = 3;
        this.acresToFarm = 1000;
        this.bushelToFeed = 0;
        this.bushelHarvested = 3000;
        this.deathTotal = 0;
        this.plague = false;
        this.uprising = false;
        this.plagueDeath=0;

        System.out.println("         _______  _______  _______           _______  _______  ______  _________\n" +
                "|\\     /|(  ___  )(       )(       )|\\     /|(  ____ )(  ___  )(  ___ \\ \\__   __/\n" +
                "| )   ( || (   ) || () () || () () || )   ( || (    )|| (   ) || (   ) )   ) (   \n" +
                "| (___) || (___) || || || || || || || |   | || (____)|| (___) || (__/ /    | |   \n" +
                "|  ___  ||  ___  || |(_)| || |(_)| || |   | ||     __)|  ___  ||  __ (     | |   \n" +
                "| (   ) || (   ) || |   | || |   | || |   | || (\\ (   | (   ) || (  \\ \\    | |   \n" +
                "| )   ( || )   ( || )   ( || )   ( || (___) || ) \\ \\__| )   ( || )___) )___) (___\n" +
                "|/     \\||/     \\||/     \\||/     \\|(_______)|/   \\__/|/     \\||/ \\___/ \\_______/\n" +
                "                                                                                 ");

        System.out.println("Congratulations!, you are the newest ruler of ancient Sumer, elected for a ten year term of office.\n" +
                        "Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people.\nWatch out for rat infestiations and the plague! Grain is the general currency, measured in bushels./n" +
                    "The following will help you in your decisions:\n" +
                        "   Each person needs at least 20 bushels of grain per year to survive\n" +
                        "   Each person can farm at most 10 acres of land\n" +
                        "   It takes 2 bushels of grain to farm an acre of land\n" +
                        "   The market price for land fluctuates yearly\n" +
                "Rule wisely and you will be showered with appreciation at the end of your term. Rule poorly and you will be kicked out of office!\n");
    }
    public void printSummary () {
        System.out.println(
                "You are in year " + years + " of your ten year rule.\n" +
                        "In the previous year " + starvedPeople + " people starved to death.\n" +
                        "In the previous year " + immigrants + " people entered the kingdom.\n" +
                        "The population is now " + population + ".\n" +
                        "Harvesting was done at " + harvest + " bushels per acre.\n" +
                        "Rats destroyed " + bushelsEatenByRats + " bushels, leaving " + bushelsInStorage + " bushels in storage.\n" +
                        "The city owns " + acresOwned + " acres of land.\n" +
                        "Land is currently worth " + price + " bushels per acre.\n");
    }
    public void finalSummary(){
        if (uprising) {
            System.out.println(
                    "Too many people have starved and there has been an uprising. " +
                    "Your rule is now over." );
        } else {
            System.out.println(
                    "\nIn your ten year term, Hammurabi, " + deathTotal + " of your subjects have died\n" +
                            "through plague, rats, and starvation. " +
                            "You leave your term with " + bushelsInStorage + " bushels of grain \n" +
                            "and " + acresOwned + " acres of land.");
        }

    }


    int getNumber (String message){ //
        while (true) {
            System.out.println(message);
            try {
                return Math.abs(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }
    public void askHowManyAcresToBuy() {

        while (true) {
            int num = getNumber("How many acres of land do you wish to buy? \n");
            //if (num < 0) continue;
            if (num == 0) {
                askHowManyAcresToSell(acresOwned);
                break;
            } else if (num * price <= bushelsInStorage) {
                acresOwned += num;
                bushelsInStorage -= num * price;
                break;
            } else {
                System.out.println("You do not have enough grain for that.");
            }
        }

    }


    public int askHowManyAcresToSell (int acresOwned){
            while (true) {
                int num = getNumber("How many acres of land do you wish to sell? \n");
                if (num > acresOwned) {
                    System.out.println("O no! You do not have enough land for that!");
                } else {
                    acresOwned -= num;
                    bushelHarvested += num * price;
                    break;
                }
            }return acresOwned;
    }



    public void askHowMuchGrainToFeedPeople (int bushelsInStorage){
        while (true) {
            int num = getNumber("How much grain would you like to feed people? \n");
            if (num > bushelsInStorage) {
                System.out.println("You dont have enough bushels for that.");
            } else {
                bushelsInStorage -= num;
                bushelHarvested=num;
                break;
            }
        }
    }
    public void askHowManyAcresToPlant (int acresOwned, int population, int bushelsInStorage){
        while (true) {
            int num = getNumber("How many acres of land do you wish to plant in?\n");
            if (num > acresOwned) {
                System.out.println("You don't have enough land for that\n");
            } else if (num > population * 10) {
                System.out.println("You don't have enough people for that\n");
            } else if (num * 2 > bushelsInStorage) {
                System.out.println("You don't have enough bushels\n");
            } else {
                acresToFarm = num;
                break;
            }
        }
    }
    public  int plague(int population) {
        int randomPlague;
        randomPlague = random.nextInt(20);
        if (randomPlague > 16){
            plagueDeath = (population / 2);
        }
        else plagueDeath = 0;
        return  plagueDeath;
    }


    public int starvation(int population, int bushelsToFeed){
        int starvedPeople = 0;
        if((population * 20) > bushelsToFeed){
            System.out.println("Some of your followers will starved to death.\n");
            starvedPeople = (population - (bushelsToFeed / 20));
            this.deathTotal += starvedPeople;
            return this.starvedPeople = starvedPeople;
        } else return this.starvedPeople = starvedPeople;
    }


    public boolean uprising ( int population, int starvedPeople){
        if (population == 0){
            return true;
        }
        else if ((starvedPeople* 100) / population >= 45){
            return true;
        }
        else {return false;
        }
    }
    public Integer immigrants ( int population, int acresOwned, int bushelsInStorage){
        int immigrants;
        immigrants = (20 * acresOwned + bushelsInStorage) / (100 * population) + 1;
        this.population += immigrants;
        return this.immigrants = immigrants;
    }
    public  int harvest(int acresToFarm, int bushelHarvested){
        int harvests = (random.nextInt(6)+1 * acresToFarm);
        return harvests;
    }
    public  Integer bushelsEatenByRats(int bushelsInStorage) {

        int ratEats = 0;
        int ratInfestRate = random.nextInt(100);

        if (ratInfestRate < 40) {
            ratEats = ((10 + random.nextInt(21)) * bushelsInStorage) / 100;
        }
        return ratEats;
    }
    public int newCostOfLand(){
        int price;
        price = random.nextInt(23 - 17 + 1) + 17;
        this.price = price;
        this.years++;
        return this.price;
    }
    public void resetValues(){
        this.plagueDeath = 0;
        this.bushelsEatenByRats = 0;
    }

}



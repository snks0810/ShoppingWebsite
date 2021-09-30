package cucumberMuck;

import ToyProject.InitialiseWishlistTest;
import ToyProject.StringProcessor;
import io.cucumber.java.bs.I;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.Collections;

public class MyStepdefs {

        @Given("I add four different products to my wish list")
        public void addToWishlist(){
            InitialiseWishlistTest someInstance = new InitialiseWishlistTest();
            someInstance.setUp();
            someInstance.initialiseWishlist();
        }

        @When("I view my wishlist table")
        public void viewWishlist() throws InterruptedException {
             InitialiseWishlistTest someInstance = new InitialiseWishlistTest();
             someInstance.setUp();
             someInstance.scrapePrice();
        }

        @Then("I find total four selected items in my wishlist")
        public void findTotalItems() throws InterruptedException {
                InitialiseWishlistTest someInstance = new InitialiseWishlistTest();
                someInstance.setUp();
                someInstance.scrapePrice();
        }

        @When("I search for lowest price product")
        public void searchForCheapest(){
                InitialiseWishlistTest someInstance = new InitialiseWishlistTest();
                someInstance.setUp();
                someInstance.initialiseWishlist();
                ArrayList<Double> prices = new ArrayList<>();
                for(int i = 0; i < someInstance.scrapePrice().size(); i++) {
                    prices.add(StringProcessor.poundRemoval(someInstance.scrapePrice()).get(i));
                }
                StringProcessor.findSmallest(prices);
        }

        @And("I am able to add the lowest price item to my cart")
        public void addCheapestToCart(){
            InitialiseWishlistTest someInstance = new InitialiseWishlistTest();
            someInstance.setUp();
            someInstance.initialiseWishlist();
        }

        @Then("I am able to verify the item in my cart")
        public void addToCart(){
            InitialiseWishlistTest someInstance = new InitialiseWishlistTest();
            someInstance.setUp();
            someInstance.initialiseWishlist();
            ArrayList<Double> prices = new ArrayList<>();
            for(int i = 0; i < someInstance.scrapePrice().size(); i++) {
                prices.add(StringProcessor.poundRemoval(someInstance.scrapePrice()).get(i));
            }
            someInstance.verifyCheapest(StringProcessor.findSmallest(prices));
        }
}

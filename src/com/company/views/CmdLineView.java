package com.company.views;

import com.company.controllers.InputValidation;
import com.company.models.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class CmdLineView {

    private String movieInput;
    private String dateInput;
    private String ratingInput;
    private final Scanner in = new Scanner(System.in);


    public void promptInput(){

        System.out.println("Please enter a movie");
        System.out.print("Your Input: ");

        movieInput = in.nextLine();

        System.out.println("Please enter the release year");
        System.out.print("Your Input: ");

        dateInput = in.nextLine();

        System.out.println("Please enter the rating");
        System.out.print("Your Input: ");

        ratingInput = in.nextLine();
    }

    //Called after promptInput(), reports on invalid data
    public InputValidation isValid(){
        InputValidation iv = new InputValidation();
        int errorCode = iv.validateInput(movieInput, dateInput, ratingInput); //For easier reading

        if(errorCode == 1){
            System.out.println("Your Movie title was not a String variable");
            System.out.println("Please try again");
        }
        if(errorCode == 2){
            System.out.println("Your release date was not a String variable");
            System.out.println("Please try again");
        }
        if(errorCode == 3){
            System.out.println("Your rating was not a String variable");
            System.out.println("Please try again");
        }

        return iv;
    }

    public void displayData(ArrayList<Movie> list){
        for(Movie movie : list){
            System.out.println("ID: " + movie.getId());
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Release Date: " + movie.getReleaseYear());
            System.out.println("MPAA Rating: " + movie.getRating());
            System.out.print("\n");
        }
    }

    public String wishToContinue(){
        System.out.println("Do you wish to continue entering movies? (yes / no)");
        System.out.print("Your Input: ");

        return in.nextLine();
    }

    public void wrongInput(){
        System.out.println("Please enter a valid input");
    }

    public String getMovieInput() {
        return movieInput;
    }

    public String getDateInput() {
        return dateInput;
    }

    public String getRatingInput() {
        return ratingInput;
    }

}

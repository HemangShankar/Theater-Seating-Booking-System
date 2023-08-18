/*
AP Computer Science A
CSA Theater Seating Lab
Programmers: Hemang Shankar
Date: 2/8/2022
*/

import java.util.Scanner; //Import the Scanner Class

class Main {
  static Scanner myObj = new Scanner(System.in); //Creates a Scanner Object
  public static void main(String[] args) {
    
    //Intiializes and declares variable
    String ticketAgain = "Y";
    String seatPrice = "0";

    //Initializes and declares a 2D array 
    String[][] ticketPrices = { {"10", "10", "10", "10", "10", "10", "10", "10", "10", "10"}, 
                             {"10", "10", "10", "10", "10", "10", "10", "10", "10", "10"},
                             {"10", "10", "10", "10", "10", "10", "10", "10", "10", "10"}, 
                             {"10", "10", "20", "20", "20", "20", "20", "20", "10", "10"}, 
                             {"10", "10", "20", "20", "20", "20", "20", "20", "10", "10"}, 
                             {"10", "10", "20", "20", "20", "20", "20", "20", "10", "10"}, 
                             {"20", "20", "30", "30", "40", "40", "30", "30", "20", "20"}, 
                             {"20", "30", "30", "40", "50", "50", "40", "30", "30", "20"}, 
                             {"30", "40", "50", "50", "50", "50", "50", "50", "40", "30"} };

    System.out.println("\nWelcome to the Theater!");

    //Loop that uses sentinel value
    while(ticketAgain.equals("Y")){

      System.out.println("\n");

      //Prints out the 2D array
      for(int i = 0; i < ticketPrices.length; i++){
        for(int k = 0; k < ticketPrices[i].length; k++){
          System.out.print(ticketPrices[i][k] + "\t");
        }
        System.out.print("\n");
      }

      System.out.println("\nThe above chart includes the seating chart for the show with the respective prices!");

      System.out.println("\nIf the ticket price of a seat is 0, the seat is unavailable!");

      //Stores the user's choice of selecting a seat
      System.out.println("\nTo begin booking your seat, Enter " + "\"S\"" + " for a specific seat or " + "\"P\"" + " for a seat based on price!");
      String userMethod = myObj.nextLine();

      //Converts the input to upper case
      userMethod = userMethod.toUpperCase();
    
      //Repeatedly prompts the user to enter a valid choice of method for a seat
      while(!userMethod.equals("S") && !userMethod.equals("P")){
        System.out.println("\nInvalid choice of method to choose a seat. Valid methods include S or P.");
        userMethod = myObj.nextLine();
        userMethod = userMethod.toUpperCase();
      }

      //Uses conditional statements to call the methods for choosing a seat
      if (userMethod.equals("P")){
            System.out.println("\nPlease enter a price for a seat in the theater - 10,20,30,40,or 50");
            seatPrice = myObj.nextLine();
            while(!(seatPrice.equals("10") 
                    || seatPrice.equals("20") 
                    || seatPrice.equals("30") 
                    || seatPrice.equals("40") 
                    || seatPrice.equals("50")))
            {
              System.out.println("\nInvalid price to choose a seat. Valid price include 10,20,30,40, or 50");
              seatPrice = myObj.nextLine();
            }
          System.out.println(findSeatByPrice(ticketPrices,seatPrice));
      } 
      else{
        System.out.println("\nPlease enter a row for your seat in the theater!");
        int row = Integer.parseInt(myObj.nextLine());

        while(!(row >= 1 && row<=10)){
          System.out.println("\nInvalid Row. Theater has 9 rows in total. Valid row number are from 1 to 9");
          row = Integer.parseInt(myObj.nextLine());
        }
        row = row - 1;
        
        System.out.println("\nPlease enter a column for your seat in the theater!");
        int column = Integer.parseInt(myObj.nextLine());
        while(!(column >= 1 && column<=9)){
            System.out.println("\nInvalid column. Valid column should be greater than or equal to 1 but less than or equal to 10.");
            column = Integer.parseInt(myObj.nextLine());
          }
        column = column - 1;     
        System.out.println(findSeatByLocation(ticketPrices,row,column));
      }

      System.out.println("\n");

      //Asks the user if they want to buy more seats
      System.out.println("\nDo you want to buy more seats?");
      System.out.println("\nPlease enter " + "\"Y\"" + " or " + "\"N\"");
      ticketAgain = myObj.nextLine();
      ticketAgain = ticketAgain.toUpperCase();

      //Asks user to enter a valid input
      while(!ticketAgain.equals("Y") && !ticketAgain.equals("N")){
        System.out.println("\nInvalid response! Please enter either - Y or N");
        ticketAgain = myObj.nextLine();
        ticketAgain = ticketAgain.toUpperCase();
      }
    }
  }

  //Method to provide a seat based on user's price
  public static String findSeatByPrice(String ticketPrice[][], String seatPrice){
    //returns location of the seat based on user's price
    int row=0;
    int column=0;
    for(int i = 0; i<ticketPrice.length; i++){
      for(int j = 0; j<ticketPrice[0].length; j++){
        if(ticketPrice[i][j].equals(seatPrice)){
          ticketPrice[i][j] = "0";
          row = i+1;
          column = j+1;
          return "\nSeat Booked: Row "+row+", Column "+column+", \nSeat Price: $"+seatPrice;
        }
      }
    }
      return "No Seat available for given price";
  }
  //Method to provide a seat by location
  public static String findSeatByLocation(String ticketPrice[][], int row, int column){
    int bookedRow=0;
    int bookedColumn=0;
    if(!ticketPrice[row][column].equals("0")){
        ticketPrice[row][column] = "0";
        bookedRow = row+1;
        bookedColumn = column+1;
        return "\nSeat Booked: Row "+bookedRow+", Column "+bookedColumn+", \nSeat Price: $" + ticketPrice[bookedRow][bookedColumn];
    }
    else{
      return "The seat is unavailable - try another seat";
    }
  }
}

/*Test Cases
Welcome to the Theater!

10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
20  20  30  30  40  40  30  30  20  20
20  30  30  40  50  50  40  30  30  20
30  40  50  50  50  50  50  50  40  30

The above chart includes the seating chart for the show with the respective prices!

If the ticket price of a seat is 0, the seat is unavailable!

To begin booking your seat, Enter "S" for a specific seat or "P" for a seat based on price!
P

Please enter a price for a seat in the theater - 10,20,30,40,or 50
20

Seat Booked: Row 4, Column 3, 
Seat Price: $20




Do you want to buy more seats?

Please enter "Y" or "N"
Y
10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  0   20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
20  20  30  30  40  40  30  30  20  20
20  30  30  40  50  50  40  30  30  20
30  40  50  50  50  50  50  50  40  30


The above chart includes the seating chart for the show with the respective prices!

If the ticket price of a seat is 0, the seat is unavailable!

To begin booking your seat, Enter "S" for a specific seat or "P" for a seat based on price!
P

Please enter a price for a seat in the theater - 10,20,30,40,or 50
10

Seat Booked: Row 1, Column 1, 
Seat Price: $10




Do you want to buy more seats?

Please enter "Y" or "N"
N
_________________________________________________________________________________________________

Welcome to the Theater!

10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
20  20  30  30  40  40  30  30  20  20
20  30  30  40  50  50  40  30  30  20
30  40  50  50  50  50  50  50  40  30

The above chart includes the seating chart for the show with the respective prices!

If the ticket price of a seat is 0, the seat is unavailable!

To begin booking your seat, Enter "S" for a specific seat or "P" for a seat based on price!
S

Please enter a row for your seat in the theater!
1

Please enter a column for your seat in the theater!
3

Seat Booked: Row 1, Column 3, 
Seat Price: $10




Do you want to buy more seats?

Please enter "Y" or "N"
Y
10  10  0   10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
20  20  30  30  40  40  30  30  20  20
20  30  30  40  50  50  40  30  30  20
30  40  50  50  50  50  50  50  40  30

The above chart includes the seating chart for the show with the respective prices!

If the ticket price of a seat is 0, the seat is unavailable!

To begin booking your seat, Enter "S" for a specific seat or "P" for a seat based on price!
P

Please enter a price for a seat in the theater - 10,20,30,40,or 50
60

Invalid price to choose a seat. Valid price include 10,20,30,40, or 50
30

Seat Booked: Row 7, Column 3, 
Seat Price: $30




Do you want to buy more seats?

Please enter "Y" or "N"
p

Invalid response! Please enter either - Y or N
N  
_________________________________________________________________________________________________
10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
20  20  30  30  40  40  30  30  20  20
20  30  30  40  50  50  40  30  30  20
30  40  50  50  50  50  50  50  40  30


Welcome to the Theater!

The above chart includes the seating chart for the show with the respective prices!

If the ticket price of a seat is 0, the seat is unavailable!

To begin booking your seat, Enter "S" for a specific seat or "P" for a seat based on price!
S

Please enter a row for your seat in the theater!
15

Invalid Row. Theater has 9 rows in total. Valid row number are from 1 to 9
3

Please enter a column for your seat in the theater!
4

Seat Booked: Row 3, Column 4, 
Seat Price: $20




Do you want to buy more seats?

Please enter "Y" or "N"
Y
10  10  10  10  10  10  10  10  10  10
10  10  10  10  10  10  10  10  10  10
10  10  10  0   10  10  10  10  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
10  10  20  20  20  20  20  20  10  10
20  20  30  30  40  40  30  30  20  20
20  30  30  40  50  50  40  30  30  20
30  40  50  50  50  50  50  50  40  30


Welcome to the Theater!

The above chart includes the seating chart for the show with the respective prices!

If the ticket price of a seat is 0, the seat is unavailable!

To begin booking your seat, Enter "S" for a specific seat or "P" for a seat based on price!
P

Please enter a price for a seat in the theater - 10,20,30,40,or 50
-40

Invalid price to choose a seat. Valid price include 10,20,30,40, or 50
10

Seat Booked: Row 1, Column 1, 
Seat Price: $10




Do you want to buy more seats?

Please enter "Y" or "N"
N
*/


  

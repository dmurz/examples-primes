public class PrintPrimes {

  int numberOfPrimes;   
  int numberOfRows;     
  int numberOfColumns;  
  int ordMax;
  int listOfPrimes[];   

  //Constructor
  public PrintPrimes(int numberOfPrimes, int numberOfRows, int numberOfColumns, int ordMax) {

    this.numberOfPrimes   = numberOfPrimes;
    this.numberOfRows  = numberOfRows;
    this.numberOfColumns  = numberOfColumns;
    this.ordMax = ordMax;
    this.listOfPrimes = new int[numberOfPrimes + 1];

  }

  //Main method
  public static void main (String[] args) {

      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 30);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();

  }

  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  //Helper function for calculatePrimes(), populates listOfPrimes[] with odd prime numbers
  private void calculateOddPrimes() {
      
      boolean isPrime; 
      int n;
      int multiples[] = new int[ordMax + 1];
      int currentNumber = 1;
      int ord = 2;
      int square = 9;

      for (int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        
        do { //Better to use a while loop instead of do-while but the output is incorrect if changed
          currentNumber = currentNumber + 2;

          if (currentNumber == square) {
            ord = ord + 1;
            square = listOfPrimes[ord] * listOfPrimes[ord];
            multiples[ord - 1] = currentNumber;
          }

          n = 2;
          isPrime = true;
          while (n < ord && isPrime) {

            while (multiples[n] < currentNumber) {
              multiples[n] = multiples[n] + listOfPrimes[n] + listOfPrimes[n];
            }

            if (multiples[n] == currentNumber) {
              isPrime = false;
            }

            n = n + 1;
          }
        } while (!isPrime);

        listOfPrimes[primesFoundSoFar] = currentNumber;

      }
    }

    //Helper function that handles output to STDOUT
    public void printPrimes() {
        
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= numberOfPrimes) {

          System.out.println("The First " + numberOfPrimes +
                              " Prime numbers --- Page " + pageNumber);
          System.out.println("");
          setOutputFormat(pageOffset);
          System.out.println("\f");

          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + numberOfRows * numberOfColumns;

        }
    }

    //Helper function that sets the appropriate output format for a passed pageOffset
    public void setOutputFormat(int pageOffset) {
      
      for (int rowOffset = pageOffset; rowOffset < pageOffset + numberOfRows; rowOffset++) {
        
        for (int columnCounter = 0; columnCounter < numberOfColumns; columnCounter++) {
          if (rowOffset + columnCounter * numberOfRows <= numberOfPrimes) {
            System.out.format("%10d", listOfPrimes[rowOffset + columnCounter * numberOfRows]);
          }
        }

        System.out.println("");
      }
    }
}

					 

					 
	 

					 

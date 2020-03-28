package homework13.io;

import java.util.Scanner;

public class ConsoleX implements Console {

  private final Scanner sc;

  public ConsoleX(Scanner sc) {
    this.sc = sc;
  }

  @Override
  public String readLn() {
    return sc.nextLine();
  }

  @Override
  public void print(String line) {
    System.out.print(line);
  }

  @Override
  public void close() {
    sc.close();
  }
}

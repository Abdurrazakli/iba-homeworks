package homework13.io;

public interface Console {
  String readLn();

  void print(String line);
  default void printLn(String line) {
    print(line);
    printLn();
  }
  default void printLn() {
    print("\n");
  }
  void close();
}
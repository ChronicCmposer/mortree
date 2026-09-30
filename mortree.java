import java.util.ArrayList;

public class mortree {


   public static void main(String[] args) {

      Tree wideTree = christmasTree(8).concatenateHorizontal(christmasTree(8).concatenateHorizontal(christmasTree(8).concatenateHorizontal(christmasTree(8))));
      wideTree.printTree();
      wideTree = christmasTree(6).concatenateHorizontal(christmasTree(6).concatenateHorizontal(christmasTree(6).concatenateHorizontal(christmasTree(6))));
      wideTree.printTree();
      wideTree = christmasTree(4).concatenateHorizontal(christmasTree(4).concatenateHorizontal(christmasTree(4).concatenateHorizontal(christmasTree(4))));
      wideTree.printTree();
      wideTree = christmasTree(10).concatenateHorizontal(christmasTree(10).concatenateHorizontal(christmasTree(10).concatenateHorizontal(christmasTree(10))));
      wideTree.printTree();

   }

   private static Tree christmasTree(int height) {
      ArrayList<String> lines = new ArrayList<>();
      // print big triangle
      lines.addAll(collectBigTriangle(height));

      // center the base and print the base
      StringBuilder baseLayer = new StringBuilder();
      baseLayer.append(collectCharacterString(' ', height - 2));
      baseLayer.append(collectCharacterString('*', 3));
      baseLayer.append(collectCharacterString(' ', height - 2));

      lines.add(baseLayer.toString());
      baseLayer = new StringBuilder();

      baseLayer.append(collectCharacterString(' ', height - 2));
      baseLayer.append(collectCharacterString('*', 3));
      baseLayer.append(collectCharacterString(' ', height - 2));

      lines.add(baseLayer.toString());

      Tree tree = new Tree(lines);
      return tree;
   }

   private static ArrayList<String> collectBigTriangle(int size) {
      ArrayList<String> bigTriangle = new ArrayList<>();
      for (int row = 0; row < size; row++) {
         StringBuilder triangleLayer = new StringBuilder();
         triangleLayer.append(collectCharacterString(' ', size - row - 1));
         triangleLayer.append(collectCharacterString('*', row + 1));
         triangleLayer.append(collectCharacterString('*', row)); // ?
         triangleLayer.append(collectCharacterString(' ', size - row - 1));
         bigTriangle.add(triangleLayer.toString());
      }
      return bigTriangle;
   }

   private static String collectCharacterString(char character, int number) {
      StringBuilder builder = new StringBuilder();
      for(int i = 0; i < number; i++) {
         builder.append(character);
      }
      return builder.toString();
   }

   // private static void printTriangle(int size) {
   //    for (int row = 0; row < size; row++) {
   //       printSpaces(size - row - 1);
   //       printStars(row + 1);
   //       System.out.print('\n');
   //    }
   // }

   // private static void printSpaces(int number) {
   //    printCharacter(' ', number);
   // }
   //
   // private static void printStars(int number) {
   //    printCharacter('*', number);
   // }
   //
   // private static void printCharacter(char character, int number) {
   //    for(int i = 0; i < number; i++) {
   //       System.out.print(character);
   //    }
   // }

}

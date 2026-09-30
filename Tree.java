import java.util.ArrayList;

public class Tree {
   ArrayList<String> lines;

   public Tree(ArrayList<String> lines) {
      this.lines = lines;
   }

   public Tree concatenateHorizontal(Tree other) {
      if (this.lines.size() != other.lines.size()) {
         throw new RuntimeException("can't concatenate tree, trees have different num lines");
      }

      ArrayList<String> concatenatedLines = new ArrayList<>();

      for (int i = 0; i < this.lines.size(); i++) {
         StringBuilder builder = new StringBuilder();
         builder.append(this.lines.get(i));
         builder.append(other.lines.get(i));
         concatenatedLines.add(builder.toString());
      }

      return new Tree(concatenatedLines);
   }

   public void printTree() {
      for (String line : lines) {
         System.out.println(line);
      }
   }
}

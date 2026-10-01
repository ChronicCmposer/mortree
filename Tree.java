import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Tree {
   List<String> lines;

   public Tree(ArrayList<String> lines) {
      this.lines = lines;
   }

   public void setHeightTo(int newHeight) {
      int currentHeight = this.lines.size();
      if (newHeight <= currentHeight) {
         throw new RuntimeException(String.format("can't make tree of height %d -> %d", currentHeight, newHeight));
      }

      // we know now that newHeight > currentHeight: newHeight - currentHeight >= 1

      int numLinesToPrepend = newHeight - currentHeight;
      int lineWidth = this.lines.getFirst().length();

      ArrayList<String> prependLines = new ArrayList<>();

      for (int i = 0; i < numLinesToPrepend; i++) {
         prependLines.add(mortree.collectCharacterString(' ', lineWidth));
      }

      // this.lines = List.of(...prependLines this.lines);
      this.lines = Stream.of(prependLines, this.lines)
                           .flatMap(List::stream)
                           .toList();
   }

   public Tree concatenateHorizontal(Tree other) {


      Tree a = this;
      Tree b = other;

      int heightOfA = a.lines.size();
      int heightOfB = b.lines.size();

      boolean heightDifference = heightOfA != heightOfB;

      if (heightDifference) {
         // correct the height difference
         Tree tallerTree = (heightOfA > heightOfB) ? a : b;
         Tree shorterTree = (heightOfA < heightOfB) ? a : b;

         shorterTree.setHeightTo(tallerTree.lines.size());
      }

      // from this point, both trees have the same height

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

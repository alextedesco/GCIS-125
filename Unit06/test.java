import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class test {

    public static void aMethod() throws IOException {
        // code that may throw an unchecked exception
      }
      
      public static void bMethod() {
          aMethod();
      }

    public static void main(String[] args) {
        Set<Integer> mySet = new TreeSet<>(Arrays.asList(0,4,3,5,1,2));
        Iterator<Integer> iter = mySet.iterator();
        while (iter.hasNext()) {
           System.out.print(iter.next());
            }
        }
    }
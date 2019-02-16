import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TreeNodeTest {

   Tree tree = new Tree();
   Node node = new Node("a", "apple", null, null);
   Node left = new Node("b", "banana", null, null); 
   Node right = new Node("c", "carrot", null, null);     
   
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() 
   {
   }

   @Test 
   public void getKeyTest() 
   {
      Assert.assertEquals("a", node.getKey());
   }
   
   @Test
   public void getDataTest()
   {
      Assert.assertEquals("apple", node.getData());
   }
   
   @Test
   public void getLeftTest()
   {
      Assert.assertEquals("b", left.getKey());
      Assert.assertEquals("banana", left.getData());
   }
   
   @Test
   public void getRightTest()
   {
      Assert.assertEquals("c", right.getKey());
      Assert.assertEquals("carrot", right.getData());
   }
   
   @Test
   public void writeTest()
   {
      tree.add(node.getKey(), node.getData());
      tree.add(left.getKey(), left.getData());
      tree.add(right.getKey(), right.getData());
      
      Assert.assertEquals("apple", tree.write("a"));
      Assert.assertEquals("banana", tree.write("b"));
      Assert.assertEquals("carrot", tree.write("c"));
      Assert.assertEquals("Not found", tree.write("d"));                 
   }
}

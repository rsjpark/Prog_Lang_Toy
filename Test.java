public class Test
{
  public static void main(String[] args)
  {
    Tokenizer tokenizer = new Tokenizer();
    tokenizer.add("=", 1);  //assignment: use token for assignment
    tokenizer.add("\\+|-", 2);    //exp: use token 
    tokenizer.add("\\*", 3);  //term
    tokenizer.add("\\(", 4); //fact
    tokenizer.add("\\)", 4);    //write a conditional somehow, use token
    tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 5);  //identifier
    tokenizer.add("[a-zA-Z_]", 6);   //Letter
    tokenizer.add("[0-9][1-9]", 7); // Literal
    tokenizer.add("[1-9]", 8); //nonzerodigit
    tokenizer.add("[0-9]", 9); //digit
    
    try
    {
      tokenizer.tokenize(" x = 1 y = 2 ---(x+y)*(x+-y) ");

      for (Tokenizer.Token token : tokenizer.getTokens())
      {
        System.out.println(token.sequence);
      }
    }
    catch (ParserException e)
    {
      System.out.println(e.getMessage());
    }

  }
}

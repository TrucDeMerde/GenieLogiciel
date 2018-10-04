package fr.ufrsciencestech.panier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Panier p = new Panier(15);
        
        View test = new View();
        
        Controller control = new Controller(p);
        
        p.addObserver(test);
        test.addController(control);
        test.setVisible(true);
    }
}

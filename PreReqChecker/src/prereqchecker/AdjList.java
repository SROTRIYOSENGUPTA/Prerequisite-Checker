package prereqchecker;
import java.util.ArrayList;

// Name: Srotriyo Sengupta RUID: 193008050 Email: ss3414@scarletmail.rutgers.edu
// this is the beginning of the program


/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList
{
    public static void main(String[] args)
    {

        if ( args.length < 2 )
        {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");

            return; // this will return
        }   
        String innn = args[0];

        digraph graph = new digraph(innn);

        int d = graph.getV();

        ArrayList<ArrayList<String>> AdjList = new ArrayList<ArrayList<String>>(d);

        AdjList = graph.getAdjList();

        String[] newCatalog = graph.getCourseCatalog();

        StdOut.setFile(args[1]);
        
        for(int f = 0; f < d; f+=1)
        {
            String course = newCatalog[f];

            ArrayList<String> preReq = AdjList.get(f);

            StdOut.print(course + " ");
            
            if (preReq.size() != 0)
            {
                for(int g = 0; g < preReq.size(); g++) 

                {

                    StdOut.print(preReq.get(g) + " ");

                }

            }

            StdOut.println(); 
        }
    }
}

// java -cp bin prereqchecker.AdjList adjlist.in adjlist.out
// this is the end of the program
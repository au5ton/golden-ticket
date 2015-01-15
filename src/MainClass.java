import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class MainClass
{
    public static void main(String[] args)
    {
        for(;;)
        {
            String command = JOptionPane.showInputDialog("Command:");

            if(command.startsWith("##"))
            {
                System.exit(0);
            }

            Process p = null;
            try {
                p = Runtime.getRuntime().exec(command.split(" "));
            } catch (IOException e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                JOptionPane.showMessageDialog(null,sw.toString(), "golden ticket", JOptionPane.ERROR_MESSAGE);
            }
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                JOptionPane.showMessageDialog(null,sw.toString(), "golden ticket", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class MainClass
{
    public static String message = "";
    public static String program;
    public static boolean flag = false;
    public static File f;
    public static JFileChooser fc = new JFileChooser();

    public static void main(String[] args) {

        while (!flag) {
            program = JOptionPane.showInputDialog(null, "Enter the path to what program to run:", "C:\\Windows\\System32\\cmd.exe");
            f = new File(program);
            if (f.exists()) {
                if (f.canExecute()) {
                    message += "Java says you CAN execute that file. Good.\n";
                } else {
                    message += "Java says you can't execute that file, but hey, let's try anyway.\n";
                }
                if (f.canRead()) {
                    message += "Java says you CAN read that file. Good.\n";
                } else {
                    message += "Java says you can't read this file, but hey, let's try anyway.\n";
                }
                message += ("The program you are trying to run:\n" + f.getAbsolutePath());
                flag = true;
            } else if (program.startsWith("###")) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "According to Java, that file doesn't exist! Please try again.\n");
            }
        }
        List<String> list = new ArrayList<String>();

        JOptionPane.showMessageDialog(null, "Here's what I know:\n" + message, "golden ticket", JOptionPane.INFORMATION_MESSAGE);

        for (; ; ) {
            String s = JOptionPane.showInputDialog(null, "Enter your next argument (type \"###\" to stop):", "");
            if (s.startsWith("###")) {
                break;
            } else {
                list.add(s);
            }
        }

        String[] baton = new String[list.size() + 1];
        baton[0] = program;
        for (int i = 0; i < list.size(); i++) {
            baton[i + 1] = list.get(i);
        }

        Process p = null;
        try {
            p = Runtime.getRuntime().exec(baton);
        } catch (IOException e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            JOptionPane.showMessageDialog(null, sw.toString(), "golden ticket", JOptionPane.ERROR_MESSAGE);
        }
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            JOptionPane.showMessageDialog(null, sw.toString(), "golden ticket", JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0);

    }
}

package mediabiblioteket;
import collections.ArrayList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

public class GUI_test {


    LibraryController controller;
    ArrayList<Borrower> borrowers = new ArrayList<Borrower>();
    GUI gui;


    @Test
    void loginAll() throws Exception {
        Robot rb = new Robot();
        Scanner theScanner = new Scanner(new File("C:\\Users\\bishe\\Downloads\\Mediabiblioteket-master\\Mediabiblioteket-master\\Mediabiblioteket\\UnitTest\\mediabiblioteket\\Lantagare.txt"));
        while (theScanner.hasNext()) {

            String theLine = theScanner.nextLine();
            String name = theLine.split(";")[0];
            System.out.println(name);
            new Thread() {
                public void run() {

                    rb.delay(2000);
                    for (char s : name.toCharArray()) {
                        rb.keyPress(KeyPress(s, rb));
                        rb.keyRelease(KeyPress(s, rb));
                    }
                    rb.delay(200);
                    rb.keyPress(KeyEvent.VK_ENTER);
                    rb.delay(200);
                    rb.keyRelease(KeyEvent.VK_ENTER);
                    rb.delay(200);
                    rb.mouseMove(1903,15);
                    rb.delay(200);
                    rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    rb.delay(200);
                    rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                    rb.delay(200);
                }
            }.start();
                gui = new GUI();
                controller = new LibraryController(gui);
            }
        }



        /*private static void pressKeys(Robot r,int[] ks,int delay){
        int length=len()
            for(int i=0; i
            r.keyPress(ks[i]);
            r.delay(10);
            r.keyRelease(ks[i]);
            r.delay(delay);
        }

    }*/

        public int KeyPress(char s, Robot r){
            if (s=='0'){
                return KeyEvent.VK_0;
            } else if(s=='1'){
                return KeyEvent.VK_1;
            } else if (s=='2'){
                return KeyEvent.VK_2;
            } else if (s=='3'){
                return KeyEvent.VK_3;
            } else if (s=='4'){
                return KeyEvent.VK_4;
            } else if (s=='5'){
                return KeyEvent.VK_5;
            } else if (s=='6'){
                return KeyEvent.VK_6;
            }else if (s=='7'){
                return KeyEvent.VK_7;
            } else if (s=='8'){
                return KeyEvent.VK_8;
            } else if (s=='9'){
                return KeyEvent.VK_9;
            } else {
                return KeyEvent.VK_MINUS;
            }
        }

}

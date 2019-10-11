import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class lrunner {
    runner head =  null;
    class runner {
         String name;


        // marathon == 1 if great delhi run;
        // marathon == 2 if half marathon;
        // marathon == 3 if open 10k run;

         int marathon;
         int time;
        runner next;

        public runner(String name, boolean great, boolean half,int time)


        {
            this.time = time;
            this.name = name;
            if (great) {
                marathon = 1;
            }
            else if (half) {
                marathon = 2;
            }
            else {
                marathon = 3;
            }
        }
    }

    void push(String name, boolean great, boolean half,int time){
        runner new_node = new runner(name, great, half, time);
        new_node.next = head;
        head = new_node;
    }



    String[] ans1(runner head,int a){
        String S[]=new String[5];
        int ans= 999999;
        String sol;
        runner temp = head;
        S[0] = "participant not there hence no one is elligible for";
        S[1] = "participant not there hence no one is elligible for";
        if(head == null){
            return S;
        }

        while(temp!=null){
            if(temp.time < ans && temp.marathon ==a){
            ans = temp.time;
            S[0] = temp.name;

            }
            temp=temp.next;
        }

        if(head.next == null){
            return S;
        }
        int ans2 = 99999999;
        temp = head;
        while(temp != null){
            if(temp.time < ans2 &&  temp.time>ans && temp.marathon == a){
                ans2 = temp.time;
                S[1] = temp.name;
            }
            temp = temp.next;
        }
        return S;
    }

}



public class try1 {
       public static JPanel P_name;
       public static JLabel l_name;
       public static JTextField tf_name;


       public static void main(String[] args){
           lrunner li = new lrunner();

           JFrame frame = new JFrame("marathon");


           JPanel p_main = new JPanel();
           p_main.setLayout(new BoxLayout(p_main,BoxLayout.Y_AXIS));
           ///////////////////////////////////////////////

           P_name = new JPanel();
           P_name.setLayout(new FlowLayout(FlowLayout.CENTER));

           p_main.add(P_name);

           l_name = new JLabel("NAME");
           tf_name = new JTextField();
           tf_name.setPreferredSize(new Dimension(260,50));
           P_name.add(l_name);
           P_name.add(tf_name);

           ////////////////////////////////////////////////
           JPanel p_time = new JPanel();
           p_time.setLayout(new FlowLayout(FlowLayout.CENTER));
           JLabel l_time =  new JLabel("TIME");
           p_time.add(l_time);

           JTextField tf_time = new JTextField();
           tf_time.setPreferredSize(new Dimension(150,50));
           p_time.add(tf_time);
           p_main.add(p_time);


           ////////////////////////////////////////////////
           JPanel p_marathon = new JPanel();
           p_marathon.setLayout(new FlowLayout(FlowLayout.CENTER));
           JLabel l_marathon =  new JLabel("marathons:- ");
           p_marathon.add(l_marathon);

           p_main.add(p_marathon);

           ButtonGroup bg_joined = new ButtonGroup();
           JRadioButton rb_half = new JRadioButton("Open 10k run");
           JRadioButton rb_open = new JRadioButton("Half Marathon");
           JRadioButton rb_great = new JRadioButton("Great Delhi Run");
           bg_joined.add(rb_great);
           bg_joined.add(rb_half);
           bg_joined.add(rb_open);
           p_marathon.add(rb_great);
           p_marathon.add(rb_half);
           p_marathon.add(rb_open);

           ///////////////////////////////////////////////////
           JPanel p_result = new JPanel();
           p_result.setLayout(new FlowLayout(FlowLayout.CENTER));
           JLabel l_result =  new JLabel("RESULTS ");
           Font f = l_result.getFont();
           l_result.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
           p_result.add(l_result);

           p_main.add(p_result);
           ///////////////////////////////////////////////////

           JPanel p_gmessage = new JPanel();
           p_gmessage.setLayout(new FlowLayout(FlowLayout.CENTER));

           JLabel l_gmessage = new JLabel("Great Delhi Run : ");
           JTextArea tf_gmessage = new JTextArea();
           tf_gmessage.setPreferredSize(new Dimension(450,75));

           p_gmessage.add(l_gmessage);
           p_gmessage.add(tf_gmessage);

           p_main.add(p_gmessage);
           ///////////////////////////////////////////////////

           JPanel p_omessage = new JPanel();
           p_omessage.setLayout(new FlowLayout(FlowLayout.CENTER));

           JLabel l_omessage = new JLabel("Half marathon : ");
           JTextArea tf_omessage = new JTextArea();
           tf_omessage.setPreferredSize(new Dimension(450,75));

           p_omessage.add(l_omessage);
           p_omessage.add(tf_omessage);

           p_main.add(p_omessage);


           ////////////////////////////////////////////////////

           JPanel p_hmessage = new JPanel();
           p_hmessage.setLayout(new FlowLayout(FlowLayout.CENTER));

           JLabel l_hmessage = new JLabel("Open 10K Run : ");
           JTextArea tf_hmessage = new JTextArea();
           tf_hmessage.setPreferredSize(new Dimension(450,75));

           p_hmessage.add(l_hmessage);
           p_hmessage.add(tf_hmessage);

           p_main.add(p_hmessage);


           ////////////////////////////////////////////////////

           JPanel p_buttons = new JPanel();
           p_buttons.setLayout(new FlowLayout(FlowLayout.CENTER));

           JButton b_next = new JButton(" save and Next ");
           JButton b_result = new JButton(" show winner");
           JButton b_cancel = new JButton(" cancel ");

           p_buttons.add(b_next);
           p_buttons.add(b_result);
           p_buttons.add(b_cancel);
           p_main.add(p_buttons);

            ///////////////////////////////////////////////////

           b_next.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   String n  = tf_name.getText();
                   boolean great = rb_great.isSelected();
                   boolean half = rb_half.isSelected();
                   int time =Integer.parseInt( tf_time.getText());

                   li.push(n, great, half, time);

                   tf_name.setText("");
                   tf_time.setText("");

               }

           });

           ////////////////////////////////////////////////////

           b_result.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {


                   tf_gmessage .setText(" first "+ li.ans1(li.head, 1)[0] +" Rs 1,35,000/-" +"\n\n" + " second "+li.ans1(li.head,1)[1] +" Rs.1,15,000/-");
                   tf_omessage .setText(" first "+ li.ans1(li.head,3)[0] +" Rs 1,90,000/-" + "\n\n" + " second "+li.ans1(li.head,3)[1] +" Rs.1,50,000/-");
                   tf_hmessage .setText(" first "+ li.ans1(li.head,2)[0] +" Rs 2,80,000/-" + "\n\n" + " second "+li.ans1(li.head,2)[1] +" Rs.2,10,000/-");

               }
           });
           ////////////////////////////////////////////////////

           b_cancel.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.exit(0);
               }
           });




           frame.add(p_main);
           frame.setSize(600,600);
           frame.setVisible(true);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


           ////////////////////////////////////

       }
}

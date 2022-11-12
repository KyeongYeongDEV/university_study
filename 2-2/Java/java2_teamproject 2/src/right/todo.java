package right;
import com.mysql.jdbc.Connection;
import javax.swing.*;
import java.awt.*;
import main.*;

public class todo {
    //오른쪽-할일목록 보기
    public static void setTodo(){
        CalendarSwing.east_pane.removeAll();

        JLabel east_l = new JLabel();
        CalendarSwing.east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 0 , 220));
        CalendarSwing.east_pane.setBackground(Color.cyan);

        //할일 보기 제목 및 프레임 크기설정
        JLabel todo_label = new JLabel("이 날의 할일");
        todo_label.setHorizontalAlignment(SwingConstants.CENTER);
        todo_label.setFont(new Font("Dialog",Font.BOLD,20));
        todo_label.setBorder(BorderFactory.createEmptyBorder(50 , 0, 50 , 0));
        CalendarSwing.east_pane.add(todo_label);

        //쭉 추가로 나열하는 반복문(벡터값만큼만 반복)
        for(int i=0;i< CalendarSwing.todo_v.size();i++){
            JLabel l = new JLabel((i+1) + CalendarSwing.todo_v.get(i));
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            CalendarSwing.east_pane.add(l);
        }
        JPanel p =new JPanel(new FlowLayout());
        p.setBackground(Color.cyan);


        CalendarSwing.change.setPreferredSize(new Dimension(80,30));
        p.add(CalendarSwing.change);//할일 목록 수정 페이지로 전환
        CalendarSwing.east_pane.add(p);
    }

    //오른쪽-할일 목록 수정
    public static void changeTodo(){
        CalendarSwing.east_pane.removeAll();
        CalendarSwing.east_pane.setSize(100,100);
        JLabel east_l = new JLabel();
        CalendarSwing.east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 15 , 210));
        //할일 수정 제목 및 프레임 크기 설정
        JLabel todo_label = new JLabel("이 날의 할일");
        todo_label.setHorizontalAlignment(SwingConstants.CENTER);
        todo_label.setFont(new Font("Dialog",Font.BOLD,20));
        todo_label.setBorder(BorderFactory.createEmptyBorder(50 , 0, 50 , 0));
        CalendarSwing.east_pane.add(todo_label);

        //벡터크기만큼 텍스트필드로 받아서 나열 (수정때문에 할일 보기 목록에있는걸 그대로 받아옴)
        for(int i=0;i<CalendarSwing.todo_v.size();i++){
            JPanel p = new JPanel(new FlowLayout());
            JLabel l = new JLabel((i+1)+". ");
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            p.add(l);
            CalendarSwing.change_list[i] = new JTextField(CalendarSwing.todo_v.get(i),8);
            CalendarSwing.change_list[i].setFont(new Font("Dialog",Font.PLAIN,15));
            p.add(CalendarSwing.change_list[i]);
            CalendarSwing.east_pane.add(p);
            p.setBackground(Color.cyan);
        }

        //추가버튼 누르면 빈 텍스트필드를 추가하고 화면 새로고침함
        for(int i=0;i<CalendarSwing.todoAdd_count;i++){
            JPanel p = new JPanel(new FlowLayout());
            JLabel l = new JLabel((i+CalendarSwing.todo_v.size()+1)+". ");
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            p.add(l);
            CalendarSwing.change_list[i+CalendarSwing.todo_v.size()] = new JTextField(8);
            CalendarSwing.change_list[i+CalendarSwing.todo_v.size()].setFont(new Font("Dialog",Font.PLAIN,15));
            p.add(CalendarSwing.change_list[i+CalendarSwing.todo_v.size()]);
            CalendarSwing.east_pane.add(p);
            p.setBackground(Color.cyan);
        }
        JPanel p =new JPanel(new FlowLayout());
        p.setBackground(Color.cyan);


        CalendarSwing.change_add.setPreferredSize(new Dimension(60,30));

        p.add(CalendarSwing.change_add); //할일 추가버튼

        CalendarSwing.change_complet.setPreferredSize(new Dimension(60,30));

        p.add(CalendarSwing.change_complet);//할일 수정 버튼

        CalendarSwing.change_cancel.setPreferredSize(new Dimension(60,30));

        p.add(CalendarSwing.change_cancel);//할일 수정 취소 버튼
        CalendarSwing.east_pane.add(p);
    }
}

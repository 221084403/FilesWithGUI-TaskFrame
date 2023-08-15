/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import za.ac.tut.tasks.Tasks;

/**
 *
 * @author MNCEDISI
 */
public class TaskFrame extends JFrame
{
    //panel
    private JPanel firstContainerPNL;
    private JPanel modulePNL;
    private JPanel descriptionPNL;
    private JPanel timePNL;
    private JPanel gridContainerPNL;
    
    private JPanel secondContainerPNL;
    private JPanel areaPNL;
    
    private JPanel thirdContainerPNL;
    private JPanel buttonPNL;
    
    private JPanel mainPNL;
    
    //label
    private JLabel moduleLBL;
    private JLabel descriptionLBL;
    private JLabel timeLBL;
    
    //text field
    private JTextField moduleTxtFLD;
    private JTextField descriptionTxtFLD;
    
    //Combo box
    private JComboBox timeCMB;
    
    //text area
    private JTextArea areaTxt;
    
    //scrollpane
    private JScrollPane scrollTxtArea;
    
    //button
    private JButton addTaskBTN;
    private JButton saveTaskBTN;
    private JButton exitBTN;
    
    //jmenu bar
    private JMenuBar menuBar;
    
    //jmenu 
    private JMenu fileMenu;
    private JMenu editMenu;
    
    //jmenu item
    private JMenuItem recentlyAddTaskJMI;
    private JMenuItem progressTaskJMI;
    private JMenuItem clearTaskJMI;
    
    private JMenuItem getAllTaskJMI;
    private JMenuItem modifyTaskJMI;
    
    //arrayList to store tasks
    private ArrayList<Tasks> theTasks;
    private ArrayList<Tasks> tasksModify;
    
    //path
    private String path ;
    
    public TaskFrame()
    {
        setTitle("To Do List");
        setSize(430, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //ceating a list of tasks
        theTasks = new ArrayList<>();
        tasksModify = new ArrayList<>();
        
        //initiallings
        path = "";
        
        //creating panel
        firstContainerPNL = new JPanel(new BorderLayout());
        gridContainerPNL = new JPanel(new GridLayout(3, 1 , 1, 1));
        modulePNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descriptionPNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        timePNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        secondContainerPNL = new JPanel(new BorderLayout());
        areaPNL = new JPanel(new BorderLayout());
        areaPNL.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 1), "Tasks"));
        
        thirdContainerPNL = new JPanel(new BorderLayout());
        buttonPNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainPNL = new JPanel(new BorderLayout());
        
        //creating label
        moduleLBL = new JLabel("Module :");
        descriptionLBL = new JLabel("Enter description of a tasks :");
        timeLBL = new JLabel("Time needed to finish a tasks :");
        
        //creating text field
        moduleTxtFLD = new JTextField(10);
        descriptionTxtFLD = new JTextField(20);
        
        //string array of object
        String time [] ={"---Please select---","30 minutes" , "45 minutes" , "1 hour" , "2 hours"}; 
        
        //creating combo box
        timeCMB = new JComboBox(time);
        
        //creating text area
        areaTxt = new JTextArea(5 , 3);
        
        //creating scrollpane
        scrollTxtArea = new JScrollPane(areaTxt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //creating button
        addTaskBTN = new JButton("Add Task");
        addTaskBTN.addActionListener(new AddTaskListenerBTN());
        
        saveTaskBTN = new JButton("Save");
        saveTaskBTN.addActionListener(new SavaTaskListenerBTN());
        
        exitBTN = new JButton("Exit");
        exitBTN.addActionListener(new ExitTaskListenerBTN());
        
        //creating jmenu bar
        menuBar = new JMenuBar();
        
        //creating jmenu
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        
        //creating jmenu item
        recentlyAddTaskJMI = new JMenuItem("Recently Add Tasks");
        recentlyAddTaskJMI.addActionListener(new RecentlyAddTaskListenerJMI());
        
        progressTaskJMI  = new JMenuItem("Progress on Tasks");
        
        clearTaskJMI  = new JMenuItem("Clear");
        clearTaskJMI.addActionListener(new ClearTaskListenerJMI());
        
        getAllTaskJMI = new JMenuItem("Get All Tasks");
        getAllTaskJMI.addActionListener(new GetAllTaskListenerJMI());
        
        modifyTaskJMI = new JMenuItem("Modify Tasks");
        modifyTaskJMI.addActionListener(new ModifyTasksListenerJMI());
        
        //adding components
        fileMenu.add(recentlyAddTaskJMI);
        fileMenu.add(progressTaskJMI);
        fileMenu.addSeparator();
        fileMenu.add(clearTaskJMI);
        
        editMenu.add(getAllTaskJMI);
        editMenu.add(modifyTaskJMI);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        modulePNL.add(moduleLBL);
        modulePNL.add(moduleTxtFLD);
        
        descriptionPNL.add(descriptionLBL);
        descriptionPNL.add(descriptionTxtFLD);
        
        timePNL.add(timeLBL);
        timePNL.add(timeCMB);
        
        gridContainerPNL.add(modulePNL);
        gridContainerPNL.add(descriptionPNL);
        gridContainerPNL.add(timePNL);
        
        firstContainerPNL.add(gridContainerPNL);
        
        areaPNL.add(scrollTxtArea);
        secondContainerPNL.add(areaPNL);
        
        buttonPNL.add(addTaskBTN);
        buttonPNL.add(saveTaskBTN);
        buttonPNL.add(exitBTN);
        
        thirdContainerPNL.add(buttonPNL);
        
        mainPNL.add(firstContainerPNL , BorderLayout.NORTH);
        mainPNL.add(secondContainerPNL , BorderLayout.CENTER);
        mainPNL.add(thirdContainerPNL , BorderLayout.SOUTH);
        
        //set bar menu to frame
        setJMenuBar(menuBar);
        
        //add main panel into a frame
        add(mainPNL);
        
        //set frame visible
        setVisible(true);
    } 

    private class ModifyTasksListenerJMI implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String error = "";
            
            try
            {
                readOldTaskFile(path);
                JOptionPane.showMessageDialog(TaskFrame.this, "Modified succesfully!", "Outcome",JOptionPane.PLAIN_MESSAGE);
            } 
            
            catch (IOException ex) 
            {
                error ="Something went wrong\n"+ex.getMessage();
                JOptionPane.showMessageDialog(TaskFrame.this, error ,"Error" , JOptionPane.ERROR_MESSAGE);
            }
            
        }

        private void readOldTaskFile(String path) throws FileNotFoundException, IOException 
        {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            while(line != null)
            {
                String data [] = line.split(",");
                String module = data[0];
                String description = data[1];
                String time = data[2];
                
                Tasks tasks = new Tasks(module, description, time);
                
                tasksModify.add(tasks);
                
                line = br.readLine();
            }
            
            modifyTaskFile(tasksModify);
            
            writeModiferedFile(path , tasksModify);
        }

        private void modifyTaskFile(ArrayList<Tasks> tasksModify)
        {
            String module = moduleTxtFLD.getText();
            String description = descriptionTxtFLD.getText();
            String time = String.valueOf(timeCMB.getSelectedItem());
            
            for (Tasks display : tasksModify) 
            {
                if(display.getModule().equalsIgnoreCase(module))
                {
                    int index = tasksModify.indexOf(display);
                    Tasks tasks = new Tasks(module, description, time);
                    
                    tasksModify.set(index, tasks); 
                }
            }
        }

        private void writeModiferedFile(String path, ArrayList<Tasks> tasksModify) throws IOException 
        {
            String outcome = "";
            
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Tasks display : tasksModify) 
                outcome+=display.toString()+"\n";
            
            bw.write(outcome);
            
            bw.close();
        }
    }

    private class GetAllTaskListenerJMI implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JFileChooser jfc = new JFileChooser();
            String error = "" , outcome = "";
            
            int value = jfc.showOpenDialog(TaskFrame.this);
            
            if(value == JFileChooser.APPROVE_OPTION)
            {
                File file = jfc.getSelectedFile();
                
                path = file.getPath();
                
                try
                {   
                    
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);

                    String line = br.readLine();

                    while(line !=null)
                    {
                        outcome+=line+"\n";
                        line = br.readLine();
                    }

                    areaTxt.setText(outcome);
                } 

                catch (FileNotFoundException ex)
                {
                    error = "File not found";
                    JOptionPane.showMessageDialog(TaskFrame.this, error , "Error" , JOptionPane.ERROR_MESSAGE);
                } 

                catch (IOException ex) 
                {
                    error = "Something went wrong\n"+ex.getMessage();
                    JOptionPane.showMessageDialog(TaskFrame.this, error , "Error" , JOptionPane.ERROR_MESSAGE);                
                }
            }
            
            else
            {
                error = "The if statement failed. The return value is "+value;
                JOptionPane.showMessageDialog(TaskFrame.this, error , "Error" ,JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ClearTaskListenerJMI implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            moduleTxtFLD.setText(null);
            descriptionTxtFLD.setText(null);
            timeCMB.setSelectedIndex(0); 
            areaTxt.setText(null);
        }
    }

    private class RecentlyAddTaskListenerJMI implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String outcome = "";
            
            for (Tasks display : theTasks) 
            {
                outcome+="Module      :"+display.getModule()+"\n"+
                         "Description :"+display.getDescription()+"\n"+
                         "Time        :"+display.getTime()+"\n\n";
 
            }
            
            areaTxt.setText(outcome);
        }
        
    }

    private class ExitTaskListenerBTN implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    }

    private class SavaTaskListenerBTN implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JFileChooser jfc = new JFileChooser();
            String error = "" ,outcome = "";
            
            int value = jfc.showSaveDialog(TaskFrame.this);
            
            if(value == JFileChooser.APPROVE_OPTION)
            {
                File file = jfc.getSelectedFile();
                
                path = file.getPath();
                
                try
                {
                    FileWriter fw = new FileWriter(file  , true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    for (Tasks display : theTasks) 
                        outcome+=display.toString()+"\n";
                    
                    bw.write(outcome);
                    
                    bw.close();
                    
                    outcome = "Tasks save";
                    
                    JOptionPane.showMessageDialog(TaskFrame.this,outcome ,"Outcome" , JOptionPane.PLAIN_MESSAGE);
                } 
                
                catch (IOException ex) 
                {
                    error  ="Something went wrong\n"+ex.getMessage();
                    JOptionPane.showMessageDialog(TaskFrame.this, error , "Error" ,JOptionPane.ERROR_MESSAGE);
                }
            }
            
            else
            {
                error = "The if statement failed. The return value is "+value;
                JOptionPane.showMessageDialog(TaskFrame.this, error , "Error" ,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    private class AddTaskListenerBTN implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            String module = moduleTxtFLD.getText();
            String description = descriptionTxtFLD.getText();
            String time = String.valueOf(timeCMB.getSelectedItem());
            
            Tasks tasks = new Tasks(module, description, time);
            
            theTasks.add(tasks);
             
            JOptionPane.showMessageDialog(TaskFrame.this, "Task is added" , "Outcome" , JOptionPane.PLAIN_MESSAGE);
        }
    }
}

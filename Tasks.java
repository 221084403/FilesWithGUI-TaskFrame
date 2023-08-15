/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.tasks;

/**
 *
 * @author MNCEDISI
 */
public class Tasks 
{
    private String module;
    private String description;
    private String time;

    public Tasks(String module, String description, String time) 
    {
        this.module = module;
        this.description = description;
        this.time = time;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() 
    {
        return getModule()+","+getDescription()+","+getTime();
    } 
}

package Task2.Controller;

import Task2.Model.TaskDAO;

import java.util.ArrayList;
import java.util.Hashtable;

public class Task {
    private Integer task_id;
    private String task_description;
    private Boolean is_completed;
    private static TaskDAO dao = new TaskDAO();
    public Task(String task_description, Boolean is_completed) {
        this.task_description = task_description;
        this.is_completed = is_completed;
    }

    public Task(Integer task_id, String task_description, Boolean is_completed) {
        this.task_id = task_id;
        this.task_description = task_description;
        this.is_completed = is_completed;
    }

    public Task() {
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public Boolean getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(Boolean is_completed) {
        this.is_completed = is_completed;
    }

    public boolean delete(Integer id){
        return dao.delete(id);
    }
    public boolean insert(){
        Hashtable<String,String> data = new Hashtable<>();
        data.put("task_description",task_description);
        if(is_completed)
            data.put("is_completed","1");
        else
            data.put("is_completed","0");
        return dao.insert(data);
    }
    public static ArrayList<Task> getTasks(){
        ArrayList<Hashtable<String,String>> data = dao.load();
        ArrayList<Task> tasks = new ArrayList<>();
        for(Hashtable<String,String> d : data){
            tasks.add(new Task(Integer.parseInt(d.get("task_id")),
                    d.get("task_description"),
                    Boolean.valueOf(d.get("is_completed")))
            );
        }

        return tasks;
    }
}

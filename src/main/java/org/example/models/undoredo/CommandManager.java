package org.example.models.undoredo;

import org.example.models.interfaces.Command;

import java.io.Serializable;
import java.util.Stack;

public class CommandManager implements Serializable {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();


    public void execute(Command cmd){
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();
    }

    public void undo(){
        if(!undoStack.isEmpty()){
            Command cmd = undoStack.pop();
            cmd.unExecute();
            redoStack.push(cmd);
        }
    }

    public void redo(){
        if(!redoStack.isEmpty()){
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        }
    }
}

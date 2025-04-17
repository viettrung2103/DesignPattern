package org.example;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        this.redoHistory.clear();
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        this.redoHistory.clear();
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            // save the current state to the redo history
            saveToRedoHistory();
            // apply the state from the history to current state
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
            gui.updateHistoryList();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");

            // save the current state to history
            saveToHistory();

            // the previous state is the state from the future ( get from redo history
            IMemento previousState = redoHistory.remove(redoHistory.size()-1);
            model.restoreState(previousState);
            gui.updateGui();
//            gui.updateHistoryList();
        }
    }

    public void selectHistory(IMemento memento) {
        // save the current state to history
        IMemento currentState = model.createMemento();
        history.add(currentState);
        // restore state to the selected state in history
        model.restoreState(memento);
        // remove the history from the history
        removeSelectedHistoryState(memento);
        //update gui
        gui.updateGui();
        gui.updateHistoryList();

    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
//        System.out.println(currentState);
        history.add(currentState);
//        redoHistory.clear();
        gui.updateHistoryList();
    }

    private void saveToRedoHistory() {
        IMemento currentState = model.createMemento();
        redoHistory.add(currentState);
        gui.updateHistoryList();
    }



    public List<IMemento> getHistory() {
        return history;
    }

    public List<IMemento> getRedoHistory() {
        return redoHistory;
    }

    private void removeSelectedHistoryState(IMemento memento){
        for(IMemento m : history){
            if(((Memento)m).equals(memento)){
                history.remove(m);
                return;
            }
        }
        for(IMemento m : redoHistory){
            if(((Memento)m).equals(memento)){
                redoHistory.remove(m);
                return;
            }
        }
    }
}

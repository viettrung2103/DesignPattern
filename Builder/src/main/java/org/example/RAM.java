package org.example;

public class RAM extends Component{
    private int size;
    public RAM(int size) {
        super(size + " GB RAM");
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }
}

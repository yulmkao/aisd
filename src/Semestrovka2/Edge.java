package Semestrovka2;

public class Edge {
    private int value;
    private int edgeStart;
    private int edgeEnd;

    public Edge(int value, int edgeStart, int edgeEnd) {
        this.value = value;
        this.edgeStart = edgeStart;
        this.edgeEnd = edgeEnd;
    }

    @Override
    public String toString() {
        return String.format("%d -- %d: длинна %d", edgeStart, edgeEnd,value);
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getEdgeStart() {
        return edgeStart;
    }

    public void setEdgeStart(int edgeStart) {
        this.edgeStart = edgeStart;
    }

    public int getEdgeEnd() {
        return edgeEnd;
    }

    public void setEdgeEnd(int edgeEnd) {
        this.edgeEnd = edgeEnd;
    }
}

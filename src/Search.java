import java.util.*;

public class Search<Vertex> {
    protected Set<Vertex> marked; // Set of visited vertices
    protected Map<Vertex, Vertex> edgeTo; // Map to track paths
    protected final Vertex source; // Source vertex for the search

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) {
            return null;
        }

        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            path.push(i);
        }

        path.push(source);
        return path;
    }
}
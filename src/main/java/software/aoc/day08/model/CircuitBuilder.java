package software.aoc.day08.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CircuitBuilder {

    public List<Edge> buildAllEdges(List<Point> points) {
        List<Edge> edges = new ArrayList<>();
        populateEdges(points, edges);
        edges.sort(Comparator.comparingLong(Edge::distanceSq));
        return edges;
    }

    private void populateEdges(List<Point> points, List<Edge> edges) {
        for (int i = 0; i < points.size(); i++)
            for (int j = i + 1; j < points.size(); j++)
                edges.add(new Edge(i, j, calculateDistanceSquared(points.get(i), points.get(j))));
    }

    private long calculateDistanceSquared(Point a, Point b) {
        long dx = a.x() - b.x(), dy = a.y() - b.y(), dz = a.z() - b.z();
        return dx*dx + dy*dy + dz*dz;
    }

    public List<Edge> calculateMST(List<Edge> edges, int n, int limit) {
        return constructMST(edges, limit, new UnionFind(n), new ArrayList<>());
    }

    private static List<Edge> constructMST(List<Edge> edges, int limit, UnionFind uf, List<Edge> mst) {
        for (int i = 0; i < edges.size(); i++) {
            uf.union(getEdge(edges, i).from(), getEdge(edges, i).to());
            mst.add(getEdge(edges, i));
            if (i == limit - 1) break;
        }
        return mst;
    }

    private static Edge getEdge(List<Edge> edges, int i) {
        return edges.get(i);
    }

    public int[] componentSizes(int n, List<Edge> edges) {
        UnionFind uf = new UnionFind(n);
        edges.forEach(e -> uf.union(e.from(), e.to()));
        return uf.sizes();
    }

    public long calculateTop3ComponentProduct(int[] sizes) {
        return Arrays.stream(sizes)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(1, (a,b) -> a*b);
    }

    public long lastEdgeProductX(List<Point> points, List<Edge> edges) {
        Long points1 = findLastConnectedEdgeProductX(points, edges, new UnionFind(points.size()));
        if (points1 != null) return points1;
        throw new IllegalStateException("No se logró unir todos los puntos");
    }

    private static Long findLastConnectedEdgeProductX(List<Point> points, List<Edge> edges, UnionFind uf) {
        for (Edge e : edges) {
            uf.union(e.from(), e.to());
            if (uf.subgraphs() == 1)
                return (long) points.get(e.from()).x() * points.get(e.to()).x();
        }
        return null;
    }

}

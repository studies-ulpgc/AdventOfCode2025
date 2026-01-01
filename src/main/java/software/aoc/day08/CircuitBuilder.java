package software.aoc.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CircuitBuilder {

    public List<Edge> buildAllEdges(List<Point> points) {
        List<Edge> edges = new ArrayList<>();
        get_edges(points, edges);
        edges.sort(Comparator.comparingLong(Edge::distanceSq));
        return edges;
    }

    private void get_edges(List<Point> points, List<Edge> edges) {
        for (int i = 0; i < points.size(); i++)
            for (int j = i + 1; j < points.size(); j++)
                edges.add(new Edge(i, j, distSq(points.get(i), points.get(j))));
    }

    private long distSq(Point a, Point b) {
        long dx = a.x() - b.x(), dy = a.y() - b.y(), dz = a.z() - b.z();
        return dx*dx + dy*dy + dz*dz;
    }

    public List<Edge> kruskal(List<Edge> edges, int n, int limit) {
        return get_mst(edges, limit, new UnionFind(n), new ArrayList<>());
    }

    private static List<Edge> get_mst(List<Edge> edges, int limit, UnionFind uf, List<Edge> mst) {
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

    public long top3Product(int[] sizes) {
        return Arrays.stream(sizes)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(1, (a,b) -> a*b);
    }

    public long lastEdgeProductX(List<Point> points, List<Edge> edges) {
        Long points1 = get_points(points, edges, new UnionFind(points.size()));
        if (points1 != null) return points1;
        throw new IllegalStateException("No se logró unir todos los puntos");
    }

    private static Long get_points(List<Point> points, List<Edge> edges, UnionFind uf) {
        for (Edge e : edges) {
            uf.union(e.from(), e.to());
            if (uf.subgraphs() == 1)
                return (long) points.get(e.from()).x() * points.get(e.to()).x();
        }
        return null;
    }

}

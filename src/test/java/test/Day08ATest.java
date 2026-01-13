package test;

import org.junit.Test;
import software.aoc.day08.model.CircuitBuilder;
import software.aoc.day08.model.Point;
import software.aoc.day08.model.PointFactory;
import software.aoc.input.OrdersLoader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day08ATest {

    private final CircuitBuilder builder =
            new CircuitBuilder();

    private final OrdersLoader loader =
            () -> """
                162,817,812
                57,618,57
                906,360,560
                592,479,940
                352,342,300
                466,668,158
                542,29,236
                431,825,988
                739,650,466
                52,470,668
                216,146,977
                819,987,18
                117,168,530
                805,96,715
                346,949,466
                970,615,88
                941,993,340
                862,61,35
                984,92,344
                425,690,689
                """;

    @Test
    public void given_example_should_compute_product_of_top_3_circuits() {
        List<Point> points = PointFactory.fromCSV(loader);
        var edges = builder.buildAllEdges(points);
        var mst = builder.calculateMST(edges, points.size(), 10);

        int[] sizes = builder.componentSizes(points.size(), mst);
        long result = builder.calculateTop3ComponentProduct(sizes);

        assertThat(result).isEqualTo(40);
    }
}

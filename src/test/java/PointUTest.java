import org.junit.Test;
import point.Point;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PointUTest {

    @Test
    public void distanceTo_shouldReturnZero_whenThePointsAreIdentical() throws Exception {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(0);
    }

    @Test
    public void distanceTo_shouldReturnPoint2Abscisse_whenPoint1IsOriginAndPoint2IsOnXAxis() throws Exception {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(10, 0);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(10);
    }

    @Test
    public void distanceTo_shouldReturnTheAbscisseDifference_whenBothPointsAreOnTheSameXAxis() throws Exception {
        Point point1 = new Point(5, 0);
        Point point2 = new Point(11, 0);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(6);
    }

    @Test
    public void distanceTo_shouldReturnSameValue_notMatterTheOrder() throws Exception {
        Point point1 = new Point(17, 0);
        Point point2 = new Point(2, 0);

        int distancePoint1ToPoint2 = point1.getDistanceTo(point2);
        int point2DistanceToPoint1 = point2.getDistanceTo(point1);

        assertThat(distancePoint1ToPoint2).isEqualTo(point2DistanceToPoint1);
    }

    @Test
    public void distanceTo_shouldReturnPoint2Ordinate_whenPoint1IsOriginAndPoint2IsOnYAxis() throws Exception {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(5);
    }

    @Test
    public void distanceTo_shouldReturnTheOrdinateDifference_whenBothPointsAreOnTheSameYAxis() throws Exception {
        Point point1 = new Point(0, 1);
        Point point2 = new Point(0, 9);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(8);
    }

    @Test
    public void distanceTo_shouldReturnTheOrdinateDifference_whenBothPointsAreOnTheSameYAxis_andTheOrderChanges() throws Exception {
        Point point1 = new Point(0, 9);
        Point point2 = new Point(0, 1);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(8);
    }

    @Test
    public void distanceTo_shouldReturnDistance_whenPoint1IsOrigin() throws Exception {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 4);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(5);
    }

    @Test
    public void distanceTo_shouldReturnDistance_whenPoint2IsOrigin() throws Exception {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(0, 0);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(5);
    }

    @Test
    public void distanceTo_shouldReturnDistance_whenBothPointsAreRandom() throws Exception {
        Point point1 = new Point(2, 3);
        Point point2 = new Point(15, 15);

        int distance = point1.getDistanceTo(point2);

        assertThat(distance).isEqualTo(13);
    }
}

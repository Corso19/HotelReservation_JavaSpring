package fts.intern.hotelmanager.utils;

public class GeoLocationUtils {

    private static final double KM_IN_ONE_DEGREE = 111.32;

    public static double[][] calculateSquareRange(double latitude, double longitude, double distanceInKm) {
        double distanceInDegrees = distanceInKm / KM_IN_ONE_DEGREE;

        double minLat = latitude - distanceInDegrees;
        double maxLat = latitude + distanceInDegrees;
        double minLong = longitude - distanceInDegrees;
        double maxLong = longitude + distanceInDegrees;

        return new double[][]{{minLat, minLong}, {maxLat, maxLong}};
    }
}

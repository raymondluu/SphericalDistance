/************************
* File Name: TCSS142Prog3
* Coder Name: Raymond Luu
* Assignment: 3
************************/
public class TCSS142Prog3
{
	public static final int MINUTES_PER_DEGREE = 60;
	public static final double RADIUS_OF_EARTH = 6373.795; // radius in kilometers
	public static final double MILES_PER_KILO = 1.609344; // 1 mile ~ 1.6 kilometer
	
	public static void main( String[] args )
	{
		//Nashville and Los Angeles
		double location1_latitude_degrees = 36;
		double location1_latitude_minutes = 7.2;
		double location1_longitude_degrees = 86;
		double location1_longitude_minutes = 40.2;
		double location2_latitude_degrees = 33;
		double location2_latitude_minutes = 56.4;
		double location2_longitude_degrees = 118;
		double location2_longitude_minutes = 24.0;
		
		System.out.println( sphericalDistance( location1_latitude_degrees,
															location1_latitude_minutes,
															location1_longitude_degrees,
															location1_longitude_minutes,
															location2_latitude_degrees,
															location2_latitude_minutes,
															location2_longitude_degrees,
															location2_longitude_minutes ) );
		// Sitka
		location1_latitude_degrees = 57;
		location1_latitude_minutes = 2.9;
		location1_longitude_degrees = 135;
		location1_longitude_minutes = 14;
		// Seattle
		location2_latitude_degrees = 47;
		location2_latitude_minutes = 36.4;
		location2_longitude_degrees = 122;
		location2_longitude_minutes = 19.9;
		System.out.println( sphericalDistance( location1_latitude_degrees,
															location1_latitude_minutes,
															location1_longitude_degrees,
															location1_longitude_minutes,
															location2_latitude_degrees,
															location2_latitude_minutes,
															location2_longitude_degrees,
															location2_longitude_minutes ) );
		// Atlanta
		location1_latitude_degrees = 33;
		location1_latitude_minutes = 45;
		location1_longitude_degrees = 84;
		location1_longitude_minutes = 23.25;
		// Birmingham
		location2_latitude_degrees = 33;
		location2_latitude_minutes = 33.75;
		location2_longitude_degrees = 86;
		location2_longitude_minutes = 45.3;
		System.out.println( sphericalDistance( location1_latitude_degrees,
															location1_latitude_minutes,
															location1_longitude_degrees,
															location1_longitude_minutes,
															location2_latitude_degrees,
															location2_latitude_minutes,
															location2_longitude_degrees,
															location2_longitude_minutes ) );
		// Honolulu
		location1_latitude_degrees = 21;
		location1_latitude_minutes = 18.4;
		location1_longitude_degrees = 157;
		location1_longitude_minutes = 51.5;
		// Seattle
		location2_latitude_degrees = 47;
		location2_latitude_minutes = 36.4;
		location2_longitude_degrees = 122;
		location2_longitude_minutes = 19.9;
		System.out.println( sphericalDistance( location1_latitude_degrees,
															location1_latitude_minutes,
															location1_longitude_degrees,
															location1_longitude_minutes,
															location2_latitude_degrees,
															location2_latitude_minutes,
															location2_longitude_degrees,
															location2_longitude_minutes ) );
	}
	
	public static double sphericalDistance( double location1_latitude_degrees,
														 double location1_latitude_minutes,
 														 double location1_longitude_degrees,
  														 double location1_longitude_minutes,
														 double location2_latitude_degrees,
														 double location2_latitude_minutes,
													 	 double location2_longitude_degrees,
														 double location2_longitude_minutes )
	{
		//Degrees + the Minutes being converted to Degrees
		double location1_LatitudeInDegrees = location1_latitude_degrees + location1_latitude_minutes / MINUTES_PER_DEGREE;
		double location1_LongitudeInDegrees = location1_longitude_degrees + location1_longitude_minutes / MINUTES_PER_DEGREE;
		double location2_LatitudeInDegrees = location2_latitude_degrees + location2_latitude_minutes / MINUTES_PER_DEGREE;
		double location2_LongitudeInDegrees = location2_longitude_degrees + location2_longitude_minutes / MINUTES_PER_DEGREE;
		//Degrees converted to Radians
		double location1_LatitudeToRadians = Math.toRadians(location1_LatitudeInDegrees);
		double location1_LongitudeToRadians = Math.toRadians(location1_LongitudeInDegrees);
		double location2_LatitudeToRadians = Math.toRadians(location2_LatitudeInDegrees);
		double location2_LongitudeToRadians = Math.toRadians(location2_LongitudeInDegrees);
		//longitudinal difference
		double longitudinalDifference = location1_LongitudeToRadians - location2_LongitudeToRadians;
		//angular distance equation
		double angularDistanceEquation = Math.acos(Math.sin(location1_LatitudeToRadians) * Math.sin(location2_LatitudeToRadians) + Math.cos(location1_LatitudeToRadians) * Math.cos(location2_LatitudeToRadians) * Math.cos(longitudinalDifference));
		//Multiplied by Radius of the Earth in Km
		double multipliedByKm = RADIUS_OF_EARTH * angularDistanceEquation;
		
		return multipliedByKm;
	}
}
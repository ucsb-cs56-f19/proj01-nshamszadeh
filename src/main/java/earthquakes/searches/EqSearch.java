package earthquakes.searches;
import java.lang.String;

public class EqSearch { 
  private int distance;
  private int minmag;
  private double lat;
  private double lon;
  private String location;

  public EqSearch(){}
  
  public int getDistance() {
    return distance;
  }

  public int getMinmag() {
    return minmag;
  }

  public double getLat() {
    return lat;
  }

  public double getLon() {
    return lon;
  }

  public String getLocation() {
    return location;
  }

  public void setDistance(int d) {
    distance = d;
  }

  public void setMinmag(int mm) {
    minmag = mm;
  }

  public void setLat(double l) {
    lat = l;
  }

  public void setLon(double l) {
    lon = l;
  }
  
  public void setLocation(String l) {
    location = l;
  }

}
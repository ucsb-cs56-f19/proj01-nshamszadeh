package earthquakes.osm;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

public class Place {
  private static Logger logger = LoggerFactory.getLogger(Place.class);

  public long place_id;
  public double lat;
  public double lon;
  public String display_name;
  public String type;

  public static List<Place> listFromJson(String json) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      List<Place> places = objectMapper.readValue(json, new TypeReference<List<Place>>(){});
      return places;
    } 
    catch (JsonProcessingException jpe) {
      logger.error("JsonProcessingException:" + jpe);
      return null;
    } 
    catch (Exception e) {
      logger.error("Exception:" + e);
      return null;
    }
  }
}

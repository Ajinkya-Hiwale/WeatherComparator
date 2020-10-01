
package pojoClasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lon",
    "lat"
})
public class Coord {

    @JsonProperty("lon")
    private Float lon;
    @JsonProperty("lat")
    private Float lat;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Coord() {
    }

    /**
     * 
     * @param lon
     * @param lat
     */
    public Coord(Float lon, Float lat) {
        super();
        this.lon = lon;
        this.lat = lat;
    }

    @JsonProperty("lon")
    public Float getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(Float lon) {
        this.lon = lon;
    }

    @JsonProperty("lat")
    public Float getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Float lat) {
        this.lat = lat;
    }

}

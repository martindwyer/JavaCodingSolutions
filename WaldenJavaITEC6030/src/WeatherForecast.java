public class WeatherForecast {
    private String skies="";
    private int high=0;
    private int low=0;

    public WeatherForecast() {
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public String getSkies() {
        return skies;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }
}

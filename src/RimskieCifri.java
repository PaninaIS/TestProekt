public enum RimskieCifri {
    I("1"),II("2"),III("3"),IV("4"),V("5"),VI("6"),VII("7"),VIII("8"),IX("9"),X("10");
    private String arabskie;
    RimskieCifri (String arabskie) {
        this.arabskie = arabskie;
    }
    public String getArabskie(){
        return arabskie;
    }
    public static RimskieCifri getRimByArab(String arabskie) {
        for (RimskieCifri rim : values()) {
            if (rim.getArabskie().equals(arabskie)) {
                return rim;
            }
        }
        throw new IllegalArgumentException("Соответствующая римская цифра  не найдена: [" + arabskie + "]");
    }
}

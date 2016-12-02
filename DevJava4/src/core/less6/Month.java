package core.less6;

import static core.less6.Season.*;

public enum Month {

	JANUARY(31, WINTER), FEBRUARY(28, WINTER),
	MARCH(31, SPRING), APRIL(30, SPRING),
	MAY(31, SPRING), JUNE(30, SUMMER),
	JULY(31, SUMMER), AUGUST(31, SUMMER),
	SEPTEMBER(30, AUTUMN), OCTOBER(31, AUTUMN),
	NOVEMBER(30, AUTUMN), DECEMBER(31, WINTER);
	
	private final int days;
	
	private final Season season;

	Month(int days, Season season) {
		this.days = days;
		this.season = season;
	}

	public int getDays() {
		return days;
	}

	public Season getSeason() {
		return season;
	}
}